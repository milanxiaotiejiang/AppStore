package com.cn5.appstore.mvp.presenter;

import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.mvp.view.view.AppDetailView;
import com.cn5.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppDetailPresenter extends BasePresenter<AppDetailView> {
    void getAppDetailData(BaseActivity activity,String packageName) ;
}
