package com.twtstudio.repair.detail;

import java.util.List;

/**
 * Created by liuyuesen on 2017/9/14.
 */

public class DetailBean {


    /**
     * error_code : -1
     * err_msg :
     * data : {"id":15,"student_id":15,"place_id":3,"accendant_id":null,"stuff_id":4,"company_id":10,"state":0,"finished":0,"delayed":0,"complained":0,"deleted":0,"times":2,"detail":"123456","items":"门","predicted_at":"2017-08-29 16:57:57","times_at":"2017-08-30 16:57:57","reacted_at":null,"repaired_at":null,"created_at":"2017-08-29 16:58:06","updated_at":"2017-08-31 00:59:34","place":{"id":3,"campus_id":1,"area_id":22,"room":"209","created_at":"2017-08-24 16:16:55","updated_at":"2017-08-24 16:16:57","area":{"id":22,"area_name":"平园二十一斋","created_at":"2017-08-24 15:19:45","updated_at":"2017-08-24 15:19:46"}},"student":{"id":15,"type":0,"name":"张环禹","email":"33104863@qq.com","username":"fucku","phone":"13487313108","created_at":"2017-08-30 01:39:20","updated_at":"2017-08-30 09:25:39","deleted_at":null},"stuff":{"id":4,"type":1,"name":"Prof. Justice Ledner I","email":"schmeler.dora@example.com","username":"userWalker White","phone":"234-459-6098 x8654","created_at":"2017-08-28 02:55:02","updated_at":"2017-08-30 13:37:18","deleted_at":null},"grade":{"id":9,"order_id":15,"student_id":15,"star_1":2,"star_2":4,"star_3":5,"comment":"可以哦","created_at":"2017-08-21 07:05:06","updated_at":"2017-08-21 07:05:14"},"complain":{"id":1,"order_id":15,"student_id":15,"reason":"00000","detail":"00000000","created_at":"2017-08-30 14:56:38","updated_at":"2017-08-30 14:56:39","tickets":[]},"accendant":{"id":1,"accendant_name":"刘春阳","accendant_phone":"1354812356","created_at":"2017-09-13 23:01:22","updated_at":"2017-09-13 23:01:23","company_id":1}}
     */

    public int error_code;
    public String err_msg;
    public DataBean data;

    public static class DataBean {
        /**
         * id : 15
         * student_id : 15
         * place_id : 3
         * accendant_id : null
         * stuff_id : 4
         * company_id : 10
         * state : 0
         * finished : 0
         * delayed : 0
         * complained : 0
         * deleted : 0
         * times : 2
         * detail : 123456
         * items : 门
         * predicted_at : 2017-08-29 16:57:57
         * times_at : 2017-08-30 16:57:57
         * reacted_at : null
         * repaired_at : null
         * created_at : 2017-08-29 16:58:06
         * updated_at : 2017-08-31 00:59:34
         * place : {"id":3,"campus_id":1,"area_id":22,"room":"209","created_at":"2017-08-24 16:16:55","updated_at":"2017-08-24 16:16:57","area":{"id":22,"area_name":"平园二十一斋","created_at":"2017-08-24 15:19:45","updated_at":"2017-08-24 15:19:46"}}
         * student : {"id":15,"type":0,"name":"张环禹","email":"33104863@qq.com","username":"fucku","phone":"13487313108","created_at":"2017-08-30 01:39:20","updated_at":"2017-08-30 09:25:39","deleted_at":null}
         * stuff : {"id":4,"type":1,"name":"Prof. Justice Ledner I","email":"schmeler.dora@example.com","username":"userWalker White","phone":"234-459-6098 x8654","created_at":"2017-08-28 02:55:02","updated_at":"2017-08-30 13:37:18","deleted_at":null}
         * grade : {"id":9,"order_id":15,"student_id":15,"star_1":2,"star_2":4,"star_3":5,"comment":"可以哦","created_at":"2017-08-21 07:05:06","updated_at":"2017-08-21 07:05:14"}
         * complain : {"id":1,"order_id":15,"student_id":15,"reason":"00000","detail":"00000000","created_at":"2017-08-30 14:56:38","updated_at":"2017-08-30 14:56:39","tickets":[]}
         * accendant : {"id":1,"accendant_name":"刘春阳","accendant_phone":"1354812356","created_at":"2017-09-13 23:01:22","updated_at":"2017-09-13 23:01:23","company_id":1}
         */

        public int id;
        public int student_id;
        public int place_id;
        public Object accendant_id;
        public int stuff_id;
        public int company_id;
        public int state;
        public int finished;
        public int delayed;
        public int complained;
        public int deleted;
        public int times;
        public String detail;
        public String items;
        public String predicted_at;
        public String times_at;
        public Object reacted_at;
        public Object repaired_at;
        public String created_at;
        public String updated_at;
        public PlaceBean place;
        public StudentBean student;
        public StuffBean stuff;
        public GradeBean grade;
        public ComplainBean complain;
        public AccendantBean accendant;

        public static class PlaceBean {
            /**
             * id : 3
             * campus_id : 1
             * area_id : 22
             * room : 209
             * created_at : 2017-08-24 16:16:55
             * updated_at : 2017-08-24 16:16:57
             * area : {"id":22,"area_name":"平园二十一斋","created_at":"2017-08-24 15:19:45","updated_at":"2017-08-24 15:19:46"}
             */

            public int id;
            public int campus_id;
            public int area_id;
            public String room;
            public String created_at;
            public String updated_at;
            public AreaBean area;

            public static class AreaBean {
                /**
                 * id : 22
                 * area_name : 平园二十一斋
                 * created_at : 2017-08-24 15:19:45
                 * updated_at : 2017-08-24 15:19:46
                 */

                public int id;
                public String area_name;
                public String created_at;
                public String updated_at;
            }
        }

        public static class StudentBean {
            /**
             * id : 15
             * type : 0
             * name : 张环禹
             * email : 33104863@qq.com
             * username : fucku
             * phone : 13487313108
             * created_at : 2017-08-30 01:39:20
             * updated_at : 2017-08-30 09:25:39
             * deleted_at : null
             */

            public int id;
            public int type;
            public String name;
            public String email;
            public String username;
            public String phone;
            public String created_at;
            public String updated_at;
            public Object deleted_at;
        }

        public static class StuffBean {
            /**
             * id : 4
             * type : 1
             * name : Prof. Justice Ledner I
             * email : schmeler.dora@example.com
             * username : userWalker White
             * phone : 234-459-6098 x8654
             * created_at : 2017-08-28 02:55:02
             * updated_at : 2017-08-30 13:37:18
             * deleted_at : null
             */

            public int id;
            public int type;
            public String name;
            public String email;
            public String username;
            public String phone;
            public String created_at;
            public String updated_at;
            public Object deleted_at;
        }

        public static class GradeBean {
            /**
             * id : 9
             * order_id : 15
             * student_id : 15
             * star_1 : 2
             * star_2 : 4
             * star_3 : 5
             * comment : 可以哦
             * created_at : 2017-08-21 07:05:06
             * updated_at : 2017-08-21 07:05:14
             */

            public int id;
            public int order_id;
            public int student_id;
            public int star_1;
            public int star_2;
            public int star_3;
            public String comment;
            public String created_at;
            public String updated_at;
        }

        public static class ComplainBean {
            /**
             * id : 1
             * order_id : 15
             * student_id : 15
             * reason : 00000
             * detail : 00000000
             * created_at : 2017-08-30 14:56:38
             * updated_at : 2017-08-30 14:56:39
             * tickets : []
             */

            public int id;
            public int order_id;
            public int student_id;
            public String reason;
            public String detail;
            public String created_at;
            public String updated_at;
            public List<?> tickets;
        }

        public static class AccendantBean {
            /**
             * id : 1
             * accendant_name : 刘春阳
             * accendant_phone : 1354812356
             * created_at : 2017-09-13 23:01:22
             * updated_at : 2017-09-13 23:01:23
             * company_id : 1
             */

            public int id;
            public String accendant_name;
            public String accendant_phone;
            public String created_at;
            public String updated_at;
            public int company_id;
        }
    }
}
