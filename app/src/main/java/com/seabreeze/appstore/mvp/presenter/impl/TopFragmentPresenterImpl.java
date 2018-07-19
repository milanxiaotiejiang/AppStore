package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.TopBean;
import com.seabreeze.appstore.mvp.interactor.TopFragmentInteractor;
import com.seabreeze.appstore.mvp.presenter.TopFragmentPresenter;
import com.seabreeze.appstore.mvp.view.view.TopFragmentView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class TopFragmentPresenterImpl extends BasePresenterImpl<TopFragmentView> implements TopFragmentPresenter {

    @Inject
    public TopFragmentInteractor topFragmentInteractor ;

    @Inject
    public TopFragmentPresenterImpl(){

    }

    @Override
    public void getTopData(BaseActivity activity) {
        topFragmentInteractor.loadTopData(activity, new IGetDataDelegate<TopBean>() {
            @Override
            public void getDataSuccess(TopBean topBean) {
                mPresenterView.onTopDataSuccess(topBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onTopDataError(errmsg);
            }
        });
    }
}
