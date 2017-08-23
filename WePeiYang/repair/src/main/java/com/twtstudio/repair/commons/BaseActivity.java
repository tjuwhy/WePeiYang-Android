package com.twtstudio.repair.commons;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import butterknife.ButterKnife;

/**
 * Created by tjwhm on 2017/8/23 8:28.
 * Happy coding!
 **/

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;

    protected abstract int getLayoutResourceId();

    protected abstract Toolbar getToolbarView();

    protected abstract boolean isShowBackArrow();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutResourceId());
        ButterKnife.bind(this);
        toolbar = getToolbarView();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (isShowBackArrow() && getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(view -> onBackPressed());
            }
        }
    }
}
