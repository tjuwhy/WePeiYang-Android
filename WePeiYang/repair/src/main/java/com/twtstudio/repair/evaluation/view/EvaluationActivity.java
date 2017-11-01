package com.twtstudio.repair.evaluation.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.twtstudio.repair.R;
import com.twtstudio.repair.complaint.view.ComplaintSuccessActivity;
import com.twtstudio.repair.detail.view.DetailActivity;
import com.twtstudio.repair.evaluation.EvaluationBean;
import com.twtstudio.repair.evaluation.EvaluationContract;
import com.twtstudio.repair.evaluation.presenter.EvaluationPresenterImpl;
import com.twtstudio.repair.message.view.CommitSuccessActivity;
import com.twtstudio.retrox.auth.login.LoginActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    DetailActivity detailActivity;

    EvaluationContract.EvaluationPresenter evaluationPresenter;


    int id;
    AlertDialog.Builder dialog = null;

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
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> {
            dialog = new AlertDialog.Builder(EvaluationActivity.this);
            dialog.setTitle("请您完成评价");
            dialog.setMessage("请您认真对维修工作进行评价，这将关系到工人的绩效评定");
            dialog.setPositiveButton("现在就去", (dialog1, which) -> onResume());
            dialog.setNegativeButton("稍后评价", (dialog12, which) -> finish());
            dialog.show();
        });
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);
        commitButton.setOnClickListener(this);
    }

    private Map<String, Object> getUpdateMap() {
        int orderId = id;
        int star1 = (int) speedRatingBar.getRating();
        int star2 = (int) attitudeRatingBar.getRating();
        int star3 = (int) qualityRatingBar.getRating();
        if (detailTextView.getText().equals("")){
            Toast.makeText(this,"请您认真填写评价哦",Toast.LENGTH_LONG).show();
            return null;
        }else{
            Map<String, Object> map = new HashMap<>();
            map.put("order_id", orderId);
            map.put("star_1", star1);
            map.put("star_2", star2);
            map.put("star_3", star3);
            map.put("comment", detailTextView.getText());
            return map;
        }
    }

    @Override
    public void EvaluationCallBack(EvaluationBean evaluationBean) {
        Intent intent = new Intent();
        intent.putExtra("message", evaluationBean.message);
        intent.setClass(this, EvaluationSuccessActivity.class);
        this.startActivity(intent);
        finish();

    }

    @Override
    public void onClick(View v) {
        if (v == commitButton) {
            evaluationPresenter = new EvaluationPresenterImpl(this);
            Map<String,Object> map = getUpdateMap();
            if (map != null){
                evaluationPresenter.postData(getUpdateMap());
            }
        }
    }
}
