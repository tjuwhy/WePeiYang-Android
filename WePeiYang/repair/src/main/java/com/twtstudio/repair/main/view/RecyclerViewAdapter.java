package com.twtstudio.repair.main.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twtstudio.repair.R;
import com.twtstudio.repair.detail.view.DetailActivity;
import com.twtstudio.repair.main.MainBean;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liuyuesen on 2017/8/22.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {
    private Context context;
    MainBean mainBean;

    //这里就相当于实例化了一个item
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_item_textView)
        TextView itemTitle;
        @BindView(R.id.type_item_textView)
        TextView itemType;
        @BindView(R.id.location_item_textView)
        TextView itemLocation;
        @BindView(R.id.time_item_textView)
        TextView itemTime;
        @BindView(R.id.status_item_textView)
        TextView itemStatus;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    RecyclerViewAdapter(Context context, MainBean mainBean) {
        this.context = context;
        this.mainBean = mainBean;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main_recyclerview, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        //view.setOnClickListener(v -> DetailActivity.activityStart(context));
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (mainBean.data.size() != 0) {
            MainBean.DataBean dataBean = mainBean.data.get(position);
            ItemViewHolder itemViewHolder = holder;
            itemViewHolder.itemTitle.setText(dataBean.detail);
            itemViewHolder.itemType.setText(dataBean.items);
            itemViewHolder.itemLocation.setText(dataBean.place.area.area_name + dataBean.place.room);
            //itemViewHolder.itemTime.setText(dataBean.times);
            if (dataBean.complained == 0) {
                if (dataBean.state == 4) {
                    itemViewHolder.itemStatus.setText("已完成");
                    itemViewHolder.itemStatus.setTextColor(Color.rgb(128, 255, 00));
                } else if (dataBean.state == 3) {
                    itemViewHolder.itemStatus.setText("已确认");
                    itemViewHolder.itemStatus.setTextColor(Color.rgb(128, 255, 00));
                } else if (dataBean.state == 2) {
                    itemViewHolder.itemStatus.setText("已维修");
                    itemViewHolder.itemStatus.setTextColor(Color.rgb(128, 255, 00));
                } else if (dataBean.state == 1) {
                    itemViewHolder.itemStatus.setText("已接收");
                    itemViewHolder.itemStatus.setTextColor(Color.rgb(128, 255, 00));
                } else if (dataBean.state == 0) {
                    itemViewHolder.itemStatus.setText("已上报");
                    itemViewHolder.itemStatus.setTextColor(Color.rgb(128, 255, 00));
                }
            } else if (dataBean.complained == 1) {
                itemViewHolder.itemStatus.setText("已投诉");
                itemViewHolder.itemStatus.setTextColor(Color.rgb(255, 00, 00));
            }

            itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("id", dataBean.id);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mainBean.data.size();
    }


}
