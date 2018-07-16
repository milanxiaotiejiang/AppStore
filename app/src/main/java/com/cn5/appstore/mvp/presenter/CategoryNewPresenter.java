package com.cn5.appstore.mvp.presenter;

import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.mvp.view.view.CategoryNewView;
import com.cn5.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryNewPresenter extends BasePresenter<CategoryNewView> {
    void getCategoryNewData(BaseActivity activity);
}
