package com.twtstudio.repair.detail.presenter;

import com.twtstudio.repair.detail.DetailBean;
import com.twtstudio.repair.detail.DetailContract;
import com.twtstudio.repair.detail.model.DetailApiClient;

/**
 * Created by liuyuesen on 2017/9/14.
 */


public class DetailPresenterImpl extends DetailContract.DetailPresenter {
    DetailContract.DetailModel detailModel;
    DetailContract.DetailView detailView;

    public DetailPresenterImpl(DetailContract.DetailView detailView) {
        this.detailView = detailView;
    }

    @Override
    public void setData(DetailBean detailBean) {
        detailView.setData(detailBean);
    }

    @Override
    public void getData(int id) {
        detailModel = new DetailApiClient(DetailPresenterImpl.this);
        detailModel.getData(id);
    }

    public void deleteOrder(int id){
        detailModel.deleteOrder(id);
    }
}


