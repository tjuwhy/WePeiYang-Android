package com.twtstudio.repair.main;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by liuyuesen on 2017/8/22.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private  Context context;
    RecyclerViewAdapter (Context context){
         this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
