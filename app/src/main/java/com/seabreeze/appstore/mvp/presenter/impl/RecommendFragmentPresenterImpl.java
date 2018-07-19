package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.RecommendBean;
import com.seabreeze.appstore.mvp.interactor.RecommendFragmentInteractor;
import com.seabreeze.appstore.mvp.presenter.RecommendFragmentPresenter;
import com.seabreeze.appstore.mvp.view.view.RecommendFragmentView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class RecommendFragmentPresenterImpl extends BasePresenterImpl<RecommendFragmentView> implements RecommendFragmentPresenter {

    @Inject
    RecommendFragmentInteractor mRecommendFragmentInteractor ;

    @Inject
    public RecommendFragmentPresenterImpl(){

    }

    @Override
    public void getRecommendData(BaseActivity activity) {
        mRecommendFragmentInteractor.loadRecommendData(activity, new IGetDataDelegate<RecommendBean>() {
            @Override
            public void getDataSuccess(RecommendBean recommendBean) {
                mPresenterView.onRecommendDataSuccess(recommendBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onRecommendDataError(errmsg);
            }
        });
    }

    @Override
    public void getRecommendDataMore(BaseActivity activity) {
        mRecommendFragmentInteractor.loadRecommendData(activity, new IGetDataDelegate<RecommendBean>() {
            @Override
            public void getDataSuccess(RecommendBean recommendBean) {
                mPresenterView.onRecommendDataMoreSuccess(recommendBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onRecommendDataError(errmsg);
            }
        });
    }
}
