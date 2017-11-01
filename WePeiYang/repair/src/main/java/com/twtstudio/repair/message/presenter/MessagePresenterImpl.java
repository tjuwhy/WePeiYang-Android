package com.twtstudio.repair.message.presenter;

import com.twtstudio.repair.message.BuildingListBean;
import com.twtstudio.repair.message.MessageBean;
import com.twtstudio.repair.message.MessageContract;
import com.twtstudio.repair.message.RoomListBean;
import com.twtstudio.repair.message.TypeListBean;
import com.twtstudio.repair.message.model.MessageApiClient;
import com.twtstudio.repair.message.view.MessageActivity;

import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by liuyuesen on 2017/9/15.
 */

public class MessagePresenterImpl extends MessageContract.MessagePresenter {
    MessageContract.MessageModel apiClient;
    MessageContract.MessageView messageView;

    public MessagePresenterImpl(MessageContract.MessageView messageView) {
        this.messageView = messageView;
        this.apiClient = new MessageApiClient(this);
    }

    public void postMessage(Map<String, Object> map, File file) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);//表单类型
        RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        builder.addFormDataPart("image", file.getName(), imageBody);//imgfile 后台接收图片流的参数名
        MultipartBody.Part body = MultipartBody.Part.createFormData("image", file.getName(),imageBody);
        apiClient.postMessage(map, body);
    }

    public void postMessage(Map<String, Object> map) {
        apiClient.postMessage(map);
    }

    public void getBuildingList() {
        apiClient.getBuildingList();
    }

    public void getRoomList(int area_id) {
        apiClient.getRoomList(area_id);
    }

    public void getTypeList(int type_id) {
        apiClient.getTypeList(type_id);
    }

    public void messageCallBack(MessageBean messageBean) {
        messageView.messageCallBack(messageBean);
    }

    public void getBuildingListCallBack(BuildingListBean buildingListBean) {
        messageView.getBuildingListCallBack(buildingListBean);
    }

    public void getRoomListCallBack(RoomListBean roomListBean) {
        messageView.getRoomListCallBack(roomListBean);
    }

    public void getTypeListCallBack(TypeListBean typeListBean) {
        messageView.getTypeListCallBack(typeListBean);
    }


}
