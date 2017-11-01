package com.twtstudio.repair.complaint.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.complaint.ComplaintBean;
import com.twtstudio.repair.complaint.ComplaintContract;
import com.twtstudio.repair.complaint.presenter.ComplaintPresenterImpl;
import com.twtstudio.repair.evaluation.view.EvaluationSuccessActivity;

import butterknife.BindView;

public class ComplaintActivity extends ComplaintContract.ComplaintView implements View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.button_commit_complaint)
    Button complaintCommitButton;
    @BindView(R.id.editText_reason_complaint)
    EditText complaintReasonEditText;
    @BindView(R.id.editText_detail_complaint)
    EditText complaintDetailEditText;
    ComplaintContract.ComplaintPresenter complaintPresenter;
    boolean onLoading;
    int id;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_complaint;
    }

    @Override
    protected Toolbar getToolbarView() {
        toolbar.setTitle("投诉");
        return toolbar;
    }

    @Override
    protected boolean isShowBackArrow() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);

        complaintCommitButton.setOnClickListener(this);
    }

    @Override
    public void complaintCallBack(ComplaintBean complaintBean) {
        onLoading = false;
        Intent intent = new Intent();
        intent.putExtra("message", complaintBean.message);
        intent.setClass(this, ComplaintSuccessActivity.class);
        this.startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View v) {
        if (v == complaintCommitButton) {
            if (onLoading == false){
                complaintPresenter = new ComplaintPresenterImpl(this);
                String reason = complaintReasonEditText.getText().toString();
                String detail = complaintDetailEditText.getText().toString();
                if (reason.equals("") == false && detail.equals("") == false) {
                    complaintPresenter.postData(id, reason, detail);
                    onLoading = true;
                } else if (reason.equals("")) {
                    Toast.makeText(this, "请您填写投诉原因", Toast.LENGTH_SHORT).show();
                } else if (detail.equals("")) {
                    Toast.makeText(this, "请您填写投诉详情", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
