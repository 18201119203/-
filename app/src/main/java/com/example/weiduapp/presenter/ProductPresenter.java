package com.example.weiduapp.presenter;

import com.example.weiduapp.bean.BannerBean;
import com.example.weiduapp.bean.HomeListBean;
import com.example.weiduapp.bean.LoginBean;
import com.example.weiduapp.bean.RegBean;
import com.example.weiduapp.contract.ProductContract;
import com.example.weiduapp.model.ProductModel;
import com.google.gson.Gson;

import java.util.HashMap;

public class ProductPresenter extends ProductContract.ProductPresentervoid {


    @Override
    public void getLoginList(HashMap<String, String> params) {

        model.getLoginList(params, new ProductModel.IProductCallback() {
            @Override
            public void failure(String msg) {
                view.failure(msg);
            }

            @Override
            public void success(String result) {
                LoginBean loginBean = new Gson().fromJson(result, LoginBean.class);
                view.successlogin(loginBean);
            }

        });

    }

    @Override
    public void getRegList(HashMap<String, String> params) {

        model.getRegList(params, new ProductModel.IProductCallback() {
            @Override
            public void failure(String msg) {
                view.failure(msg);
            }

            @Override
            public void success(String result) {
                RegBean regBean = new Gson().fromJson(result, RegBean.class);
                view.successreg(regBean);
            }


        });
    }

    @Override
    public void getHomeList() {

        model.getHomeList(new ProductModel.IProductCallback() {
            @Override
            public void failure(String msg) {
                view.failure(msg);
            }

            @Override
            public void success(String result) {
                HomeListBean homeListBean = new Gson().fromJson(result, HomeListBean.class);
                view.successHomeData(homeListBean);
            }
        });
    }

    @Override
    public void getBannerList() {

        model.getBannerList(new ProductModel.IProductCallback() {
            @Override
            public void failure(String msg) {
                view.failure(msg);
            }

            @Override
            public void success(String result) {
                BannerBean bannerBean = new Gson().fromJson(result, BannerBean.class);
                view.successBanner(bannerBean);
            }
        });
    }


}
