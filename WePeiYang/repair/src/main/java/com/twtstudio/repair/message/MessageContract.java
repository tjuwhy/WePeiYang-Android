package com.twtstudio.repair.message;

import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.base.BaseContract;
import com.twtstudio.repair.main.MainBean;

import java.util.Map;

/**
 * Created by liuyuesen on 2017/9/15.
 */

public class MessageContract implements BaseContract {
    public static abstract class MessageView extends BaseActivity {
        public void postMessage(Map<String, Object> map) {
        }

        public void getBuildingList() {

        }

        public void getRoomList(int area_id) {

        }

        public void getTypeList(int type_id) {

        }

        public void messageCallBack(MessageBean MessageBean) {

        }

        public void getBuildingListCallBack(BuildingListBean buildingListBean) {

        }

        public void getRoomListCallBack(RoomListBean roomListBean) {

        }

        public void getTypeListCallBack(TypeListBean typeListBean) {

        }

    }

    public static abstract class MessagePresenter implements BaseContract.BasePresenter {

        public void postMessage(Map<String, Object> map) {

        }

        public void getBuildingList() {

        }

        public void getRoomList(int area_id) {

        }

        public void getTypeList(int type_id) {

        }

        public void messageCallBack(MessageBean MessageBean) {

        }

        public void getBuildingListCallBack(BuildingListBean buildingListBean) {

        }

        public void getRoomListCallBack(RoomListBean roomListBean) {

        }

        public void getTypeListCallBack(TypeListBean typeListBean) {

        }
    }

    public static abstract class MessageModel implements BaseContract.BaseModel {

        public void postMessage(Map<String, Object> map) {

        }

        public void getBuildingList() {

        }

        public void getRoomList(int area_id) {

        }

        public void getTypeList(int type_id) {

        }

        public void messageCallBack(MessageBean MessageBean) {

        }

        public void getBuildingListCallBack(BuildingListBean buildingListBean) {

        }

        public void getRoomListCallBack(RoomListBean roomListBean) {

        }

        public void getTypeListCallBack(TypeListBean typeListBean) {

        }
    }
}
