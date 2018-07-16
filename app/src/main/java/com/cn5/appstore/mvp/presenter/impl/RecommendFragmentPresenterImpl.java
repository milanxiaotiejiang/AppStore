package com.cn5.appstore.mvp.presenter.impl;

import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.RecommendBean;
import com.cn5.appstore.mvp.interactor.RecommendFragmentInteractor;
import com.cn5.appstore.mvp.presenter.RecommendFragmentPresenter;
import com.cn5.appstore.mvp.view.view.RecommendFragmentView;
import com.cn5.appstore.mvpbase.BasePresenterImpl;

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
