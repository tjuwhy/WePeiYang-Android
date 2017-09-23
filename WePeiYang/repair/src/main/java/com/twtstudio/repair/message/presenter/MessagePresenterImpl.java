package com.twtstudio.repair.message.presenter;

import com.twtstudio.repair.message.MessageBean;
import com.twtstudio.repair.message.MessageContract;
import com.twtstudio.repair.message.model.MessageApiClient;
import com.twtstudio.repair.message.view.MessageActivity;

/**
 * Created by liuyuesen on 2017/9/15.
 */

public class MessagePresenterImpl extends MessageContract.MessagePresenter{
    MessageContract.MessageModel apiClient;
    MessageContract.MessageView messageView;

    public MessagePresenterImpl(MessageContract.MessageView messageView){
        this.messageView = messageView;
    }

    @Override
    public void getData(){
        apiClient.getData();
    }

    @Override
    public void setData(MessageBean messageBean){
        messageView.setData(messageBean);
    }

    @Override
    public void postData(MessageBean messageBean){

    }

}
