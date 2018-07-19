package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.CategorySubscribeBean;
import com.seabreeze.appstore.mvp.interactor.CategorySubscribeInteractor;
import com.seabreeze.appstore.mvp.presenter.CategorySubscribePresenter;
import com.seabreeze.appstore.mvp.view.view.CategorySubscribeView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategorySubscribePresenterImpl extends BasePresenterImpl<CategorySubscribeView> implements CategorySubscribePresenter {

    @Inject
    public CategorySubscribeInteractor categorySubscribeInteractor ;

    @Inject
    public CategorySubscribePresenterImpl(){

    }

    @Override
    public void getCategorySubscribeData(BaseActivity activity) {
        categorySubscribeInteractor.loadCategorySubscribeData(activity, new IGetDataDelegate<CategorySubscribeBean>() {
            @Override
            public void getDataSuccess(CategorySubscribeBean categorySubscribeBean) {
                mPresenterView.onCategorySubscribeDataSuccess(categorySubscribeBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onCategorySubscribeDataError(errmsg);
            }
        });
    }
}
