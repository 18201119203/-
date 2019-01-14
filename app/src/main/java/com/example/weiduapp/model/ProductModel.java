package com.example.weiduapp.model;

import com.example.lib_core.net.OkHttpCallback;
import com.example.lib_core.net.OkHttpUtils;
import com.example.weiduapp.api.Api;
import com.example.weiduapp.contract.ProductContract;

import java.util.HashMap;

public class ProductModel implements ProductContract.IProductModel {


    /**
     * 登陆
     * @param params
     * @param callback
     */
    @Override
    public void getLoginList(HashMap<String, String> params, final IProductCallback callback) {

        OkHttpUtils.getInstance().doPost(Api.LOGIN_URL, params, new OkHttpCallback() {
            @Override
            public void failure(String msg) {
                if (callback!=null){
                    callback.failure(msg);
                }
            }

            @Override
            public void success(String response) {
                if (callback!=null){
                    callback.success(response);
                }
            }

        });
    }
    /**
     * 注册
     * @param params
     * @param callback
     */
    @Override
    public void getRegList(HashMap<String, String> params, final IProductCallback callback) {
        OkHttpUtils.getInstance().doPost(Api.REG_URL, params, new OkHttpCallback() {
            @Override
            public void failure(String msg) {
                if (callback!=null){
                    callback.failure(msg);
                }
            }

            @Override
            public void success(String response) {
                if (callback!=null){
                    callback.success(response);
                }
            }

        });
    }

    /**
     * 首页
     * @param callback
     */
    @Override
    public void getHomeList(final IProductCallback callback) {

        OkHttpUtils.getInstance().doGet(Api.HOME_LIST, new OkHttpCallback() {
            @Override
            public void failure(String msg) {
                if (callback!=null){
                    callback.failure(msg);
                }
            }

            @Override
            public void success(String response) {
                if (callback!=null){
                    callback.success(response);
                }
            }
        });

    }


    /**
     * Banner
     * @param callback
     */
    @Override
    public void getBannerList(final IProductCallback callback) {

        OkHttpUtils.getInstance().doGet(Api.HOME_BANNER, new OkHttpCallback() {
            @Override
            public void failure(String msg) {
                if (callback!=null){
                    callback.failure(msg);
                }
            }

            @Override
            public void success(String response) {
                if (callback!=null){
                    callback.success(response);
                }
            }
        });

    }

    public interface IProductCallback {
        void failure(String msg);
        void success(String result);

    }
}
