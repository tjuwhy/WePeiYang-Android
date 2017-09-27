package com.twtstudio.repair.evaluation.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.twtstudio.repair.R;
import com.twtstudio.repair.complaint.view.ComplaintSuccessActivity;
import com.twtstudio.repair.evaluation.EvaluationBean;
import com.twtstudio.repair.evaluation.EvaluationContract;
import com.twtstudio.repair.evaluation.presenter.EvaluationPresenterImpl;
import com.twtstudio.repair.message.view.CommitSuccessActivity;
import com.twtstudio.retrox.auth.login.LoginActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class EvaluationActivity extends EvaluationContract.EvaluationView implements View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.repair_evaluation_speed_ratingbar)
    RatingBar speedRatingBar;
    @BindView(R.id.repair_evaluation_attitude_ratingbar)
    RatingBar attitudeRatingBar;
    @BindView(R.id.repair_evaluation_quality_ratingbar)
    RatingBar qualityRatingBar;
    @BindView(R.id.repair_evaluation_detail_textview)
    TextView detailTextView;
    @BindView(R.id.repair_evaluation_commit_button)
    Button commitButton;

    EvaluationContract.EvaluationPresenter evaluationPresenter;


    int id;

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

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);
        commitButton.setOnClickListener(this);
    }

    private Map<String, Object> getUpdateMap() {
        int orderId = id;
        int star1 = (int) speedRatingBar.getRating();
        int star2 = (int) attitudeRatingBar.getRating();
        int star3 = (int) qualityRatingBar.getRating();
        Map<String, Object> map = new HashMap<>();
        map.put("order_id", orderId);
        map.put("star_1", star1);
        map.put("star_2", star2);
        map.put("star_3", star3);
        map.put("comment", detailTextView.getText());
        return map;
    }

    @Override
    public void EvaluationCallBack(EvaluationBean evaluationBean) {
        Intent intent = new Intent();
        intent.putExtra("message",evaluationBean.message);
        intent.setClass(this, EvaluationSuccessActivity.class);
        this.startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v == commitButton) {
            evaluationPresenter = new EvaluationPresenterImpl(this);
            evaluationPresenter.postData(getUpdateMap());
        }
    }
}
