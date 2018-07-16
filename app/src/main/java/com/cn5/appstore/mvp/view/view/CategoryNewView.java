package com.cn5.appstore.mvp.view.view;

import com.cn5.appstore.bean.CategoryNewBean;
import com.cn5.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryNewView extends BaseView {
    void onCategoryNewDataSuccess(CategoryNewBean categoryNewBean);
    void onCategoryNewDataError(String msg);
}
