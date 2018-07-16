package com.cn5.appstore.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * <p>Description:
 *
 * @author xzhang
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
