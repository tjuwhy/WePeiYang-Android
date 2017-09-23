package com.twtstudio.repair.main;

import android.support.v7.widget.Toolbar;

import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.base.BaseBean;
import com.twtstudio.repair.base.BaseContract;

/**
 * Created by liuyuesen on 2017/9/12.
 */

public class MainContract implements BaseContract {

    public static abstract class MainView extends BaseActivity {
       public void setData(MainBean mainBean){

       }
       public void getData(){

       }
    }

    public static abstract class MainPresenter implements BaseContract.BasePresenter {
        public void setData(MainBean mainBean){

        }
        public void getData(){

        }
    }

    public static abstract class MainModel implements BaseModel {
        public void setData(MainBean mainBean){

        }
        public void getData(){

        }
    }
}
