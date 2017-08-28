package com.twtstudio.repair.message.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.complaint.view.ComplaintActivity;

import butterknife.BindView;

public class MessageActivity extends BaseActivity {
    //绑定spinner和toolbar
    @BindView(R.id.message_spinner_building)
    public Spinner spinnerBuilding;
    @BindView(R.id.message_spinner_room)
    public Spinner spinnerRoom;
    @BindView(R.id.message_spinner_type)
    public Spinner spinnerType;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.button_commit_message)
    Button commitButton;
    @BindView(R.id.imageView_photo_message)
    ImageView photoImageView;
    //这下面的两个数组是用于储存spinner中的可选数据
    private String[] building = {"正园九斋", "齐园十三斋", "诚园八斋"};//
    private String[] room = {"227", "228", "229"};
    private String[] type = {"灯", "电源", "路由器","笔记本电脑","巴拉巴拉巴拉哔哩哔哩哔哩超级无敌大风吹强到爆帅炸空调","脑子","多肉","石哥的性取向","地板砖","纱窗","门","水杯","抽屉","衣柜","裤子","石头","空气"};

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_message;
    }

    @Override
    protected Toolbar getToolbarView() {
        toolbar.setTitle("我要报修");
        return toolbar;
    }

    @Override
    protected boolean isShowBackArrow() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, building);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBuilding.setAdapter(arrayAdapter);
        ArrayAdapter<String> arrayAdapterRoom = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, room);
        //arrayAdapterRoom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoom.setAdapter(arrayAdapterRoom);
        ArrayAdapter<String> arrayAdapterType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);
        spinnerType.setAdapter(arrayAdapterType);
        photoImageView.setOnClickListener(v -> ComplaintActivity.activityStart(MessageActivity.this));
        commitButton.setOnClickListener(v -> CommitSuccessActivity.activityStart(MessageActivity.this));

        spinnerBuilding.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public static void activityStart(Context context) {
        Intent intent = new Intent(context, MessageActivity.class);
        context.startActivity(intent);
    }
}
