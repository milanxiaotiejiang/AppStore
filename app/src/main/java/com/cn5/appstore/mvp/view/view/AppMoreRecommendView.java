package com.cn5.appstore.mvp.view.view;

import com.cn5.appstore.bean.AppMoreRecommendBean;
import com.cn5.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppMoreRecommendView extends BaseView {
    void onAppMoreRecommendDataSuccess(AppMoreRecommendBean appMoreRecommendBean) ;
    void onAppMoreRecommendDataError(String msg) ;
}
