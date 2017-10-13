package com.twtstudio.repair.message.presenter;

import com.twtstudio.repair.message.BuildingListBean;
import com.twtstudio.repair.message.MessageBean;
import com.twtstudio.repair.message.MessageContract;
import com.twtstudio.repair.message.RoomListBean;
import com.twtstudio.repair.message.TypeListBean;
import com.twtstudio.repair.message.model.MessageApiClient;
import com.twtstudio.repair.message.view.MessageActivity;

import java.util.Map;

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

    }


}
