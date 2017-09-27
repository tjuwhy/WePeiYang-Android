package com.twtstudio.repair.main.view;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseBean;
import com.twtstudio.repair.evaluation.view.EvaluationActivity;
import com.twtstudio.repair.main.MainBean;
import com.twtstudio.repair.main.MainContract;
import com.twtstudio.repair.main.presenter.MainPresenterImpl;
import com.twtstudio.repair.message.view.MessageActivity;
import com.twtstudio.retrox.auth.login.LoginActivity;

import java.util.ArrayList;

import butterknife.BindView;

import static com.twtstudio.repair.main.MainContract.*;


public class MainActivity extends MainContract.MainView {
    final private int RED = 110;
    final private int GREEN = 111;
    final private int BLUE = 112;
    final private int YELLOW = 113;
    final private int GRAY= 114;
    final private int CYAN= 115;
    final private int BLACK= 116;
    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.main_refresh)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab_main)
    FloatingActionButton floatingActionButton;
    RecyclerViewAdapter recyclerViewAdapter;
    LinearLayoutManager layoutManager;
    MainContract.MainPresenter mainPresenter;
    MainBean mainBean = new MainBean();

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
        menu.add(1,RED,4,"红色");
        menu.add(1,GREEN,2,"绿色");
        menu.add(1,BLUE,3,"蓝色");
        menu.add(1,YELLOW,1,"黄色");
        menu.add(1,GRAY,5,"灰色");
        menu.add(1,CYAN,6,"蓝绿色");
        menu.add(1,BLACK,7,"黑色");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case RED:
                break;
            case GREEN:
                break;
            case BLUE:
                break;
            case YELLOW:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case GRAY:
                break;
            case CYAN:
                break;
            case BLACK:
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
        mainPresenter.getData();
        floatingActionButton.show(true);
        floatingActionButton.hide(false);

        floatingActionButton.setOnClickListener(v -> MessageActivity.activityStart(MainActivity.this));

        refreshLayout.setOnRefreshListener(() -> {
            if ( isLoadingData == false){
                isLoadingData = true;
                mainPresenter.getData();
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

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.getData();
    }

    @Override
    public void getData() {
        mainPresenter.getData();
    }

    @Override
    public void setData(MainBean mainBean) {
        refreshLayout.setRefreshing(false);
        this.mainBean.data.clear();
        this.mainBean.data.addAll(mainBean.data);
        recyclerViewAdapter.notifyDataSetChanged();
        isLoadingData = false;
    }

}
