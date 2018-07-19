package com.seabreeze.appstore.mvp.presenter;

import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.view.view.AppRecommendFragmentView;
import com.seabreeze.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppRecommendFragmentPresenter extends BasePresenter<AppRecommendFragmentView> {
    void getAppRecommendData(BaseActivity activity,String packageName);
}
