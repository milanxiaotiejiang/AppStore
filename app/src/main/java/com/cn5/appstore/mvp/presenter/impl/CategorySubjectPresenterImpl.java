package com.cn5.appstore.mvp.presenter.impl;

import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.mvp.interactor.CategorySubjectInteractor;
import com.cn5.appstore.mvp.presenter.CategorySubjectPresenter;
import com.cn5.appstore.mvp.view.view.CategorySubjectView;
import com.cn5.appstore.mvpbase.BasePresenterImpl;

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
