package com.seabreeze.appstore.api;

import com.seabreeze.appstore.bean.AppRecommendBean;
import com.seabreeze.appstore.utils.JsonParseUtils;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zhxu.library.api.BaseApi;
import com.zhxu.library.listener.HttpOnNextListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppRecommendApi extends BaseApi<AppRecommendBean> {

    private String packageName ;

    public AppRecommendApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity,String packageName) {
        super(listener, rxAppCompatActivity);
        setMothed("AppStore/app/recommend/"+packageName);
        this.packageName = packageName ;
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpGetService httpGetService = retrofit.create(HttpGetService.class);
        return httpGetService.getAppRecommendData(packageName);
    }

    @Override
    public AppRecommendBean call(ResponseBody responseBody) {
        String string = "";
        try {
            string = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return JsonParseUtils.parseAppRecommendBean(string);
    }
}
