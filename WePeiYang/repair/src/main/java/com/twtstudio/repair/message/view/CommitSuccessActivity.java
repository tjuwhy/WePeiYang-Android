package com.twtstudio.repair.message.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.evaluation.view.EvaluationActivity;

import butterknife.BindView;

public class CommitSuccessActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageView_message_success)
    ImageView successImageView;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_commit;
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

        successImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvaluationActivity.activityStart(CommitSuccessActivity.this);
            }
        });
    }


    public static void activityStart(Context context) {
        Intent intent = new Intent(context, CommitSuccessActivity.class);
        context.startActivity(intent);
    }
}
