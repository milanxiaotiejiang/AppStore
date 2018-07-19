package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.AppDetailBean;
import com.seabreeze.appstore.mvp.interactor.AppDetailInteractor;
import com.seabreeze.appstore.mvp.presenter.AppDetailPresenter;
import com.seabreeze.appstore.mvp.view.view.AppDetailView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppDetailPresenterImpl extends BasePresenterImpl<AppDetailView> implements AppDetailPresenter {

    @Inject
    AppDetailInteractor appDetailInteractor ;

    @Inject
    public AppDetailPresenterImpl(){

    }

    @Override
    public void getAppDetailData(BaseActivity activity,String packageName) {
        appDetailInteractor.loadAppDetailData(activity, packageName, new IGetDataDelegate<AppDetailBean>() {
            @Override
            public void getDataSuccess(AppDetailBean appDetailBean) {
                mPresenterView.onAppDetailDataSuccess(appDetailBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onAppDetailDataError(errmsg);
            }
        });
    }
}
