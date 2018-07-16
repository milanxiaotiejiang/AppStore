package com.cn5.appstore.di.module;

import android.app.Activity;
import android.content.Context;

import com.cn5.appstore.di.scope.ContextLife;
import com.cn5.appstore.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * <p>Description:
 *
 * @author xzhang
 */

@Module
public class ActivityModule {

    private Activity mActivity ;

    public ActivityModule(Activity activity){
        this.mActivity = activity ;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    public Context provideActivityContext(){
        return mActivity ;
    }

    @Provides
    @PerActivity
    public Context provideActivity(){
        return mActivity ;
    }
}
