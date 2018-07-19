package com.seabreeze.appstore.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * <p>Description:
 *
 * @author xzhang
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ContextLife {
    String value() ;
}
