package com.example.weiduapp.contract;

import com.example.lib_core.base.mvp.BaseView;
import com.example.lib_core.base.mvp.Basemodel;
import com.example.lib_core.base.mvp.Basepresenter;
import com.example.weiduapp.bean.BannerBean;
import com.example.weiduapp.bean.HomeListBean;
import com.example.weiduapp.bean.LoginBean;
import com.example.weiduapp.bean.RegBean;
import com.example.weiduapp.model.ProductModel;

import java.util.HashMap;

public interface ProductContract {


    abstract class ProductPresentervoid extends Basepresenter<IProductModel,IProductView>  {
        @Override
        public IProductModel getModel() {
            return new ProductModel();
        }
        public abstract void getLoginList(HashMap<String,String> params);
        public abstract void getRegList(HashMap<String,String> params);
        public abstract void getHomeList();
        public abstract void  getBannerList();
    }

    interface IProductModel extends Basemodel {
        void  getLoginList(HashMap<String,String> params, ProductModel.IProductCallback callback);
        void  getRegList(HashMap<String,String> params, ProductModel.IProductCallback callback);
        void  getHomeList(ProductModel.IProductCallback callback);
        void  getBannerList(ProductModel.IProductCallback callback);

    }

    interface IProductView extends BaseView {

        void successreg(RegBean regBean);
        void successlogin(LoginBean loginBean);
        void successHomeData(HomeListBean homeListBean);
        void successBanner(BannerBean bannerBean);
    }



}
