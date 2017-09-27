package com.twtstudio.repair.detail;

import android.widget.Toast;

import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.base.BaseContract;

/**
 * Created by tjwhm on 2017/8/23 8:25.
 * Happy coding!
 **/

public class DetailContract implements BaseContract {
    public static abstract class DetailView extends BaseActivity {
        public void getData(int id) {

        }

        public void setData(DetailBean detailBean) {

        }

        public void deleteOrder(int id) {

        }
        public void deleteCallBack (DeleteBean deleteBean){
        }
    }

    public static abstract class DetailPresenter implements BaseContract.BasePresenter {
        public void setData(DetailBean detailBean) {

        }

        public void getData(int id) {

        }

        public void deleteOrder(int id) {

        }
        public void deleteCallBack (DeleteBean deleteBean){
        }
    }

    public static abstract class DetailModel implements BaseContract.BaseModel {
        public void setData(DetailBean detailBean) {

        }

        public void getData(int id) {

        }

        public void deleteOrder(int id) {

        }

        public void deleteCallBack (DeleteBean deleteBean){
        }
    }
}
