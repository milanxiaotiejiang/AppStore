package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.CategoryNewBean;
import com.seabreeze.appstore.mvp.interactor.CategoryNewInteractor;
import com.seabreeze.appstore.mvp.presenter.CategoryNewPresenter;
import com.seabreeze.appstore.mvp.view.view.CategoryNewView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategoryNewPresenterImpl extends BasePresenterImpl<CategoryNewView> implements CategoryNewPresenter {

    @Inject
    public CategoryNewInteractor categoryNewInteractor ;

    @Inject
    public CategoryNewPresenterImpl(){

    }

    @Override
    public void getCategoryNewData(BaseActivity activity) {
        categoryNewInteractor.loadCategoryNewData(activity, new IGetDataDelegate<CategoryNewBean>() {
            @Override
            public void getDataSuccess(CategoryNewBean categoryNewBean) {
                mPresenterView.onCategoryNewDataSuccess(categoryNewBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onCategoryNewDataError(errmsg);
            }
        });
    }
}
