package com.seabreeze.appstore.mvp.view.activity;

import android.os.Build;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.KeyEvent;
import android.widget.LinearLayout;

import com.seabreeze.appstore.R;
import com.seabreeze.appstore.adapter.FixPagerAdapter;
import com.seabreeze.appstore.base.BaseActivity;
import com.seabreeze.appstore.base.BaseFragment;
import com.seabreeze.appstore.factory.FragmentFactory;
import com.seabreeze.appstore.utils.AppActivityManager;
import com.seabreeze.appstore.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout ;
    @BindView(R.id.main_viewpager)
    ViewPager mainViewPager ;
    @BindView(R.id.status_bar)
    LinearLayout statusBar ;

    private FixPagerAdapter fixPagerAdapter ;
    private String[] titles = {"推荐","分类","排行","管理","我的"};
    private List<Fragment> fragments ;

    //退出返回按钮间隔时间
    private long exitTime = 0;

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void initView() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            final int statusHeight = getStatusBarHeight();
            statusBar.post(new Runnable() {
                @Override
                public void run() {
                    int titleHeight = statusBar.getHeight();
                    android.widget.LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) statusBar.getLayoutParams();
                    params.height = statusHeight + titleHeight;
                    statusBar.setLayoutParams(params);
                }
            });
        }

        initViewPagerFragment();
    }


    private void initViewPagerFragment() {
        fixPagerAdapter = new FixPagerAdapter(getSupportFragmentManager()) ;

        fragments = new ArrayList<>() ;
        for(int i = 0 ;i < titles.length ; i ++){
            fragments.add(FragmentFactory.createFragment(i)) ;
        }
        fixPagerAdapter.setTitles(titles);
        fixPagerAdapter.setFragments(fragments);

        mainViewPager.setAdapter(fixPagerAdapter);
        tabLayout.setupWithViewPager(mainViewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        mainViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                BaseFragment fragment = FragmentFactory.createFragment(position);
                fragment.show();

            }
        });
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtils.showToast("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                AppActivityManager.getInstance().AppExit(this);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


}
































