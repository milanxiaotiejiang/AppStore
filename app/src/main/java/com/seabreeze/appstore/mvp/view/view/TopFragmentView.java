package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.TopBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface TopFragmentView extends BaseView {
    void onTopDataSuccess(TopBean topBean);
    void onTopDataError(String msg);
}
