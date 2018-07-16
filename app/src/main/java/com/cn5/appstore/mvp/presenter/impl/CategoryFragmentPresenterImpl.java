package com.cn5.appstore.mvp.presenter.impl;

import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.CategoryBean;
import com.cn5.appstore.mvp.interactor.CategoryFragmentInteractor;
import com.cn5.appstore.mvp.presenter.CategoryFragmentPresenter;
import com.cn5.appstore.mvp.view.view.CategoryFragmentView;
import com.cn5.appstore.mvpbase.BasePresenterImpl;

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
