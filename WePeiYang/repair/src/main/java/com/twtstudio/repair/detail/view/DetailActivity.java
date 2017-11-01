package com.twtstudio.repair.detail.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.complaint.view.ComplaintActivity;
import com.twtstudio.repair.detail.DeleteBean;
import com.twtstudio.repair.detail.DetailBean;
import com.twtstudio.repair.detail.DetailContract;
import com.twtstudio.repair.detail.presenter.DetailPresenterImpl;
import com.twtstudio.repair.evaluation.view.EvaluationActivity;
import com.twtstudio.repair.main.view.MainActivity;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import butterknife.BindView;
import butterknife.OnClick;

import static com.twtstudio.repair.detail.DetailContract.*;
import static com.umeng.socialize.utils.DeviceConfig.context;

/**
 * Created by tjwhm on 2017/8/22 8:04.
 * Happy coding!
 **/

public class DetailActivity extends DetailView implements View.OnClickListener {

    @BindView(R.id.repair_detail_onreceive_image)
    LinearLayout onReceiveImage;
    @BindView(R.id.repair_detail_onupdate_image)
    LinearLayout onUpdateImage;
    @BindView(R.id.repair_detail_onrepair_half_image)
    LinearLayout onRepairHalfImage;
    @BindView(R.id.repair_detail_onrepair_full_image)
    LinearLayout onRepairFullImage;
    @BindView(R.id.repair_detail_onfinish_image)
    LinearLayout onFinishImage;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.detail_type)
    TextView detail_type;
    @BindView(R.id.detail_description)
    TextView detail_description;
    @BindView(R.id.detail_place)
    TextView detail_place;
    @BindView(R.id.detail_time)
    TextView detail_time;

    @BindView(R.id.repair_detail_onreceive_linearlayout)
    LinearLayout onReceiveLinearLayout;
    @BindView(R.id.repair_detail_onrepair_half_linearlayout)
    LinearLayout onRepairHalfLinearLayout;
    @BindView(R.id.repair_detail_onrepair_half_complaint_linearlayout)
    LinearLayout onRepairHalfComplaintLinearLayout;
    @BindView(R.id.repair_detail_onrepair_full_linearlayout)
    LinearLayout onRepairFullLinearLayout;
    @BindView(R.id.repair_detail_onfinish_linearlayout)
    LinearLayout onFinishLinearLayout;

    @BindView(R.id.repair_detail_status_linearlayout)
    LinearLayout statusTextViewLayout;
    @BindView(R.id.repair_detail_num_linearlayout)
    LinearLayout numberTextViewLayout;
    @BindView(R.id.repair_detail_master_linearlayout)
    LinearLayout masterTextViewLayout;
    @BindView(R.id.repair_detail_master_phone_linearlayout)
    LinearLayout masterPhoneTextViewLayout;
    @BindView(R.id.repair_detail_expect_time_linearlayout)
    LinearLayout expectTimeTextViewLayout;

    @BindView(R.id.repair_detail_status_textview)
    TextView statusTextView;
    @BindView(R.id.repair_detail_num_textview)
    TextView numberTextView;
    @BindView(R.id.repair_detail_master_textview)
    TextView masterTextView;
    @BindView(R.id.repair_detail_master_phone_textview)
    TextView masterPhoneTextView;
    @BindView(R.id.repair_detail_expect_time_textview)
    TextView expectTimeTextView;

    @BindView(R.id.repair_detail_onreceive_button)
    TextView onReceiveButton;
    @BindView(R.id.repair_detail_onrepair_half_evaluation_button)
    TextView onRepairHalfEvaluationButton;
    @BindView(R.id.repair_detail_onrepair_half_complaint_button)
    TextView onRepairHalfComplaintButton;
    @BindView(R.id.repair_detail_onrepair_half_complaint_delete_button)
    TextView onRepairComplaintDeleteButton;
    @BindView(R.id.repair_detail_onrepair_full_button)
    TextView onRepairFullButton;
    @BindView(R.id.repair_detail_onfinish_button)
    TextView onFinishButton;

    @BindView(R.id.repair_detail_button_framelayout)
    FrameLayout frameLayout;
    DetailContract.DetailPresenter detailPresenter;

    int id;
    String[] status = {"报修信息已提交至维修方，请耐心等候", "维修方已接收报修信息", "维修方已确认维修完成(48h内可投诉）", "已确认维修完成，未评价", "已评价，维修完成", "已投诉"};


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_detail;
    }

    @Override
    protected Toolbar getToolbarView() {
        toolbar.setTitle("报修详情");
        return toolbar;
    }

    @Override
    protected boolean isShowBackArrow() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailPresenter = new DetailPresenterImpl(this);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);
        getData(id);

        onReceiveButton.setOnClickListener(this);
        onRepairHalfComplaintButton.setOnClickListener(this);
        onRepairHalfEvaluationButton.setOnClickListener(this);
        onRepairComplaintDeleteButton.setOnClickListener(this);
        onRepairFullButton.setOnClickListener(this);
        onFinishButton.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setInvisible ();
        getData(id);
    }

    public void onClick(View v) {
        if (v == onReceiveButton) {
            Intent intent = new Intent(this, EvaluationActivity.class);
            intent.putExtra("id", id);
            this.startActivity(intent);
        } else if (v == onRepairHalfEvaluationButton) {
            Intent intent = new Intent(this, EvaluationActivity.class);
            intent.putExtra("id", id);
            this.startActivity(intent);
        } else if (v == onRepairHalfComplaintButton) {
            Intent intent = new Intent(this, ComplaintActivity.class);
            intent.putExtra("id", id);
            this.startActivity(intent);
        } else if (v == onRepairComplaintDeleteButton) {
            deleteOrder(id);
        } else if (v == onRepairFullButton) {
            Intent intent = new Intent(this, EvaluationActivity.class);
            intent.putExtra("id", id);
            this.startActivity(intent);
        } else if (v == onFinishButton) {
            deleteOrder(id);
        }
    }

    @Override
    public void setData(DetailBean detailBean) {
        detail_type.setText(detailBean.data.items);
        detail_description.setText(detailBean.data.detail);
        detail_place.setText(detailBean.data.place.area.area_name + detailBean.data.place.room);
        detail_time.setText(detailBean.data.created_at);
        if (detailBean.data.complained == 0) {
            switch (detailBean.data.state) {
                case 0://已提交
                    onUpdateImage.setVisibility(View.VISIBLE);

                    statusTextView.setText(status[0] + "\n" + detailBean.data.created_at);
                    numberTextView.setText(String.valueOf(detailBean.data.id));

                    masterTextViewLayout.setVisibility(View.GONE);
                    masterPhoneTextViewLayout.setVisibility(View.GONE);
                    expectTimeTextViewLayout.setVisibility(View.GONE);

                    frameLayout.setVisibility(View.GONE);
                    onReceiveLinearLayout.setVisibility(View.INVISIBLE);
                    onRepairHalfLinearLayout.setVisibility(View.INVISIBLE);
                    onRepairHalfComplaintLinearLayout.setVisibility(View.INVISIBLE);
                    onRepairFullLinearLayout.setVisibility(View.INVISIBLE);
                    onFinishLinearLayout.setVisibility(View.INVISIBLE);
                    break;

                case 1://维修方已经接受
                    onReceiveImage.setVisibility(View.VISIBLE);

                    statusTextView.setText(status[1] + "\n" + detailBean.data.reacted_at + "\n\n" + status[0] + "\n" + detailBean.data.created_at);
                    numberTextView.setText(String.valueOf(detailBean.data.id));
                    masterTextView.setText(detailBean.data.accendant.accendant_name);
                    masterPhoneTextView.setText(detailBean.data.accendant.accendant_phone);
                    expectTimeTextView.setText(detailBean.data.predicted_at);

                    expectTimeTextViewLayout.setVisibility(View.GONE);

                    onReceiveLinearLayout.setVisibility(View.VISIBLE);
                    break;

                case 2://维修方确认维修完成
                    onRepairHalfImage.setVisibility(View.VISIBLE);

                    statusTextView.setText(status[2] + "\n" + detailBean.data.repaired_at + "\n\n" + status[1] + "\n" + detailBean.data.reacted_at + "\n\n" + status[0] + "\n" + detailBean.data.created_at);
                    numberTextView.setText(String.valueOf(detailBean.data.id));
                    masterTextView.setText(detailBean.data.accendant.accendant_name);
                    masterPhoneTextView.setText(detailBean.data.accendant.accendant_phone);
                    expectTimeTextView.setText(detailBean.data.predicted_at);

                    expectTimeTextViewLayout.setVisibility(View.GONE);

                    onRepairHalfLinearLayout.setVisibility(View.VISIBLE);
                    break;

                case 3://学生确认维修完成
                    onRepairFullImage.setVisibility(View.VISIBLE);
                    statusTextView.setText(status[3] + "\n" + detailBean.data.repaired_at + "\n\n" + status[2] + "\n" + detailBean.data.repaired_at + "\n\n" + status[1] + "\n" + detailBean.data.reacted_at + "\n\n" + status[0] + "\n" + detailBean.data.created_at);
                    numberTextView.setText(String.valueOf(detailBean.data.id));
                    masterTextView.setText(detailBean.data.accendant.accendant_name);
                    masterPhoneTextView.setText(detailBean.data.accendant.accendant_phone);
                    expectTimeTextView.setText(detailBean.data.predicted_at);

                    expectTimeTextViewLayout.setVisibility(View.GONE);

                    onRepairFullLinearLayout.setVisibility(View.VISIBLE);
                    break;

                case 4://报修结束
                    onFinishImage.setVisibility(View.VISIBLE);

                    statusTextView.setText(status[4] + "\n" + detailBean.data.grade.updated_at + "\n\n" + status[3] + "\n" + detailBean.data.repaired_at + "\n\n" + status[1] + "\n" + detailBean.data.reacted_at + "\n\n" + status[0] + "\n" + detailBean.data.created_at);
                    numberTextView.setText(String.valueOf(detailBean.data.id));
                    masterTextView.setText(detailBean.data.accendant.accendant_name);
                    masterPhoneTextView.setText(detailBean.data.accendant.accendant_phone);
                    expectTimeTextView.setText(detailBean.data.predicted_at);

                    expectTimeTextViewLayout.setVisibility(View.GONE);

                    onFinishLinearLayout.setVisibility(View.VISIBLE);
                    break;

            }
        } else if (detailBean.data.complained == 1) {//已投诉
            onRepairHalfImage.setVisibility(View.VISIBLE);

            statusTextView.setText(status[5] + "\n" + detailBean.data.complain.updated_at + "\n\n" + status[2] + "\n" + detailBean.data.repaired_at + "\n\n" + status[1] + "\n" + detailBean.data.reacted_at + "\n\n" + status[0] + "\n" + detailBean.data.created_at);
            numberTextView.setText(String.valueOf(detailBean.data.id));
            masterTextView.setText(detailBean.data.accendant.accendant_name);
            masterPhoneTextView.setText(detailBean.data.accendant.accendant_phone);
            expectTimeTextView.setText(detailBean.data.predicted_at);

            expectTimeTextViewLayout.setVisibility(View.GONE);

            onFinishLinearLayout.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void getData(int id) {
        detailPresenter.getData(id);

    }

    public void deleteCallBack(DeleteBean deleteBean) {
        Toast.makeText(this, "删除成功", Toast.LENGTH_LONG).show();
        finish();
    }

    public void deleteOrder(int id) {
        detailPresenter.deleteOrder(id);
    }

    public void setInvisible (){
        onUpdateImage.setVisibility(View.INVISIBLE);
        onReceiveImage.setVisibility(View.INVISIBLE);
        onRepairHalfImage.setVisibility(View.INVISIBLE);
        onRepairFullImage.setVisibility(View.INVISIBLE);
        onFinishImage.setVisibility(View.INVISIBLE);
        onRepairHalfImage.setVisibility(View.INVISIBLE);

        onReceiveLinearLayout.setVisibility(View.INVISIBLE);
        onRepairHalfLinearLayout.setVisibility(View.INVISIBLE);
        onRepairHalfComplaintLinearLayout.setVisibility(View.INVISIBLE);
        onRepairFullLinearLayout.setVisibility(View.INVISIBLE);
        onFinishLinearLayout.setVisibility(View.INVISIBLE);
    }



}
