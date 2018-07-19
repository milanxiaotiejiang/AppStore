package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.CategoryNecessaryBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryNecessaryView extends BaseView {
    void onCategoryNecessaryDataSuccess(CategoryNecessaryBean categoryNecessaryBean);
    void onCategoryNecessaryDataError(String msg) ;
}
