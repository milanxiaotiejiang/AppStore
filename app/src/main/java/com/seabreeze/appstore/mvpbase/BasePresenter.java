package com.seabreeze.appstore.mvpbase;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T t);
    void detachView();
}
