package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.AppMoreRecommendBean;
import com.seabreeze.appstore.mvp.interactor.AppMoreRecommendInteractor;
import com.seabreeze.appstore.mvp.presenter.AppMoreRecommendPresenter;
import com.seabreeze.appstore.mvp.view.view.AppMoreRecommendView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppMoreRecommendPresenterImpl extends BasePresenterImpl<AppMoreRecommendView> implements AppMoreRecommendPresenter {

    @Inject
    public AppMoreRecommendInteractor appMoreRecommendInteractor ;

    @Inject AppMoreRecommendPresenterImpl(){

    }

    @Override
    public void getAppMoreRecommendData(BaseActivity activity, String type,String packageName) {
        appMoreRecommendInteractor.loadAppMoreRecommend(activity, type, packageName, new IGetDataDelegate<AppMoreRecommendBean>() {
            @Override
            public void getDataSuccess(AppMoreRecommendBean appMoreRecommendBean) {
                mPresenterView.onAppMoreRecommendDataSuccess(appMoreRecommendBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onAppMoreRecommendDataError(errmsg);
            }
        });
    }
}
