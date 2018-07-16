package com.cn5.appstore.mvp.presenter;

import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.mvp.view.view.AppMoreRecommendView;
import com.cn5.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppMoreRecommendPresenter extends BasePresenter<AppMoreRecommendView>{
    void getAppMoreRecommendData(BaseActivity activity,String type,String packageName) ;
}
