package com.cn5.appstore.mvp.presenter.impl;

import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.AppCommentBean;
import com.cn5.appstore.mvp.interactor.AppCommentFragmentInteractor;
import com.cn5.appstore.mvp.presenter.AppCommentFragmentPresenter;
import com.cn5.appstore.mvp.view.view.AppCommentFragmentView;
import com.cn5.appstore.mvpbase.BasePresenterImpl;

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
