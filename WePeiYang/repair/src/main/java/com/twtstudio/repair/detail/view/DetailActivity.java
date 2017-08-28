package com.twtstudio.repair.detail.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.message.view.MessageActivity;

import butterknife.BindView;

/**
 * Created by tjwhm on 2017/8/22 8:04.
 * Happy coding!
 **/

public class DetailActivity extends BaseActivity implements DetailContract.DetailPresenter {

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
    @BindView(R.id.cardview_detail_onupdate)
    CardView cardview_detail_onupdate;
    @BindView(R.id.cardview_detail_onreceive)
    CardView cardview_detail_onreceive;
    @BindView(R.id.cardview_detail_onrepair_half)
    CardView cardview_detail_onrepair_half;
    @BindView(R.id.cardview_detail_onrepair_full)
    CardView cardview_detail_onrepair_full;
    @BindView(R.id.cardview_detail_onfinish)
    CardView cardview_detail_onfinish;


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
    }

    @Override
    public void setDetailData(DetailBean detailBean) {
        detail_type.setText("");
        detail_description.setText("");
        detail_place.setText("");
        detail_time.setText("");
    }

    public static void activityStart(Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        context.startActivity(intent);
    }
}
