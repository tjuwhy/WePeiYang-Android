package com.twtstudio.repair.main.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twtstudio.repair.R;
import com.twtstudio.repair.detail.DetailActivity;
import com.twtstudio.repair.message.view.MessageActivity;

/**
 * Created by liuyuesen on 2017/8/22.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {
    private Context context;

    RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main_recyclerview, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        view.setOnClickListener(v -> DetailActivity.activityStart(context));
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 15;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
        //ViewHolder
    }

}
