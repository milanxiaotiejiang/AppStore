package com.cn5.appstore.mvp.view.view;

import com.cn5.appstore.bean.AppCommentBean;
import com.cn5.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppCommentFragmentView extends BaseView{
    void onAppCommentDataSuccess(AppCommentBean appCommentBean);
    void onAppCommentDataError(String msg) ;
}
