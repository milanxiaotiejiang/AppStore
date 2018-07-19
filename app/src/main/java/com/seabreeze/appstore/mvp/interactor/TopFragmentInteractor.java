package com.seabreeze.appstore.mvp.interactor;

import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.api.TopApi;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.TopBean;
import com.seabreeze.appstore.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class TopFragmentInteractor {

    private IGetDataDelegate<TopBean> mDelegate ;

    @Inject
    public TopFragmentInteractor(){

    }

    public void loadTopData(BaseActivity activity, IGetDataDelegate<TopBean> delegate){
        this.mDelegate = delegate ;

        TopApi topApi = new TopApi(httpListener,activity);
        HttpManager httpManager = HttpManager.getInstance() ;
        httpManager.doHttpDeal(topApi);
    }

    private HttpOnNextListener httpListener = new HttpOnNextListener<TopBean>() {

        @Override
        public void onNext(TopBean topBean) {
            mDelegate.getDataSuccess(topBean);
        }

        @Override
        public void onCacheNext(String string) {
            TopBean topBean = JsonParseUtils.parseTopBean(string);
            mDelegate.getDataSuccess(topBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
