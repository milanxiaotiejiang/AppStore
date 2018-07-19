package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.AppRecommendBean;
import com.seabreeze.appstore.mvp.interactor.AppRecommendInteractor;
import com.seabreeze.appstore.mvp.presenter.AppRecommendFragmentPresenter;
import com.seabreeze.appstore.mvp.view.view.AppRecommendFragmentView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppRecommendFragmentPresenterImpl extends BasePresenterImpl<AppRecommendFragmentView> implements AppRecommendFragmentPresenter {

    @Inject
    public AppRecommendInteractor appRecommendInteractor ;

    @Inject
    public AppRecommendFragmentPresenterImpl(){

    }

    @Override
    public void getAppRecommendData(BaseActivity activity, String packageName) {
        appRecommendInteractor.loadAppRecommend(activity, packageName, new IGetDataDelegate<AppRecommendBean>() {
            @Override
            public void getDataSuccess(AppRecommendBean appRecommendBean) {
                mPresenterView.onAppRecommendDataSuccess(appRecommendBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onAppRecommendDataError(errmsg);
            }
        });
    }
}
