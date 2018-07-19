package com.seabreeze.appstore.mvp.presenter;

import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.view.view.CategoryNewView;
import com.seabreeze.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryNewPresenter extends BasePresenter<CategoryNewView> {
    void getCategoryNewData(BaseActivity activity);
}
