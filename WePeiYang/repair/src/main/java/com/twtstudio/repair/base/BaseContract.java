package com.twtstudio.repair.base;

/**
 * Created by liuyuesen on 2017/9/12.
 */

public interface BaseContract {
    public interface BaseView {
        public void getData();

        public void setData();
    }

    public interface BasePresenter {
        public void getData();

        public void setData();
    }

    public interface BaseModel {
        public void getData();

        public void setData();
    }
}
