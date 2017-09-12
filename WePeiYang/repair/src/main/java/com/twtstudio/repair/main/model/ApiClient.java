package com.twtstudio.repair.main.model;

import com.twtstudio.repair.main.MainContract;
import com.twtstudio.repair.main.presenter.MainPresenterImpl;

/**
 * Created by liuyuesen on 2017/9/4.
 */

public class ApiClient extends MainContract.MainModel {
    MainApi mainApi;
    MainContract.MainPresenter mainPresenter;

    public ApiClient (MainContract.MainPresenter mainPresenter){
        this.mainPresenter =  mainPresenter;
    }


    public void getData(){

    }


    public void setData(){

    }
}
