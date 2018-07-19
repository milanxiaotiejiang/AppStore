package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.CategoryBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryFragmentView extends BaseView {
    void onCategoryDataSuccess(CategoryBean categoryBean);
    void onCategoryDataError(String msg) ;
}
