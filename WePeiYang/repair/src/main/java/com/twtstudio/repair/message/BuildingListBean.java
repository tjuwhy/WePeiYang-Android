package com.twtstudio.repair.message;

import java.util.List;

/**
 * Created by liuyuesen on 2017/9/18.
 */

public class BuildingListBean {

    /**
     * error_code : -1
     * message :
     * data : [{"id":1,"area_name":"格园一斋","created_at":"2017-09-13 21:16:23","updated_at":"2017-09-13 21:16:24"},{"id":2,"area_name":"格园二斋","created_at":"2017-09-13 21:16:22","updated_at":"2017-09-13 21:16:25"},{"id":3,"area_name":"格园三斋","created_at":"2017-09-14 12:37:12","updated_at":"2017-09-14 12:37:13"}]
     */

    public int error_code;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 1
         * area_name : 格园一斋
         * created_at : 2017-09-13 21:16:23
         * updated_at : 2017-09-13 21:16:24
         */

        public int id;
        public String area_name;
        public String created_at;
        public String updated_at;
    }
}
