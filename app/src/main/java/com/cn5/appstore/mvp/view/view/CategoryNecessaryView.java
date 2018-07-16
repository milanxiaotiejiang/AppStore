package com.cn5.appstore.mvp.view.view;

import com.cn5.appstore.bean.CategoryNecessaryBean;
import com.cn5.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryNecessaryView extends BaseView {
    void onCategoryNecessaryDataSuccess(CategoryNecessaryBean categoryNecessaryBean);
    void onCategoryNecessaryDataError(String msg) ;
}
