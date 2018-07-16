package com.cn5.appstore.mvp.interactor;

import com.cn5.appstore.api.AppDetailApi;
import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.AppDetailBean;
import com.cn5.appstore.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppDetailInteractor {
    private IGetDataDelegate<AppDetailBean> mDelegate ;

    @Inject
    public AppDetailInteractor(){

    }

    public void loadAppDetailData(BaseActivity activity,String packageName,IGetDataDelegate<AppDetailBean> delegate){
        this.mDelegate = delegate ;
        AppDetailApi appDetailApi = new AppDetailApi(httpListener,activity,packageName);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(appDetailApi);
    }

    private HttpOnNextListener<AppDetailBean> httpListener = new HttpOnNextListener<AppDetailBean>() {
        @Override
        public void onNext(AppDetailBean appDetailBean) {
            mDelegate.getDataSuccess(appDetailBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            AppDetailBean appDetailBean = JsonParseUtils.parseAppDetailBean(string);
            mDelegate.getDataSuccess(appDetailBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };

}
