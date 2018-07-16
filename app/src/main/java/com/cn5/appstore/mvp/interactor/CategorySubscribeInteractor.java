package com.cn5.appstore.mvp.interactor;

import com.cn5.appstore.api.CategorySubcribeApi;
import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.CategorySubscribeBean;
import com.cn5.appstore.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategorySubscribeInteractor {

    private IGetDataDelegate<CategorySubscribeBean> mDelegate ;

    @Inject
    public CategorySubscribeInteractor(){

    }

    public void loadCategorySubscribeData(BaseActivity activity, IGetDataDelegate<CategorySubscribeBean> delegate){
        this.mDelegate = delegate ;
        CategorySubcribeApi categorySubcribeApi = new CategorySubcribeApi(httpListener,activity);
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.doHttpDeal(categorySubcribeApi);
    }

    private HttpOnNextListener httpListener = new HttpOnNextListener<CategorySubscribeBean>(){

        @Override
        public void onNext(CategorySubscribeBean categorySubscribeBean) {
            mDelegate.getDataSuccess(categorySubscribeBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            CategorySubscribeBean categorySubscribeBean = JsonParseUtils.parseCategorySubscribeBean(string);
            mDelegate.getDataSuccess(categorySubscribeBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
