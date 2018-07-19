package com.seabreeze.appstore.mvp.view.view;

import com.seabreeze.appstore.bean.RecommendBean;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface RecommendFragmentView extends BaseView {

    void onRecommendDataSuccess(RecommendBean recommendBean) ;
    void onRecommendDataMoreSuccess(RecommendBean recommendBean) ;
    void onRecommendDataError(String msg);

}
