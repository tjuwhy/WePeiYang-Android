package com.twtstudio.repair.detail.view;

import com.twtstudio.repair.detail.view.DetailBean;

/**
 * Created by tjwhm on 2017/8/23 8:25.
 * Happy coding!
 **/

public interface DetailContract {
    public interface DetailView{
        void setDetailData(DetailBean detailBean);
    }
    public interface DetailPresenter{
        void setDetailData(DetailBean detailBean);
    }
}
