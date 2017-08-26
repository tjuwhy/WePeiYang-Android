package com.twtstudio.repair.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.twtstudio.repair.R;
import com.twtstudio.repair.commons.BaseActivity;

import java.util.List;

import butterknife.BindView;

public class MessageActivity extends BaseActivity {
    @BindView(R.id.message_spinner_building)
    public Spinner spinnerBuilding;
    @BindView(R.id.message_spinner_room)
    public Spinner spinnerRoom;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private String[] building = {"正园九斋", "齐园十三斋", "诚园八斋"};
    private String[] room = {"227", "228", "229"};
//    SpinnerAdapter

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
