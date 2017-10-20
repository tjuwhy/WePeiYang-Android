package com.twtstudio.repair.message;

import java.util.List;

/**
 * Created by liuyuesen on 2017/9/28.
 */

public class RoomListBean {


    /**
     * error_code : -1
     * message :
     * data : [{"area_name":"格园三斋"},{"room":"101","type":1},{"room":"102","type":1},{"room":"103","type":1},{"room":"104","type":1},{"room":"105前厕所","type":2},{"room":"105前盥洗室","type":3}]
     */

    public int error_code;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * area_name : 格园三斋
         * room : 101
         * type : 1
         */

        public String area_name;
        public String room;
        public int type;
    }
}
