package com.twtstudio.repair.complaint;

import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.base.BaseContract;
import com.twtstudio.repair.main.MainBean;

/**
 * Created by liuyuesen on 2017/9/22.
 */

public class ComplaintContract implements BaseContract {
    public static abstract class ComplaintView extends BaseActivity {
        public void postData(ComplaintBean complaintBean){

        }
    }

    public static abstract class ComplaintPresenter implements BaseContract.BasePresenter {
        public void postData(ComplaintBean complaintBean){

        }
    }

    public static abstract class ComplaintModel implements BaseModel {
        public void postData(ComplaintBean complaintBean){

        }
    }
}
