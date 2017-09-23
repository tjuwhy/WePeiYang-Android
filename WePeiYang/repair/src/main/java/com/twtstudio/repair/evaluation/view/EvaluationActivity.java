package com.twtstudio.repair.evaluation.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.evaluation.EvaluationBean;
import com.twtstudio.repair.evaluation.EvaluationContract;
import com.twtstudio.repair.message.view.MessageActivity;
import com.twtstudio.retrox.auth.login.LoginActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class EvaluationActivity extends EvaluationContract.EvaluationView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.RatingBar_speed_evaluation)
    RatingBar speedRatingBar;
    @BindView(R.id.RatingBar_attitude_evaluation)
    RatingBar attitudeRatingBar;
    @BindView(R.id.RatingBar_quality_evaluation)
    RatingBar qualityRatingBar;
    @BindView(R.id.repair_evaluation_detail_textview)
    TextView detailTextView;
    @BindView(R.id.repair_evaluation_commit_button)
    Button commitButton;

    Intent intent = new Intent();

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

    private Map<String, Object> getUpdateMap() {
        String orderId = String.valueOf(id);
        String star1 = String.valueOf(speedRatingBar.getRating());
        String star2 = String.valueOf(attitudeRatingBar.getRating());
        String star3 = String.valueOf(qualityRatingBar.getRating());
        Map<String, Object> map = new HashMap<>();
        map.put("order_id", orderId);
        map.put("star_1", star1);
        map.put("star_2", star2);
        map.put("star_3", star3);
        map.put("comment",detailTextView.getText());
        return map;
    }

    @Override
    public void EvaluationCallBack (EvaluationBean evaluationBean){

    }

}
