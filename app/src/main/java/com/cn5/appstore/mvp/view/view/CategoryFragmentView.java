package com.cn5.appstore.mvp.view.view;

import com.cn5.appstore.bean.CategoryBean;
import com.cn5.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryFragmentView extends BaseView {
    void onCategoryDataSuccess(CategoryBean categoryBean);
    void onCategoryDataError(String msg) ;
}
