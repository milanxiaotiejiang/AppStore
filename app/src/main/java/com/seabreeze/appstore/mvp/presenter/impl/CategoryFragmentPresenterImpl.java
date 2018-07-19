package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.CategoryBean;
import com.seabreeze.appstore.mvp.interactor.CategoryFragmentInteractor;
import com.seabreeze.appstore.mvp.presenter.CategoryFragmentPresenter;
import com.seabreeze.appstore.mvp.view.view.CategoryFragmentView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategoryFragmentPresenterImpl extends BasePresenterImpl<CategoryFragmentView> implements CategoryFragmentPresenter {

    @Inject
    CategoryFragmentInteractor categoryFragmentInteractor ;

    @Inject
    public CategoryFragmentPresenterImpl(){

    }

    @Override
    public void getCategoryData(BaseActivity activity) {
        categoryFragmentInteractor.loadCategoryData(activity, new IGetDataDelegate<CategoryBean>() {
            @Override
            public void getDataSuccess(CategoryBean categoryBean) {
                mPresenterView.onCategoryDataSuccess(categoryBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onCategoryDataError(errmsg);
            }
        });
    }
}
