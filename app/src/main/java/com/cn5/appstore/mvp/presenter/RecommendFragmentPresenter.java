package com.cn5.appstore.mvp.presenter;

import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.mvp.view.view.RecommendFragmentView;
import com.cn5.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface RecommendFragmentPresenter extends BasePresenter<RecommendFragmentView> {
    void getRecommendData(BaseActivity activity);
    void getRecommendDataMore(BaseActivity activity);
}
