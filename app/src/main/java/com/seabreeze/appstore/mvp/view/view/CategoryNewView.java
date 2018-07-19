package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.CategoryNewBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryNewView extends BaseView {
    void onCategoryNewDataSuccess(CategoryNewBean categoryNewBean);
    void onCategoryNewDataError(String msg);
}
