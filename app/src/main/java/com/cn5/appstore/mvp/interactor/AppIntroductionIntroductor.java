package com.cn5.appstore.mvp.interactor;

import com.cn5.appstore.api.AppIntroductionApi;
import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.AppIntroductionBean;
import com.cn5.appstore.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppIntroductionIntroductor {

    private IGetDataDelegate<AppIntroductionBean> mDelegate ;

    @Inject
    public AppIntroductionIntroductor(){

    }

    public void loadAppIntroductino(BaseActivity activity,String packageName,IGetDataDelegate<AppIntroductionBean> delegate){
        this.mDelegate = delegate ;
        AppIntroductionApi api = new AppIntroductionApi(httpListener,activity,packageName);
        HttpManager httpManager = HttpManager.getInstance() ;
        httpManager.doHttpDeal(api);
    }

    private HttpOnNextListener<AppIntroductionBean> httpListener = new HttpOnNextListener<AppIntroductionBean>() {
        @Override
        public void onNext(AppIntroductionBean appIntroductionBean) {
            mDelegate.getDataSuccess(appIntroductionBean);

        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            AppIntroductionBean appIntroductionBean = JsonParseUtils.parseAppIntroductionBean(string);
            mDelegate.getDataSuccess(appIntroductionBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
