package com.cn5.appstore.di.component;

import android.content.Context;

import com.cn5.appstore.di.module.ApplicationModule;
import com.cn5.appstore.di.scope.ContextLife;
import com.cn5.appstore.di.scope.PerApp;

import dagger.Component;

/**
 * <p>Description:
 *
 * @author xzhang
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ContextLife("Application")
    Context getApplication() ;
}
