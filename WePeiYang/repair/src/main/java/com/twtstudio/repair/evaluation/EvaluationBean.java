package com.twtstudio.repair.evaluation;

/**
 * Created by liuyuesen on 2017/9/18.
 */

public class EvaluationBean {


    /**
     * error_code : -1
     * err_msg :
     * data : {"student_id":10,"comment":"修的太棒了","star_1":"5","star_2":"5","star_3":"5","star":5}
     */

    public int error_code;
    public String message;
    public DataBean data;

    public static class DataBean {
        /**
         * student_id : 10
         * comment : 修的太棒了
         * star_1 : 5
         * star_2 : 5
         * star_3 : 5
         * star : 5
         */

        public int student_id;
        public String comment;
        public String star_1;
        public String star_2;
        public String star_3;
        public int star;
    }
}
