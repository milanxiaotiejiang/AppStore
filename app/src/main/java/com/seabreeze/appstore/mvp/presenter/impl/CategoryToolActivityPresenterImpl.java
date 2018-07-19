package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.CategoryToolBean;
import com.seabreeze.appstore.mvp.interactor.CategoryToolActivityInteractor;
import com.seabreeze.appstore.mvp.presenter.CategoryToolActivityPresenter;
import com.seabreeze.appstore.mvp.view.view.CategoryToolActivityView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategoryToolActivityPresenterImpl extends BasePresenterImpl<CategoryToolActivityView> implements CategoryToolActivityPresenter{

    @Inject
    public CategoryToolActivityInteractor categoryToolActivityInteractor ;

    @Inject
    public CategoryToolActivityPresenterImpl(){

    }

    @Override
    public void getCategoryToolData(BaseActivity activity) {
        categoryToolActivityInteractor.loadCategoryToolData(activity, new IGetDataDelegate<CategoryToolBean>() {
            @Override
            public void getDataSuccess(CategoryToolBean categoryToolBean) {
                mPresenterView.onCategoryToolDataSuccess(categoryToolBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onCategoryToolError(errmsg);
            }
        });
    }
}
