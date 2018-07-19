package com.seabreeze.appstore.mvp.interactor;

import com.seabreeze.appstore.api.CategoryApi;
import com.seabreeze.appstore.api.IGetDataDelegate;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.bean.CategoryBean;
import com.seabreeze.appstore.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategoryFragmentInteractor {

    private IGetDataDelegate<CategoryBean> mDelegate ;

    @Inject
    public CategoryFragmentInteractor(){

    }

    public void loadCategoryData(BaseActivity activity, IGetDataDelegate<CategoryBean> delegate){
        this.mDelegate = delegate ;

        CategoryApi categoryApi = new CategoryApi(httpListener,activity);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(categoryApi);
    }

    private HttpOnNextListener httpListener = new HttpOnNextListener<CategoryBean>() {

        @Override
        public void onNext(CategoryBean categoryBean) {
            mDelegate.getDataSuccess(categoryBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            CategoryBean categoryBean = JsonParseUtils.parseCategoryBean(string);
            mDelegate.getDataSuccess(categoryBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
