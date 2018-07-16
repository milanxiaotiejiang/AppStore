package com.cn5.appstore.mvp.presenter.impl;

import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.TopBean;
import com.cn5.appstore.mvp.interactor.TopFragmentInteractor;
import com.cn5.appstore.mvp.presenter.TopFragmentPresenter;
import com.cn5.appstore.mvp.view.view.TopFragmentView;
import com.cn5.appstore.mvpbase.BasePresenterImpl;

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
