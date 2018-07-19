package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.mvpbase.BaseView;

import java.util.List;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategorySubjectView extends BaseView{
    void onCategorySubjectDataSuccess(List<String> list) ;
    void onCategorySubjectDataError(String msg);
}
