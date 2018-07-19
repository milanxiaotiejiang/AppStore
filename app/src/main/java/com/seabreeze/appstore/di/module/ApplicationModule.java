package com.seabreeze.appstore.di.module;

import android.content.Context;

import com.seabreeze.appstore.base.StoreApplication;
import com.seabreeze.appstore.di.scope.ContextLife;
import com.seabreeze.appstore.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * <p>Description:
 *
 * @author xzhang
 */

@Module
public class ApplicationModule {

    private StoreApplication mApplication ;

    public ApplicationModule(StoreApplication application){
        this.mApplication = application ;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext(){
        return mApplication.getApplicationContext() ;
    }

}
