package com.example.weiduapp.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.lib_core.base.mvp.BasemvpFragment;
import com.example.lib_core.base.mvp.Basepresenter;
import com.example.weiduapp.R;
import com.example.weiduapp.activity.LoginActivity;
import com.example.weiduapp.adapter.HomeListAdapter;
import com.example.weiduapp.bean.BannerBean;
import com.example.weiduapp.bean.HomeListBean;
import com.example.weiduapp.bean.LoginBean;
import com.example.weiduapp.bean.RegBean;
import com.example.weiduapp.contract.ProductContract;
import com.example.weiduapp.presenter.ProductPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends BasemvpFragment<ProductContract.IProductModel,ProductContract.ProductPresentervoid> implements ProductContract.IProductView {


    private Unbinder bind;
    @BindView(R.id.lv)
    RecyclerView lv;
    private HomeListAdapter homeListAdapter;



    @Override
    protected int getViewId() {
        return R.layout.fragmenthome;
    }

    @Override
    protected void initView(View view) {
        bind = ButterKnife.bind(this, view);
        lv.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeListAdapter = new HomeListAdapter(getActivity());
        lv.setAdapter(homeListAdapter);
    }

    @Override
    public Basepresenter initPresenter() {
        return new ProductPresenter();
    }

    @Override
    protected void initpresenter() {
        presenter.getHomeList();
        presenter.getBannerList();
    }


    /**
     * 数据获取成功
     * @param homeListBean
     */
    @Override
    public void successHomeData(HomeListBean homeListBean) {
        homeListAdapter.setList(homeListBean.result,homeListBean.result.rxxp,homeListBean.result.pzsh,homeListBean.result.mlss);

    }

    @Override
    public void successBanner(BannerBean bannerBean) {

        homeListAdapter.setListBanner(bannerBean.getResult());

    }

    @Override
    public void failure(String msg) {

        Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind!=null){
            bind.unbind();
        }
    }



    /**
     * 无用
     * @param regBean
     */
    @Override
    public void successreg(RegBean regBean) { }

    @Override
    public void successlogin(LoginBean loginBean) { }


}
