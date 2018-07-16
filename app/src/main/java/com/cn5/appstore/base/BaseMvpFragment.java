package com.cn5.appstore.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cn5.appstore.di.component.DaggerFragmentComponent;
import com.cn5.appstore.di.component.FragmentComponent;
import com.cn5.appstore.di.module.FragmentModule;
import com.cn5.appstore.mvpbase.BasePresenter;
import com.cn5.appstore.mvpbase.BaseView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    protected T mPresenter ;
    protected FragmentComponent mFragmentComponent ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initFragmentComponent();
        mPresenter = initInjector() ;
        mPresenter.attachView(this);

    }

    private void initFragmentComponent(){
        mFragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(((StoreApplication)getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build() ;
    }

    protected abstract T  initInjector();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter != null)
            mPresenter.detachView();
    }
}

