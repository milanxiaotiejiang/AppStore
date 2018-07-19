package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.AppRecommendBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppRecommendFragmentView extends BaseView {
    void onAppRecommendDataSuccess(AppRecommendBean appRecommendBean);
    void onAppRecommendDataError(String msg);
}
