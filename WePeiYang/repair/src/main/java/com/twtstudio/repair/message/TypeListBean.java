package com.twtstudio.repair.message;

import java.util.List;

/**
 * Created by liuyuesen on 2017/9/28.
 */

public class TypeListBean {

    /**
     * error_code : -1
     * message :
     * data : [{"id":1,"item":"门","type":1,"created_at":"2017-10-13 17:05:27","updated_at":"2017-10-13 17:05:28"},{"id":2,"item":"门上玻璃","type":1,"created_at":"2017-10-13 17:05:47","updated_at":"2017-10-13 17:05:46"}]
     */

    public int error_code;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 1
         * item : 门
         * type : 1
         * created_at : 2017-10-13 17:05:27
         * updated_at : 2017-10-13 17:05:28
         */

        public int id;
        public String item;
        public int type;
        public String created_at;
        public String updated_at;
    }
}
