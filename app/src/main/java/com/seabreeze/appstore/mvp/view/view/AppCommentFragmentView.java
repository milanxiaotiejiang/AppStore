package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.AppCommentBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppCommentFragmentView extends BaseView{
    void onAppCommentDataSuccess(AppCommentBean appCommentBean);
    void onAppCommentDataError(String msg) ;
}
