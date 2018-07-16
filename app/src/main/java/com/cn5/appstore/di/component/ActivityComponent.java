package com.cn5.appstore.di.component;

import android.app.Activity;
import android.content.Context;

import com.cn5.appstore.di.module.ActivityModule;
import com.cn5.appstore.di.scope.ContextLife;
import com.cn5.appstore.di.scope.PerActivity;
import com.cn5.appstore.mvp.view.activity.AppDetailActivity;
import com.cn5.appstore.mvp.view.activity.AppMoreRecommendActivity;
import com.cn5.appstore.mvp.view.activity.CategoryNecessaryActivity;
import com.cn5.appstore.mvp.view.activity.CategoryNewActivity;
import com.cn5.appstore.mvp.view.activity.CategorySubjectActivity;
import com.cn5.appstore.mvp.view.activity.CategorySubscribeActivity;
import com.cn5.appstore.mvp.view.activity.CategoryToolActivity;

import dagger.Component;

/**
 * <p>Description:
 *
 * @author xzhang
 */
@PerActivity
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(CategoryToolActivity activity);

    void inject(CategorySubscribeActivity activity);

    void inject(CategoryNecessaryActivity activity);

    void inject(CategoryNewActivity activity);

    void inject(CategorySubjectActivity activity);

    void inject(AppDetailActivity activity);

    void inject(AppMoreRecommendActivity activity);
}
