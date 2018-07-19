package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.AppIntroductionBean;
import com.seabreeze.appstore.mvp.interactor.AppIntroductionIntroductor;
import com.seabreeze.appstore.mvp.presenter.AppIntroductionFragmentPresenter;
import com.seabreeze.appstore.mvp.view.view.AppIntroductionFragmentView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppIntroductionFragmentPresenterImpl extends BasePresenterImpl<AppIntroductionFragmentView> implements AppIntroductionFragmentPresenter {

    @Inject
    AppIntroductionIntroductor appIntroductionIntroductor ;

    @Inject
    public AppIntroductionFragmentPresenterImpl(){

    }

    @Override
    public void getAppIntroductionData(BaseActivity activity, String packageName) {
        appIntroductionIntroductor.loadAppIntroductino(activity, packageName, new IGetDataDelegate<AppIntroductionBean>() {
            @Override
            public void getDataSuccess(AppIntroductionBean appIntroductionBean) {
                mPresenterView.onAppIntroductionDataSuccess(appIntroductionBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onAppIntroductionDataError(errmsg);
            }
        });
    }
}
