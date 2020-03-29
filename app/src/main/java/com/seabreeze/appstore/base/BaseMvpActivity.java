package com.seabreeze.appstore.base;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.seabreeze.appstore.di.component.ActivityComponent;
import com.seabreeze.appstore.di.component.DaggerActivityComponent;
import com.seabreeze.appstore.di.module.ActivityModule;
import com.seabreeze.appstore.mvpbase.BasePresenter;
import com.seabreeze.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView{

    protected ActivityComponent mActivityComponent ;
    protected T mPresenter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityComponent();
        mPresenter = initInjector() ;
        mPresenter.attachView(this);
        initData();
    }

    private void initActivityComponent(){
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((StoreApplication)getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null)
            mPresenter.detachView();
    }

    protected abstract T  initInjector();
}
