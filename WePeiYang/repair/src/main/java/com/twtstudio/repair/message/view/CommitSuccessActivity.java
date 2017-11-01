package com.twtstudio.repair.message.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.twtstudio.repair.R;
import com.twtstudio.repair.message.MessageContract;

import java.util.Objects;

import butterknife.BindView;

public class CommitSuccessActivity extends MessageContract.MessageView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.repair_evaluation_commit_success_image)
    CardView commitSuccessCardView;
    @BindView(R.id.repair_evaluation_commit_fail_image)
    CardView commitFailardCardView;

    String message;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_commit_success;
    }

    @Override
    protected Toolbar getToolbarView() {
        toolbar.setTitle("报修成功");
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
        if (message == null) {
            commitSuccessCardView.setVisibility(View.VISIBLE);
            Toast.makeText(this,"报修成功", Toast.LENGTH_LONG).show();
        }
        else {
            commitFailardCardView.setVisibility(View.VISIBLE);
            Toast.makeText(this,"报修失败",Toast.LENGTH_LONG).show();
        }
    }
}
