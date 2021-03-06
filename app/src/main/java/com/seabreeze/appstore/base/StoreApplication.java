package com.seabreeze.appstore.base;

import android.os.Handler;

import com.seabreeze.appstore.BuildConfig;
import com.seabreeze.appstore.di.component.ApplicationComponent;
import com.seabreeze.appstore.di.component.DaggerApplicationComponent;
import com.seabreeze.appstore.di.module.ApplicationModule;
import com.zhxu.library.RxRetrofitApp;
import com.zhxu.recyclerview.App;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class StoreApplication extends App {

    private static int mMainThreadId;
    private static Handler mHandler;

    private ApplicationComponent mApplicationComponent ;

    @Override
    public void onCreate() {
        super.onCreate();

        mHandler=new Handler();
        initApplicationComponent();

        RxRetrofitApp.init(this, BuildConfig.DEBUG);

    }

    private void initApplicationComponent(){
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

    }
    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent ;
    }

    /**
     * 返回主线程的pid
     * @return
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }
    /**
     * 返回Handler
     * @return
     */
    public static Handler getHandler() {
        return mHandler;
    }
}
