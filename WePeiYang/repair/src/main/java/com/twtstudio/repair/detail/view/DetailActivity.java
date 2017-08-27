package com.twtstudio.repair.detail.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by tjwhm on 2017/8/22 8:04.
 * Happy coding!
 **/

public class DetailActivity extends BaseActivity implements DetailCotract.DetailPresenter {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

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
}
