package com.cn5.appstore.mvp.presenter;

import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.mvp.view.view.CategoryNecessaryView;
import com.cn5.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryNecessaryPresenter extends BasePresenter<CategoryNecessaryView> {
    void getCategoryNecessaryData(BaseActivity activity) ;
}
