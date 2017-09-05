package com.twtstudio.repair.evaluation.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.message.view.MessageActivity;
import com.twtstudio.retrox.auth.login.LoginActivity;

import butterknife.BindView;

public class EvaluationActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.button_commit_evaluation)
    Button commitButton;
    Intent intent = new Intent();


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_evaluation;
    }

    @Override
    protected Toolbar getToolbarView() {
        toolbar.setTitle("评价");
        return toolbar;
    }

    @Override
    protected boolean isShowBackArrow() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        commitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(EvaluationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public static void activityStart(Context context) {
        Intent intent = new Intent(context, EvaluationActivity.class);
        context.startActivity(intent);

    }
}
