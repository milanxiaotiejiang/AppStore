package com.cn5.appstore.mvp.view.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import com.cn5.appstore.view.MultipleStatusView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class Test1Fragment extends TestBaseFragment {


     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        show();
    }

    @Override
    public void load() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                pager.setState(MultipleStatusView.LoadResult.empty);
            }
        }).start();
    }

    @Override
    public View createSuccessView() {
        TextView tv = new TextView(getContext()) ;
        tv.setText("成功界面");
        return tv;
    }
}
