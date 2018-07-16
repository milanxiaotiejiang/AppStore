package com.cn5.appstore.mvp.presenter;

import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.mvp.view.view.AppIntroductionFragmentView;
import com.cn5.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppIntroductionFragmentPresenter extends BasePresenter<AppIntroductionFragmentView>{
    void getAppIntroductionData(BaseActivity activity,String packageName) ;
}
