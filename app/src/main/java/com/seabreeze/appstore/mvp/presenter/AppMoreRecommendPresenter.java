package com.seabreeze.appstore.mvp.presenter;

import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.view.view.AppMoreRecommendView;
import com.seabreeze.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppMoreRecommendPresenter extends BasePresenter<AppMoreRecommendView>{
    void getAppMoreRecommendData(BaseActivity activity,String type,String packageName) ;
}
