package com.cn5.appstore.mvp.view.view;

import com.cn5.appstore.mvpbase.BaseView;

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
