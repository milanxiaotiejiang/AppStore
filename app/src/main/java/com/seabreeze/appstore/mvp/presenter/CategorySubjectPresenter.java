package com.seabreeze.appstore.mvp.presenter;

import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.view.view.CategorySubjectView;
import com.seabreeze.appstore.mvpbase.BasePresenter;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategorySubjectPresenter extends BasePresenter<CategorySubjectView> {
    void getCategorySubjectData(BaseActivity activity) ;
}
