package com.twtstudio.repair.complaint.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;

import butterknife.BindView;

public class ComplaintActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.button_commit_complaint)
    Button complaintCommitButton;

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

        complaintCommitButton.setOnClickListener(v -> ComplaintSuccessActivity.activityStart(ComplaintActivity.this));
    }

    public static void activityStart(Context context) {
        Intent intent = new Intent(context, ComplaintActivity.class);
        context.startActivity(intent);
    }
}
