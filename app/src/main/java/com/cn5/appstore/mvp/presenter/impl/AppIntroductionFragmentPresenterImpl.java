package com.cn5.appstore.mvp.presenter.impl;

import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.AppIntroductionBean;
import com.cn5.appstore.mvp.interactor.AppIntroductionIntroductor;
import com.cn5.appstore.mvp.presenter.AppIntroductionFragmentPresenter;
import com.cn5.appstore.mvp.view.view.AppIntroductionFragmentView;
import com.cn5.appstore.mvpbase.BasePresenterImpl;

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
