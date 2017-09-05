package com.twtstudio.repair.complaint.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;

import butterknife.BindView;

public class ComplaintSuccessActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

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
    }

    public static void activityStart(Context context) {
        Intent intent = new Intent(context, ComplaintSuccessActivity.class);
        context.startActivity(intent);
    }
}
