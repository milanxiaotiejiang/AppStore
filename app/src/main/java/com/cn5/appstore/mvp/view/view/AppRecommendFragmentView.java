package com.cn5.appstore.mvp.view.view;

import com.cn5.appstore.bean.AppRecommendBean;
import com.cn5.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppRecommendFragmentView extends BaseView {
    void onAppRecommendDataSuccess(AppRecommendBean appRecommendBean);
    void onAppRecommendDataError(String msg);
}
