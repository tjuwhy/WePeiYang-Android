package com.twtstudio.repair.evaluation.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.message.view.MessageActivity;

import butterknife.BindView;

public class EvaluationActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;


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
    }

    public static void activityStart(Context context) {
        Intent intent = new Intent(context, EvaluationActivity.class);
        context.startActivity(intent);


    }
}
