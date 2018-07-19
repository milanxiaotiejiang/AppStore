package com.seabreeze.appstore.mvp.presenter;

import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.view.view.AppCommentFragmentView;
import com.seabreeze.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppCommentFragmentPresenter extends BasePresenter<AppCommentFragmentView> {
    void getAppCommentData(BaseActivity activity,String packageName);
}
