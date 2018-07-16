package com.cn5.appstore.mvp.view.view;

import com.cn5.appstore.bean.CategoryToolBean;
import com.cn5.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryToolActivityView extends BaseView {
    void onCategoryToolDataSuccess(CategoryToolBean categoryToolBean);
    void onCategoryToolError(String msg);
}
