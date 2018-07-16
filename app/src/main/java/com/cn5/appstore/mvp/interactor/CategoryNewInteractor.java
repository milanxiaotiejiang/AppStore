package com.cn5.appstore.mvp.interactor;

import com.cn5.appstore.api.CategoryNewApi;
import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.CategoryNewBean;
import com.cn5.appstore.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategoryNewInteractor {

    private IGetDataDelegate<CategoryNewBean> mDelegate ;

    @Inject
    public CategoryNewInteractor(){

    }

    public void loadCategoryNewData(BaseActivity activity,IGetDataDelegate<CategoryNewBean> delegate){
        this.mDelegate = delegate ;
        CategoryNewApi categoryNewApi = new CategoryNewApi(httpListener,activity);
        HttpManager httpListener = HttpManager.getInstance() ;
        httpListener.doHttpDeal(categoryNewApi);
    }

    private HttpOnNextListener<CategoryNewBean> httpListener = new HttpOnNextListener<CategoryNewBean>() {
        @Override
        public void onNext(CategoryNewBean categoryNewBean) {
            mDelegate.getDataSuccess(categoryNewBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            CategoryNewBean categoryNewBean = JsonParseUtils.parseCategoryNewBean(string);
            mDelegate.getDataSuccess(categoryNewBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
