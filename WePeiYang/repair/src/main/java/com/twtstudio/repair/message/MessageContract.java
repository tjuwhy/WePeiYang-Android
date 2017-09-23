package com.twtstudio.repair.message;

import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.base.BaseContract;
import com.twtstudio.repair.main.MainBean;

/**
 * Created by liuyuesen on 2017/9/15.
 */

public class MessageContract implements BaseContract{
    public static abstract class MessageView extends BaseActivity {
    public void setData(MessageBean MessageBean){

    }
    public void postData(MessageBean messageBean){

    }
    public void getData(){

    }
}

public static abstract class MessagePresenter implements BaseContract.BasePresenter {
    public void setData(MessageBean MessageBean){

    }
    public void postData(MessageBean messageBean){

    }
    public void getData(){

    }
}

public static abstract class MessageModel implements BaseContract.BaseModel {
    public void setData(MessageBean MessageBean){

    }
    public void postData(MessageBean messageBean){

    }
    public void getData(){

    }
}
}
