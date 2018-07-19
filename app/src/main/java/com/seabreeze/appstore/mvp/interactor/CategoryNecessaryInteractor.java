package com.seabreeze.appstore.mvp.interactor;

import com.seabreeze.appstore.api.CategoryNecessaryApi;
import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.CategoryNecessaryBean;
import com.seabreeze.appstore.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategoryNecessaryInteractor {

    private IGetDataDelegate<CategoryNecessaryBean> mDelegate ;

    @Inject
    public CategoryNecessaryInteractor(){

    }

    public void loadCategoryNecessaryData(BaseActivity activity,IGetDataDelegate<CategoryNecessaryBean> delegate){
        this.mDelegate = delegate ;
        CategoryNecessaryApi categoryNecessaryApi = new CategoryNecessaryApi(httpListener,activity);
        HttpManager httpListener = HttpManager.getInstance();
        httpListener.doHttpDeal(categoryNecessaryApi);
    }

    private HttpOnNextListener<CategoryNecessaryBean> httpListener = new HttpOnNextListener<CategoryNecessaryBean>() {
        @Override
        public void onNext(CategoryNecessaryBean categoryNecessaryBean) {
            mDelegate.getDataSuccess(categoryNecessaryBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            CategoryNecessaryBean categoryNecessaryBean = JsonParseUtils.parseCategoryNecessaryBean(string);
            mDelegate.getDataSuccess(categoryNecessaryBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
