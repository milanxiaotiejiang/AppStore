package com.cn5.appstore.mvp.presenter.impl;

import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.CategoryNecessaryBean;
import com.cn5.appstore.mvp.interactor.CategoryNecessaryInteractor;
import com.cn5.appstore.mvp.presenter.CategoryNecessaryPresenter;
import com.cn5.appstore.mvp.view.view.CategoryNecessaryView;
import com.cn5.appstore.mvpbase.BasePresenterImpl;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategoryNecessaryPresenterImpl extends BasePresenterImpl<CategoryNecessaryView> implements CategoryNecessaryPresenter {


    @Inject
    public CategoryNecessaryInteractor categoryNecessaryInteractor ;

    @Inject
    public CategoryNecessaryPresenterImpl(){

    }

    @Override
    public void getCategoryNecessaryData(BaseActivity activity) {
        categoryNecessaryInteractor.loadCategoryNecessaryData(activity, new IGetDataDelegate<CategoryNecessaryBean>() {
            @Override
            public void getDataSuccess(CategoryNecessaryBean categoryNecessaryBean) {
                mPresenterView.onCategoryNecessaryDataSuccess(categoryNecessaryBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onCategoryNecessaryDataError(errmsg);
            }
        });
    }
}
