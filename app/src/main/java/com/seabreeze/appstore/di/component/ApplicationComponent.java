package com.seabreeze.appstore.di.component;

import android.content.Context;

import com.seabreeze.appstore.di.module.ApplicationModule;
import com.seabreeze.appstore.di.scope.ContextLife;
import com.seabreeze.appstore.di.scope.PerApp;

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
