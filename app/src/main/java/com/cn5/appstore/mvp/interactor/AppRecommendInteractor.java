package com.cn5.appstore.mvp.interactor;

import com.cn5.appstore.api.AppRecommendApi;
import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.AppRecommendBean;
import com.cn5.appstore.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppRecommendInteractor {

    private IGetDataDelegate<AppRecommendBean> mDelegate ;

    @Inject
    public AppRecommendInteractor(){

    }

    public void loadAppRecommend(BaseActivity activity,String packageName,IGetDataDelegate<AppRecommendBean> delegate){
        this.mDelegate = delegate ;
        AppRecommendApi api = new AppRecommendApi(httpListener,activity,packageName);
        HttpManager httpListener = HttpManager.getInstance() ;
        httpListener.doHttpDeal(api);
    }

    private HttpOnNextListener<AppRecommendBean> httpListener = new HttpOnNextListener<AppRecommendBean>() {
        @Override
        public void onNext(AppRecommendBean appRecommendBean) {
            mDelegate.getDataSuccess(appRecommendBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            AppRecommendBean appRecommendBean = JsonParseUtils.parseAppRecommendBean(string);
            mDelegate.getDataSuccess(appRecommendBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
