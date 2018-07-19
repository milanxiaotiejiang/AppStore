package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.AppDetailBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppDetailView extends BaseView {
    void onAppDetailDataSuccess(AppDetailBean appDetailBean);
    void onAppDetailDataError(String msg);
}
