package com.twtstudio.repair.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.twtstudio.repair.R;

import java.util.List;

public class MessageActivity extends AppCompatActivity {
    private Spinner spinnerBuilding;
    private Spinner spinnerRoom;
    private String[] building = {"正园九斋","齐园十三斋","诚园八斋"};
    private String[] room = {"227","228","229"};
//    SpinnerAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

    }
}
