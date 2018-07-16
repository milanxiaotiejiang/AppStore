package com.cn5.appstore.mvp.presenter;

import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.mvp.view.view.CategoryFragmentView;
import com.cn5.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryFragmentPresenter extends BasePresenter<CategoryFragmentView> {
    void getCategoryData(BaseActivity activity);
}
