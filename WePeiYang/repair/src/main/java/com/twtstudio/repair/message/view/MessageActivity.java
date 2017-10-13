package com.twtstudio.repair.message.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.complaint.view.ComplaintActivity;
import com.twtstudio.repair.message.BuildingListBean;
import com.twtstudio.repair.message.MessageBean;
import com.twtstudio.repair.message.MessageContract;
import com.twtstudio.repair.message.RoomListBean;
import com.twtstudio.repair.message.TypeListBean;
import com.twtstudio.repair.message.presenter.MessagePresenterImpl;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class MessageActivity extends MessageContract.MessageView {
    //绑定spinner和toolbar
    @BindView(R.id.message_spinner_building)
    public Spinner spinnerBuilding;
    @BindView(R.id.message_spinner_room)
    public Spinner spinnerRoom;
    @BindView(R.id.message_spinner_type)
    public Spinner spinnerType;
    @BindView(R.id.editText_descript_message)
    EditText messageDescriptEditText;
    @BindView(R.id.editText_name_message)
    EditText messageNameEditText;
    @BindView(R.id.editText_phone_message)
    EditText messagePhoneEditText;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.button_commit_message)
    Button commitButton;
    @BindView(R.id.imageView_photo_message)
    ImageView photoImageView;
    MessagePresenterImpl messagePresenter;
    int selectedBuilding;
    String selectedRoom;
    int selectedType;
    int[] img_ids;
    String detail;
    int campus_id;
    String phone;
    Map<String, Object> map;


    //这下面的两个数组是用于储存spinner中的可选数据

    private String[] building = {"正园九斋", "齐园十三斋", "诚园八斋"};//
    private String[] room = {"227", "228", "229"};
    private String[] type = {"灯", "电源", "路由器", "笔记本电脑", "巴拉巴拉巴拉哔哩哔哩哔哩超级无敌大风吹强到爆帅炸空调", "脑子", "多肉", "石哥的性取向", "地板砖", "纱窗", "门", "水杯", "抽屉", "衣柜", "裤子", "石头", "空气"};


    //this port is for toolbar
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


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messagePresenter = new MessagePresenterImpl(this);
        getBuildingList();
        //this port is for spinnerAdapter
        ArrayAdapter<String> arrayAdapterBuilding = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, building);
        arrayAdapterBuilding.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBuilding.setAdapter(arrayAdapterBuilding);
        ArrayAdapter<String> arrayAdapterRoom = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, room);
        //arrayAdapterRoom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoom.setAdapter(arrayAdapterRoom);
        ArrayAdapter<String> arrayAdapterType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);
        spinnerType.setAdapter(arrayAdapterType);

        selectedBuilding = spinnerBuilding.getSelectedItemPosition();
        selectedRoom = spinnerRoom.getSelectedItem().toString();
        selectedType = spinnerType.getSelectedItemPosition();
        detail = messageDescriptEditText.getText().toString();
        phone = messagePhoneEditText.getText().toString();
        map = getMap();

        //this port is for spinnerOnClickListener
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

    public void postMessage(Map<String, Object> map) {
        messagePresenter.postMessage(map);
    }

    public void getBuildingList() {
        messagePresenter.getBuildingList();
    }

    public void getRoomList(int area_id) {
        messagePresenter.getRoomList(area_id);
    }

    public void getTypeList(int type_id) {
        messagePresenter.getTypeList(type_id);
    }

    public void messageCallBack(MessageBean MessageBean) {

    }

    public void getBuildingListCallBack(BuildingListBean buildingListBean) {

    }

    public void getRoomListCallBack(RoomListBean roomListBean) {

    }

    public void getTypeListCallBack(TypeListBean typeListBean) {

    }


    private Map<String, Object> getMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("area_id", selectedBuilding);
        map.put("campus_id", campus_id);
        map.put("room", selectedRoom);
        map.put("img_ids[]", img_ids);
        map.put("detail", detail);
        map.put("type", selectedType);
        map.put("phone", phone);
        return map;
    }

    public static void activityStart(Context context) {
        Intent intent = new Intent(context, MessageActivity.class);
        context.startActivity(intent);
    }

}
