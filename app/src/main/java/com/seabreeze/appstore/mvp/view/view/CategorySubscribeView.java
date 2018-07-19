package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.CategorySubscribeBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategorySubscribeView extends BaseView {
    void onCategorySubscribeDataSuccess(CategorySubscribeBean categorySubscribeBean) ;
    void onCategorySubscribeDataError(String msg);
}
