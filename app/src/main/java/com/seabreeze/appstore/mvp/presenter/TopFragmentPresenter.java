package com.seabreeze.appstore.mvp.presenter;

import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.view.view.TopFragmentView;
import com.seabreeze.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface TopFragmentPresenter extends BasePresenter<TopFragmentView> {
    void getTopData(BaseActivity activity);
}
