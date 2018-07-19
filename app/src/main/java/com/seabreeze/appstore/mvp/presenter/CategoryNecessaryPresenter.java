package com.seabreeze.appstore.mvp.presenter;

import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.view.view.CategoryNecessaryView;
import com.seabreeze.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryNecessaryPresenter extends BasePresenter<CategoryNecessaryView> {
    void getCategoryNecessaryData(BaseActivity activity) ;
}
