package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.AppCommentBean;
import com.seabreeze.appstore.mvp.interactor.AppCommentFragmentInteractor;
import com.seabreeze.appstore.mvp.presenter.AppCommentFragmentPresenter;
import com.seabreeze.appstore.mvp.view.view.AppCommentFragmentView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppCommentFragmentPresenterImpl extends BasePresenterImpl<AppCommentFragmentView> implements AppCommentFragmentPresenter {

    @Inject
    AppCommentFragmentInteractor appCommentFragmentInteractor ;

    @Inject
    public AppCommentFragmentPresenterImpl(){

    }

    @Override
    public void getAppCommentData(BaseActivity activity, String packageName) {
        appCommentFragmentInteractor.loadAppCommentData(activity, packageName, new IGetDataDelegate<AppCommentBean>() {
            @Override
            public void getDataSuccess(AppCommentBean appCommentBean) {
                mPresenterView.onAppCommentDataSuccess(appCommentBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onAppCommentDataError(errmsg);
            }
        });
    }
}
