package com.cn5.appstore.mvp.view.view;

import com.cn5.appstore.bean.RecommendBean;
import com.cn5.appstore.mvpbase.BaseView;

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
