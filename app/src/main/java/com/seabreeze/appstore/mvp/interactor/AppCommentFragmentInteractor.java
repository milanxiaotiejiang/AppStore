package com.seabreeze.appstore.mvp.interactor;

import com.seabreeze.appstore.api.AppCommentApi;
import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.AppCommentBean;
import com.seabreeze.appstore.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppCommentFragmentInteractor {

    private IGetDataDelegate<AppCommentBean> mDelegate ;

    @Inject
    public AppCommentFragmentInteractor(){

    }

    public void loadAppCommentData(BaseActivity activity,String packageName,IGetDataDelegate<AppCommentBean> delegate){
        this.mDelegate = delegate ;
        AppCommentApi api = new AppCommentApi(httpListener,activity,packageName);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(api);
    }

    private HttpOnNextListener<AppCommentBean> httpListener = new HttpOnNextListener<AppCommentBean>() {
        @Override
        public void onNext(AppCommentBean appCommentBean) {
            mDelegate.getDataSuccess(appCommentBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            AppCommentBean appCommentBean = JsonParseUtils.parseAppCommentBean(string);
            mDelegate.getDataSuccess(appCommentBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
