package com.twtstudio.repair.message;

/**
 * Created by liuyuesen on 2017/9/15.
 */

public class MessageBean {


    /**
     * error_code : -1
     * err_msg :
     * data : {"id":17,"student_id":15,"student_name":"张环禹","student_phone":"13487313108","student_email":"33104863@qq.com","stuff_id":null,"stuff_name":null,"stuff_phone":null,"stuff_email":null,"times":1,"state":0,"finished":0,"delayed":0,"complained":0,"predicted_at":null,"reacted_at":null,"repaired_at":null,"image_ids":null}
     */

    public int error_code;
    public String err_msg;
    public DataBean data;

    public static class DataBean {
        /**
         * id : 17
         * student_id : 15
         * student_name : 张环禹
         * student_phone : 13487313108
         * student_email : 33104863@qq.com
         * stuff_id : null
         * stuff_name : null
         * stuff_phone : null
         * stuff_email : null
         * times : 1
         * state : 0
         * finished : 0
         * delayed : 0
         * complained : 0
         * predicted_at : null
         * reacted_at : null
         * repaired_at : null
         * image_ids : null
         */

        public int id;
        public int student_id;
        public String student_name;
        public String student_phone;
        public String student_email;
        public Object stuff_id;
        public Object stuff_name;
        public Object stuff_phone;
        public Object stuff_email;
        public int times;
        public int state;
        public int finished;
        public int delayed;
        public int complained;
        public Object predicted_at;
        public Object reacted_at;
        public Object repaired_at;
        public Object image_ids;
    }
}
