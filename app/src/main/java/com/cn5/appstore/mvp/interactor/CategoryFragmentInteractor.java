package com.cn5.appstore.mvp.interactor;

import com.cn5.appstore.api.CategoryApi;
import com.cn5.appstore.api.IGetDataDelegate;
import com.cn5.appstore.base.BaseActivity;
import com.cn5.appstore.bean.CategoryBean;
import com.cn5.appstore.utils.JsonParseUtils;
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
