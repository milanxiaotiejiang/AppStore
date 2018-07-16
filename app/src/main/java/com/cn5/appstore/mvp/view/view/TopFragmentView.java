package com.cn5.appstore.mvp.view.view;

import com.cn5.appstore.bean.TopBean;
import com.cn5.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface TopFragmentView extends BaseView {
    void onTopDataSuccess(TopBean topBean);
    void onTopDataError(String msg);
}
