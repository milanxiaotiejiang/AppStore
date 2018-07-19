package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.AppIntroductionBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppIntroductionFragmentView extends BaseView {
    void onAppIntroductionDataSuccess(AppIntroductionBean appIntroductionBean);
    void onAppIntroductionDataError(String msg) ;
}
