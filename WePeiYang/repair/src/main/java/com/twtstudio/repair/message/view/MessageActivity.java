package com.twtstudio.repair.message.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.twtstudio.repair.R;
import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.complaint.view.ComplaintActivity;
import com.twtstudio.repair.complaint.view.ComplaintSuccessActivity;
import com.twtstudio.repair.message.BuildingListBean;
import com.twtstudio.repair.message.MessageBean;
import com.twtstudio.repair.message.MessageContract;
import com.twtstudio.repair.message.RoomListBean;
import com.twtstudio.repair.message.TypeListBean;
import com.twtstudio.repair.message.presenter.MessagePresenterImpl;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MessageActivity extends MessageContract.MessageView implements View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.button_commit_message)
    Button commitButton;
    @BindView(R.id.imageView_photo_message)
    ImageView photoImageView;
    MessagePresenterImpl messagePresenter = new MessagePresenterImpl(this);
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
    int selectedBuilding;
    int selectedRoom;
    int selectedType;
    int campus_id = 1;
    Map<String, Object> map;
    ArrayAdapter<String> arrayAdapterBuilding;
    ArrayAdapter<String> arrayAdapterRoom;
    ArrayAdapter<String> arrayAdapterType;
    boolean onLoading = false;
    private final int TAKE_PHOTO = 0;
    private final int TAKE_PHOTO_REQUEST_CODE = 0;
    //这下面的两个数组是用于储存spinner中的可选数据
    private List<String> building = new ArrayList<>();
    private List<String> room = new ArrayList<>();
    private List<String> type = new ArrayList<>();
    private List<Integer> buildingID = new ArrayList<>();
    private List<Integer> roomID = new ArrayList<>();
    private List<Integer> typeID = new ArrayList<>();

    File tempFile;
    File file;

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
        getBuildingList();
        setSpinnerAdapter();
        photoImageView.setOnClickListener(this);
        commitButton.setOnClickListener(this);
        setSpinnerListener();
    }

    public void postMessage(Map<String, Object> map, File file) {
        messagePresenter.postMessage(map, file);
    }
    public void postMessage(Map<String, Object> map) {
        messagePresenter.postMessage(map);
    }

    public void getBuildingList() {
        if (onLoading == false){
            onLoading =true;
            messagePresenter.getBuildingList();
        }
    }

    public void getRoomList(int area_id) {
        if (onLoading == false){
            onLoading = true;
            messagePresenter.getRoomList(area_id);
        }
    }

    public void getTypeList(int type_id) {
        if (onLoading == false){
            onLoading = true;
            messagePresenter.getTypeList(type_id);
        }

    }

    public void messageCallBack(MessageBean messageBean) {
        onLoading = false;
        Intent intent = new Intent();
        intent.putExtra("message", messageBean.err_msg);
        intent.setClass(MessageActivity.this, CommitSuccessActivity.class);
        startActivity(intent);
        finish();
    }

    public void getBuildingListCallBack(BuildingListBean buildingListBean) {
        onLoading = false;
        building.clear();
        buildingID.clear();
        for (int i = 0; i < buildingListBean.data.size(); i++) {
            building.add(buildingListBean.data.get(i).area_name);
            buildingID.add(buildingListBean.data.get(i).id);
        }
        arrayAdapterBuilding.notifyDataSetChanged();
    }

    public void getRoomListCallBack(RoomListBean roomListBean) {
        onLoading = false;
        room.clear();
        roomID.clear();
        for (int i = 1; i < roomListBean.data.size(); i++) {
            room.add(roomListBean.data.get(i).room);
            roomID.add(roomListBean.data.get(i).type);
        }
        arrayAdapterRoom.notifyDataSetChanged();
    }

    public void getTypeListCallBack(TypeListBean typeListBean) {
        onLoading = false;
        type.clear();
        typeID.clear();
        for (int i = 1; i < typeListBean.data.size(); i++) {
            type.add(typeListBean.data.get(i).item);
            typeID.add(typeListBean.data.get(i).type);
        }
        arrayAdapterType.notifyDataSetChanged();
    }

    private Map<String, Object> getMap() {
        String tempMessagePhoneEditText = messagePhoneEditText.getText().toString();
        String tempMessageDescriptEditText = messageDescriptEditText.getText().toString();
        if (tempMessageDescriptEditText.equals("")){
            Toast.makeText(getApplicationContext(), "请您认真填写补充描述哦", Toast.LENGTH_LONG).show();
            return null;
        }else if (tempMessagePhoneEditText.equals("")){
            Toast.makeText(getApplicationContext(), "请您填写您的联系电话", Toast.LENGTH_LONG).show();
            return null;
        }else {
            Map<String, Object> map = new HashMap<>();
            map.put("area_id", buildingID.get(selectedBuilding));
            map.put("campus_id", campus_id);
            map.put("room", room.get(selectedRoom));
            map.put("detail", messageDescriptEditText.getText().toString());
            map.put("items", type.get(selectedType));
            map.put("phone", messagePhoneEditText.getText().toString());
            return map;
        }
    }

    private void setSpinnerAdapter() {
        arrayAdapterBuilding = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, building);
        arrayAdapterBuilding.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBuilding.setAdapter(arrayAdapterBuilding);
        arrayAdapterRoom = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, room);
        spinnerRoom.setAdapter(arrayAdapterRoom);
        arrayAdapterType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);
        spinnerType.setAdapter(arrayAdapterType);
    }

    private void setSpinnerListener() {
        spinnerBuilding.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBuilding = spinnerBuilding.getSelectedItemPosition();

                getRoomList(buildingID.get(selectedBuilding));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedRoom = spinnerRoom.getSelectedItemPosition();
                getTypeList(roomID.get(selectedRoom));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedType = spinnerType.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == photoImageView) {
            String state = Environment.getExternalStorageState();
            if (state.equals(Environment.MEDIA_MOUNTED)) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // 指定存储照片的路径
                tempFile = getTempImage();
                Uri imageUri = Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, TAKE_PHOTO);
            } else {
                Toast.makeText(getApplicationContext(), "请确认已经插入SD卡",
                        Toast.LENGTH_LONG).show();
            }
        } else if (v == commitButton) {
            if (onLoading == false){
                map = getMap();
                if ( map != null && file != null) {
                    postMessage(map, file);
                    onLoading = true;
                }
                else if (map != null && file == null){
                    postMessage(map);
                    onLoading = true;
                }
            }

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    Bitmap bmp = BitmapFactory.decodeFile(tempFile.getAbsolutePath());
                    file = getFile(zipThePic(tempFile.getAbsolutePath()), Environment.getExternalStorageDirectory() + "/temp1.jpg");
                    if (bmp != null) {
                        photoImageView.setImageBitmap(ImageCrop(bmp, false));
                    } else {
                        Toast.makeText(this, "图片是空的", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    private File getFile(byte[] b, String outputFile) {
        BufferedOutputStream stream = null;
        File file = null;
        try {
            file = new File(outputFile);
            FileOutputStream fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            stream.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file;
    }

    public static File getTempImage() {
        File tempFile = null;
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            tempFile = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
            try {
                tempFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return tempFile;
        }
        return tempFile;
    }

    public static Bitmap ImageCrop(Bitmap bitmap, boolean isRecycled) {

        if (bitmap == null) {
            return null;
        }

        int w = bitmap.getWidth(); // 得到图片的宽，高
        int h = bitmap.getHeight();

        int wh = w > h ? h : w;// 裁切后所取的正方形区域边长

        int retX = w > h ? (w - h) / 2 : 0;// 基于原图，取正方形左上角x坐标
        int retY = w > h ? 0 : (h - w) / 2;

        Bitmap bmp = Bitmap.createBitmap(bitmap, retX, retY, wh, wh, null,
                false);
        if (isRecycled && bitmap != null && !bitmap.equals(bmp)
                && !bitmap.isRecycled()) {
            bitmap.recycle();
            bitmap = null;
        }

        // 下面这句是关键
        return bmp;// Bitmap.createBitmap(bitmap, retX, retY, wh, wh, null,
        // false);
    }

    private byte[] zipThePic(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        int reqHeight = 800;
        int reqWidth = 480;
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        options.inSampleSize = calculateInSampleSize(options, 480, 800);
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, baos);

        return baos.toByteArray();
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

}

