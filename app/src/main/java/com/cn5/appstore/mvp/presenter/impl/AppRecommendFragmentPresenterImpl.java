package com.cn5.appstore.mvp.presenter.impl;

import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.AppRecommendBean;
import com.cn5.appstore.mvp.interactor.AppRecommendInteractor;
import com.cn5.appstore.mvp.presenter.AppRecommendFragmentPresenter;
import com.cn5.appstore.mvp.view.view.AppRecommendFragmentView;
import com.cn5.appstore.mvpbase.BasePresenterImpl;

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
