package com.seabreeze.appstore.mvp.presenter;

import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.view.view.CategorySubscribeView;
import com.seabreeze.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategorySubscribePresenter extends BasePresenter<CategorySubscribeView> {
    void getCategorySubscribeData(BaseActivity activity);
}
