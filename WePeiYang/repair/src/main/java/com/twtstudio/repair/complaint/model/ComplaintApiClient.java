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
    public void postData(ComplaintBean complaintBean) {
        complaintApi = RetrofitProvider.getRetrofit().create(ComplaintApi.class);
        complaintApi.setComplaintData(complaintBean.data.order_id,complaintBean.data.reason,complaintBean.data.detail)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }
}
