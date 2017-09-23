package com.twtstudio.repair.complaint;

import com.twtstudio.repair.base.BaseBean;

/**
 * Created by liuyuesen on 2017/9/22.
 */

public class ComplaintBean implements BaseBean{

    /**
     * error_code : -1
     * err_msg :
     * data : {"order_id":"18","student_id":10,"reason":"维修质量","detail":"床炸了","updated_at":"2017-09-04 07:59:32","created_at":"2017-09-04 07:59:32","id":2}
     */

    public int error_code;
    public String err_msg;
    public DataBean data;

    public static class DataBean {
        /**
         * order_id : 18
         * student_id : 10
         * reason : 维修质量
         * detail : 床炸了
         * updated_at : 2017-09-04 07:59:32
         * created_at : 2017-09-04 07:59:32
         * id : 2
         */

        public String order_id;
        public int student_id;
        public String reason;
        public String detail;
        public String updated_at;
        public String created_at;
        public int id;
    }
}
