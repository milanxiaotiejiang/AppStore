package com.seabreeze.appstore.mvp.interactor;

import com.seabreeze.appstore.api.AppMoreRecommendApi;
import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.AppMoreRecommendBean;
import com.seabreeze.appstore.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppMoreRecommendInteractor {

    private IGetDataDelegate<AppMoreRecommendBean> mDelegate ;

    @Inject
    public AppMoreRecommendInteractor(){

    }

    public void loadAppMoreRecommend(BaseActivity activity,String type,String packageName,IGetDataDelegate<AppMoreRecommendBean> delegate){
        this.mDelegate = delegate ;
        AppMoreRecommendApi api = new AppMoreRecommendApi(httpListener,activity,type,packageName);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(api);
    }

    private HttpOnNextListener<AppMoreRecommendBean> httpListener = new HttpOnNextListener<AppMoreRecommendBean>() {
        @Override
        public void onNext(AppMoreRecommendBean appMoreRecommendBean) {
            mDelegate.getDataSuccess(appMoreRecommendBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            AppMoreRecommendBean appMoreRecommendBean = JsonParseUtils.parseAppMoreRecommendBean(string);
            mDelegate.getDataSuccess(appMoreRecommendBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
