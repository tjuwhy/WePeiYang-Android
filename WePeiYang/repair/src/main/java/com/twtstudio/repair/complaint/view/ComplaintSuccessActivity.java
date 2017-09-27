package com.twtstudio.repair.complaint.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.complaint.ComplaintBean;

import java.util.Objects;

import butterknife.BindView;

public class ComplaintSuccessActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.repair_complaint_success_image)
    CardView complaintSuccessImage;
    @BindView(R.id.repair_complaint_fail_image)
    CardView complaintFailImage;

    String message;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_complaint_success;
    }

    @Override
    protected Toolbar getToolbarView() {
        toolbar.setTitle("提交成功");
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
        message = intent.getStringExtra("message");
        if (Objects.equals(message, "")) {
            complaintSuccessImage.setVisibility(View.VISIBLE);
            Toast.makeText(this, "添加评分成功", Toast.LENGTH_LONG).show();

        } else if (message.equals("已经添加过评分")) {
            complaintFailImage.setVisibility(View.VISIBLE);
            Toast.makeText(this, "您已经添加过评分啦", Toast.LENGTH_LONG).show();
        } else if (message.equals("评分添加失败")) {
            complaintFailImage.setVisibility(View.VISIBLE);
            Toast.makeText(this, "评分添加失败", Toast.LENGTH_LONG).show();
        } else {
            complaintFailImage.setVisibility(View.VISIBLE);
            Toast.makeText(this, "评分添加失败", Toast.LENGTH_LONG).show();
        }
    }
}
