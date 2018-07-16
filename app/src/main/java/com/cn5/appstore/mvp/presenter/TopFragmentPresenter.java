package com.cn5.appstore.mvp.presenter;

import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.mvp.view.view.TopFragmentView;
import com.cn5.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface TopFragmentPresenter extends BasePresenter<TopFragmentView> {
    void getTopData(BaseActivity activity);
}
