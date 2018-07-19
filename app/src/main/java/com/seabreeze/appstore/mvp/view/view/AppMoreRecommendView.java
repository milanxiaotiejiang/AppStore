package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.AppMoreRecommendBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppMoreRecommendView extends BaseView {
    void onAppMoreRecommendDataSuccess(AppMoreRecommendBean appMoreRecommendBean) ;
    void onAppMoreRecommendDataError(String msg) ;
}
