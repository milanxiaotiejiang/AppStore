package com.seabreeze.appstore.mvp.presenter;

import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.view.view.RecommendFragmentView;
import com.seabreeze.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface RecommendFragmentPresenter extends BasePresenter<RecommendFragmentView> {
    void getRecommendData(BaseActivity activity);
    void getRecommendDataMore(BaseActivity activity);
}
