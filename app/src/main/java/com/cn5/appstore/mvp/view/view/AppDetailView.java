package com.cn5.appstore.mvp.view.view;

import com.cn5.appstore.bean.AppDetailBean;
import com.cn5.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppDetailView extends BaseView {
    void onAppDetailDataSuccess(AppDetailBean appDetailBean);
    void onAppDetailDataError(String msg);
}
