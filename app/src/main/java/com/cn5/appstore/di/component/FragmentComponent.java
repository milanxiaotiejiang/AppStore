package com.cn5.appstore.di.component;

import android.app.Activity;
import android.content.Context;

import com.cn5.appstore.di.module.FragmentModule;
import com.cn5.appstore.di.scope.ContextLife;
import com.cn5.appstore.di.scope.PerFragment;
import com.cn5.appstore.mvp.view.fragment.AppCommentFragment;
import com.cn5.appstore.mvp.view.fragment.AppIntroductionFragment;
import com.cn5.appstore.mvp.view.fragment.AppRecommendFragment;
import com.cn5.appstore.mvp.view.fragment.CategoryFragment;
import com.cn5.appstore.mvp.view.fragment.RecommendFragment;
import com.cn5.appstore.mvp.view.fragment.TopFragment;

import dagger.Component;

/**
 * <p>Description:
 *
 * @author xzhang
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity() ;

    void inject(RecommendFragment fragment) ;
    void inject(CategoryFragment fragment) ;
    void inject(TopFragment fragment) ;
    void inject(AppIntroductionFragment fragment) ;
    void inject(AppCommentFragment fragment) ;
    void inject(AppRecommendFragment fragment) ;
}
