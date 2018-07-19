package com.seabreeze.appstore.mvp.presenter;

import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.view.view.AppDetailView;
import com.seabreeze.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppDetailPresenter extends BasePresenter<AppDetailView> {
    void getAppDetailData(BaseActivity activity,String packageName) ;
}
