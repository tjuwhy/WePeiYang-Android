package com.twtstudio.tjliqy.party.ui.submit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.twtstudio.tjliqy.party.R;
import com.twtstudio.tjliqy.party.R2;
import com.twtstudio.tjliqy.party.ui.BaseActivity;
import com.twtstudio.tjliqy.party.ui.submit.detail.SubmitDetailActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dell on 2016/7/18.
 */
public class SubmitActivity extends BaseActivity {

    @BindView(R2.id.toolbar)
    Toolbar toolbar;
    @BindView(R2.id.bt_submit_to_application)
    Button btSubmitToApplication;
    @BindView(R2.id.bt_submit_to_report)
    Button btSubmitToReport;
    @BindView(R2.id.bt_submit_to_summary)
    Button btSubmitToSummary;
    @BindView(R2.id.bt_submit_to_positive)
    Button btSubmitToPositive;
    @BindView(R2.id.tv_submit_application)
    TextView tvSubmitApplication;
    @BindView(R2.id.tv_submit_report)
    TextView tvSubmitReport;
    @BindView(R2.id.tv_submit_summary)
    TextView tvSubmitSummary;
    @BindView(R2.id.tv_submit_positive)
    TextView tvSubmitPositive;

    private static final int TYPE_APPLICATION = 0;
    private static final int TYPE_REPORT = 1;
    private static final int TYPE_SUMMARY = 2;
    private static final int TYPE_POSITIVE = 3;


    private static final String ID = "submit_id";
    private static final String TYPE = "submit_type";
    private static final String TEXT = "submit_text";

    private int submitId;
    private String submitType;
    private String submitText;

    private boolean[] clickable = {false, false, false, false};

    @Override
    public int getContentViewId() {
        return R.layout.activity_party_submit;
    }

    @Override
    public void preInitView() {
        Intent intent = getIntent();
        submitId = intent.getIntExtra(ID, -1);
        submitType = intent.getStringExtra(TYPE);
        submitText = intent.getStringExtra(TEXT);
    }

    @Override
    public void initView() {
        setView(tvSubmitApplication, btSubmitToApplication, 0, 0, TYPE_APPLICATION);
        setView(tvSubmitReport, btSubmitToReport, 4, 7, TYPE_REPORT);
        setView(tvSubmitSummary, btSubmitToSummary, 21, 24, TYPE_SUMMARY);
        setView(tvSubmitPositive, btSubmitToPositive, 26, 26, TYPE_POSITIVE);
    }

    @Override
    public void afterInitView() {

    }

    @Override
    public Toolbar getToolbar() {
        toolbar.setTitle(R.string.submit_party);
        return toolbar;
    }

    @Override
    public int getMenu() {
        return 0;
    }

    public static void actionStart(Context context, int submitId, String submitType, String submitText) {
        Intent intent = new Intent(context, SubmitActivity.class);
        intent.putExtra(ID, submitId);
        intent.putExtra(TYPE, submitType);
        intent.putExtra(TEXT, submitText);
        context.startActivity(intent);
    }

    private void setView(TextView textView, Button button, int startId, int endId, int type_id) {
        if (submitId >= startId && submitId <= endId && !"".equals(submitText)) {
            button.setBackgroundResource(R.drawable.shape_button_red);
            textView.setText(submitText);
            clickable[type_id] = true;
        } else if (submitId > startId && !"".equals(submitText)) {
            button.setBackgroundResource(R.drawable.shape_button_green);
            textView.setText("已完成");
        } else if (submitId < startId) {
            textView.setText("无法递交");
        }
    }

    @OnClick({R2.id.bt_submit_to_application, R2.id.bt_submit_to_report, R2.id.bt_submit_to_summary, R2.id.bt_submit_to_positive})
    void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bt_submit_to_application) {
            clickHelper(TYPE_APPLICATION);
        } else if (id == R.id.bt_submit_to_report) {
            clickHelper(TYPE_REPORT);
        } else if (id == R.id.bt_submit_to_summary) {
            clickHelper(TYPE_SUMMARY);
        } else if (id == R.id.bt_submit_to_positive) {
            clickHelper(TYPE_POSITIVE);
        }
    }

    private void clickHelper(int type) {
        if (clickable[type]) {
            SubmitDetailActivity.actionStart(this, submitType, submitText);
        } else {
            Toast.makeText(SubmitActivity.this, "无法递交", Toast.LENGTH_SHORT).show();
        }
    }
}
