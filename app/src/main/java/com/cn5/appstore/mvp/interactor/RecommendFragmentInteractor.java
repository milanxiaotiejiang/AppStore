package com.cn5.appstore.mvp.interactor;

import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.api.RecommendApi;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.RecommendBean;
import com.cn5.appstore.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class RecommendFragmentInteractor {

    @Inject
    public RecommendFragmentInteractor(){

    }

    private IGetDataDelegate<RecommendBean> mDelegate ;

    public void loadRecommendData(BaseActivity activity, IGetDataDelegate<RecommendBean> delegate){

        this.mDelegate = delegate ;
        RecommendApi recommendApi = new RecommendApi(httpListener,activity);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(recommendApi);
    }

    HttpOnNextListener httpListener = new HttpOnNextListener<RecommendBean>() {


        @Override
        public void onNext(RecommendBean recommendBean) {
            mDelegate.getDataSuccess(recommendBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            RecommendBean recommendBean = JsonParseUtils.parseRecommendBean(string);
            mDelegate.getDataSuccess(recommendBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
