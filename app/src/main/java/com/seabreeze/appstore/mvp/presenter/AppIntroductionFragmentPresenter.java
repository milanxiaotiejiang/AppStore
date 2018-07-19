package com.seabreeze.appstore.mvp.presenter;

import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.view.view.AppIntroductionFragmentView;
import com.seabreeze.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppIntroductionFragmentPresenter extends BasePresenter<AppIntroductionFragmentView>{
    void getAppIntroductionData(BaseActivity activity,String packageName) ;
}
