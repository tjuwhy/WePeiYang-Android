package com.twtstudio.repair.evaluation;

import com.twtstudio.repair.base.BaseActivity;
import com.twtstudio.repair.base.BaseContract;
import com.twtstudio.repair.complaint.ComplaintBean;

import java.util.Map;

/**
 * Created by liuyuesen on 2017/9/18.
 */

public class EvaluationContract implements BaseContract {
    public static abstract class EvaluationView extends BaseActivity {
        public void postData(Map<String, Object> EvaluationMap) {

        }

        public void EvaluationCallBack(EvaluationBean evaluationtBean) {

        }
    }

    public static abstract class EvaluationPresenter implements BaseContract.BasePresenter {
        public void postData(Map<String, Object> EvaluationMap) {

        }

        public void EvaluationCallBack(EvaluationBean evaluationtBean) {

        }
    }

    public static abstract class EvaluationModel implements BaseModel {
        public void postData(Map<String, Object> EvaluationMap) {

        }

        public void EvaluationCallBack(EvaluationBean evaluationtBean) {

        }
    }

}
