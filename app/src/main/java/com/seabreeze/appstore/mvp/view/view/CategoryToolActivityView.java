package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.CategoryToolBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryToolActivityView extends BaseView {
    void onCategoryToolDataSuccess(CategoryToolBean categoryToolBean);
    void onCategoryToolError(String msg);
}
