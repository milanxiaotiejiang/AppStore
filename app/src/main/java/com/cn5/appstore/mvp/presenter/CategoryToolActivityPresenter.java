package com.cn5.appstore.mvp.presenter;

import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.mvp.view.view.CategoryToolActivityView;
import com.cn5.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryToolActivityPresenter extends BasePresenter<CategoryToolActivityView> {
    void getCategoryToolData(BaseActivity activity) ;
}
