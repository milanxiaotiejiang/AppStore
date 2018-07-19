package com.seabreeze.appstore.mvp.presenter.impl;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.mvp.interactor.CategorySubjectInteractor;
import com.seabreeze.appstore.mvp.presenter.CategorySubjectPresenter;
import com.seabreeze.appstore.mvp.view.view.CategorySubjectView;
import com.seabreeze.appstore.mvpbase.BasePresenterImpl;

import java.util.List;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategorySubjectPresenterImpl extends BasePresenterImpl<CategorySubjectView> implements CategorySubjectPresenter {


    @Inject
    CategorySubjectInteractor categorySubjectInteractor ;

    @Inject
    public CategorySubjectPresenterImpl(){

    }

    @Override
    public void getCategorySubjectData(BaseActivity activity) {
        categorySubjectInteractor.loadCategorySubjectData(activity, new IGetDataDelegate<List<String>>() {
            @Override
            public void getDataSuccess(List<String> list) {
                mPresenterView.onCategorySubjectDataSuccess(list);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onCategorySubjectDataError(errmsg);
            }
        });
    }
}
