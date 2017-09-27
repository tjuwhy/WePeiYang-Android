package com.twtstudio.repair.complaint.presenter;

import com.twtstudio.repair.complaint.ComplaintBean;
import com.twtstudio.repair.complaint.ComplaintContract;
import com.twtstudio.repair.complaint.model.ComplaintApiClient;
import com.twtstudio.repair.main.MainBean;

/**
 * Created by liuyuesen on 2017/9/22.
 */

public class ComplaintPresenterImpl extends ComplaintContract.ComplaintPresenter {
    ComplaintContract.ComplaintModel complaintModel;
    ComplaintContract.ComplaintView complaintView;

    public ComplaintPresenterImpl(ComplaintContract.ComplaintView complaintView) {
        this.complaintView = complaintView;
    }

    @Override
    public void postData(int order_id, String reason, String detail) {
        complaintModel = new ComplaintApiClient(this);
        complaintModel.postData(order_id, reason, detail);
    }

    @Override
    public void complaintCallBack(ComplaintBean complaintBean) {
        complaintView.complaintCallBack(complaintBean);
    }

}
