package com.twtstudio.repair.main.view;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseBean;
import com.twtstudio.repair.evaluation.view.EvaluationActivity;
import com.twtstudio.repair.evaluation.view.EvaluationSuccessActivity;
import com.twtstudio.repair.main.MainBean;
import com.twtstudio.repair.main.MainContract;
import com.twtstudio.repair.main.presenter.MainPresenterImpl;
import com.twtstudio.repair.message.view.MessageActivity;
import com.twtstudio.retrox.auth.login.LoginActivity;

import java.util.ArrayList;

import butterknife.BindView;

import static com.twtstudio.repair.main.MainContract.*;


public class MainActivity extends MainContract.MainView {
    final private int YELLOW = 113;
    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.main_refresh)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab_main)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.repair_main_no_message)
    LinearLayout noMessageLinearLayout;
    RecyclerViewAdapter recyclerViewAdapter;
    LinearLayoutManager layoutManager;
    MainContract.MainPresenter mainPresenter;
    MainBean mainBean = new MainBean();

    boolean haveData = false;
    int mPreviousVisibleItem = 1;
    boolean isLoadingData = false;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected Toolbar getToolbarView() {
        toolbar.setTitle("宿舍报修");
        return toolbar;
    }

    @Override
    protected boolean isShowBackArrow() {
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, YELLOW, 1, "登录");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case YELLOW:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter = new MainPresenterImpl(MainActivity.this);
        layoutManager = new LinearLayoutManager(this);
        mainBean.data = new ArrayList<>();
        recyclerViewAdapter = new RecyclerViewAdapter(this, mainBean);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        onNoData(haveData);
        floatingActionButton.show(true);
//        floatingActionButton.hide(false);

        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, MessageActivity.class);
            startActivity(intent);
        });

        refreshLayout.setOnRefreshListener(() -> {
            if (isLoadingData == false) {
                isLoadingData = true;
                mainPresenter.getData();
                floatingActionButton.show(true);
            }

        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                if (firstVisibleItem > mPreviousVisibleItem) {
                    floatingActionButton.hide(true);
                } else if (firstVisibleItem < mPreviousVisibleItem) {
                    floatingActionButton.show(true);
                }
                mPreviousVisibleItem = firstVisibleItem;

                int totalCount = layoutManager.getItemCount();
                int lastPositions;
                int lastNumber = 0;
                lastPositions = layoutManager.findLastVisibleItemPosition();
                if (judgeOnButtom(lastPositions,totalCount) == true && lastNumber != lastPositions){
                    Toast.makeText(MainActivity.this, "已经到底啦",Toast.LENGTH_SHORT).show();
                    lastNumber = lastPositions;
                }
            }

            private boolean judgeOnButtom (int lostPosition,int totalCount){
                if (lostPosition == totalCount){
                    return true;
                }
                else{
                    return false;
                }
            }
        });
    }

    private void onNoData (boolean haveData){
        if (haveData){
            recyclerView.setVisibility(View.VISIBLE);
            noMessageLinearLayout.setVisibility(View.INVISIBLE);
        }
        else{
            recyclerView.setVisibility(View.INVISIBLE);
            noMessageLinearLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.getData();
    }

    @Override
    public void getData() {
        refreshLayout.setRefreshing(true);
        mainPresenter.getData();
    }

    @Override
    public void setData(MainBean mainBean) {
        refreshLayout.setRefreshing(false);
        this.mainBean.data.clear();
        this.mainBean.data.addAll(mainBean.data);
        recyclerViewAdapter.notifyDataSetChanged();
        isLoadingData = false;
        if (this.mainBean.data != null){
            haveData = true;
        }
        else{
            haveData = false;
        }
        onNoData(haveData);
    }

}
