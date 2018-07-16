package com.cn5.appstore.mvp.presenter.impl;

import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.AppDetailBean;
import com.cn5.appstore.mvp.interactor.AppDetailInteractor;
import com.cn5.appstore.mvp.presenter.AppDetailPresenter;
import com.cn5.appstore.mvp.view.view.AppDetailView;
import com.cn5.appstore.mvpbase.BasePresenterImpl;

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
