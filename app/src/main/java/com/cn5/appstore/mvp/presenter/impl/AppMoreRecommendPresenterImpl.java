package com.cn5.appstore.mvp.presenter.impl;

import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.AppMoreRecommendBean;
import com.cn5.appstore.mvp.interactor.AppMoreRecommendInteractor;
import com.cn5.appstore.mvp.presenter.AppMoreRecommendPresenter;
import com.cn5.appstore.mvp.view.view.AppMoreRecommendView;
import com.cn5.appstore.mvpbase.BasePresenterImpl;

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
