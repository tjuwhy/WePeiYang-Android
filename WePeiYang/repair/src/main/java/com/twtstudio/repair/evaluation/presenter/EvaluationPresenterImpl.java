package com.twtstudio.repair.evaluation.presenter;

import com.twtstudio.repair.evaluation.EvaluationBean;
import com.twtstudio.repair.evaluation.EvaluationContract;
import com.twtstudio.repair.evaluation.model.EvaluationApiClient;

import java.util.Map;

/**
 * Created by liuyuesen on 2017/9/14.
 */

public class EvaluationPresenterImpl extends EvaluationContract.EvaluationPresenter {
    EvaluationContract.EvaluationModel evaluationModel;
    EvaluationContract.EvaluationView evaluationView;

    public EvaluationPresenterImpl(EvaluationContract.EvaluationView evaluationView) {
        this.evaluationView = evaluationView;
    }

    @Override
    public void EvaluationCallBack(EvaluationBean evaluationBean) {
        evaluationView.EvaluationCallBack(evaluationBean);
    }

    @Override
    public void postData(Map<String, Object> evaluationMap) {
        evaluationModel = new EvaluationApiClient(this);
        evaluationModel.postData(evaluationMap);
    }

}
