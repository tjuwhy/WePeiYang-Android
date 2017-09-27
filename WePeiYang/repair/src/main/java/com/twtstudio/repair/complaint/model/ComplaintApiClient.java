package com.twtstudio.repair.complaint.model;

import com.twt.wepeiyang.commons.network.RetrofitProvider;
import com.twtstudio.repair.complaint.ComplaintBean;
import com.twtstudio.repair.complaint.ComplaintContract;
import com.twtstudio.repair.main.MainBean;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liuyuesen on 2017/9/22.
 */

public class ComplaintApiClient extends ComplaintContract.ComplaintModel {
    ComplaintContract.ComplaintPresenter complaintPresenter;
    ComplaintApi complaintApi;

    public ComplaintApiClient(ComplaintContract.ComplaintPresenter complaintPresenter) {
        this.complaintPresenter = complaintPresenter;
    }

    @Override
    public void postData(int order_id, String reason, String detail) {
        complaintApi = RetrofitProvider.getRetrofit().create(ComplaintApi.class);
        complaintApi.setComplaintData(order_id, reason, detail)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }

    @Override
    public void complaintCallBack(ComplaintBean complaintBean) {
        complaintPresenter.complaintCallBack(complaintBean);
    }
}
