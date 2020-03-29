package com.seabreeze.appstore.mvp.view.activity;

import android.os.Environment;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.seabreeze.appstore.R;
import com.seabreeze.appstore.adapter.AppDetailPagerAdapter;
import com.seabreeze.appstore.base.BaseMvpActivity;
import com.seabreeze.appstore.bean.AppDetailBean;
import com.seabreeze.appstore.mvp.presenter.impl.AppDetailPresenterImpl;
import com.seabreeze.appstore.mvp.view.fragment.AppCommentFragment;
import com.seabreeze.appstore.mvp.view.fragment.AppIntroductionFragment;
import com.seabreeze.appstore.mvp.view.fragment.AppRecommendFragment;
import com.seabreeze.appstore.mvp.view.view.AppDetailView;
import com.seabreeze.appstore.utils.AppInfoUtils;
import com.seabreeze.appstore.utils.UIUtils;
import com.seabreeze.appstore.view.widget.DetailShareButton;
import com.seabreeze.appstore.view.widget.DownloadProgressButton;
import com.seabreeze.appstore.view.widget.SubTabNavigator;
import com.zhxu.library.download.DownInfo;
import com.zhxu.library.download.DownState;
import com.zhxu.library.download.HttpDownManager;
import com.zhxu.library.utils.DbDownUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class AppDetailActivity extends BaseMvpActivity<AppDetailPresenterImpl> implements AppDetailView
        , HttpDownManager.DownloadObserver {

    @BindView(R.id.title_text)
    TextView title_text;
//    @BindView(R.id.iv_search)
//    ImageView iv_search ;

    @BindView(R.id.iv_back)
    ImageView iv_back;


    @BindView(R.id.detail_head_app_icon_imageview)
    ImageView detail_app_icon;
    @BindView(R.id.detail_head_app_name_textview)
    TextView detail_app_name;
    @BindView(R.id.detail_head_download_count_textview)
    TextView detail_app_download_count;
    @BindView(R.id.detail_head_app_stars_ratingbar)
    RatingBar detail_app_stars;
    @BindView(R.id.detail_head_label_layout_linearlayout)
    RelativeLayout detail_head_label_layout;
    @BindView(R.id.detail_head_label_icon_layout_linearlayout)
    LinearLayout detail_head_label_icon_layout;
    @BindView(R.id.detail_head_lable_folding_textview)
    TextView detail_head_lable_folding;
    @BindView(R.id.detail_head_safe_icon_container_linearlayout)
    LinearLayout detail_head_safe_icon_container;
    @BindView(R.id.detail_head_safe_icon_layout_linearlayout)
    LinearLayout detail_head_safe_icon_layout;
    @BindView(R.id.subTab)
    SubTabNavigator subTabNavigator;
    @BindView(R.id.vp)
    ViewPager mViewPager;
    @BindView(R.id.appdetail_head)
    LinearLayout appdetail_head;
    @BindView(R.id.detail_download_button)
    DownloadProgressButton detail_download_button;
    @BindView(R.id.detail_download_share_button)
    DetailShareButton detail_download_share_button;
    @BindView(R.id.detail_download_comment_button_linearlayout)
    LinearLayout detail_download_comment_button_linearlayout;

    @Inject
    public AppDetailPresenterImpl appDetailPresenter;

    private String packageName;

    private AppDetailBean appDetailBean;
    protected boolean expand = false;

    private List<Fragment> fragments = null;

    private DbDownUtil dbUtil;
    private HttpDownManager manager;
    private DownInfo downInfo;
    private File outputFile;

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_app_detail2);
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏
        setStatusBar();
//        iv_search.setVisibility(View.VISIBLE);
        iv_back.setVisibility(View.VISIBLE);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //设置沉浸式状态栏背景
        if (title_bar != null)
            title_bar.setBackgroundResource(R.color.black_alpha_5);
        title_text.setText(getResources().getString(R.string.title_activity_app_detail));
    }

    @Override
    protected void initData() {
        super.initData();
        manager = HttpDownManager.getInstance();
        manager.registerObserver(this);
        dbUtil = DbDownUtil.getInstance();
        packageName = getIntent().getStringExtra("packageName");
        downInfo = dbUtil.queryDownBy(packageName.hashCode());
        if (downInfo == null) {
            outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), packageName + ".apk");
        }
        appDetailPresenter.getAppDetailData(this, packageName);


    }

    @Override
    protected AppDetailPresenterImpl initInjector() {
        mActivityComponent.inject(this);
        return appDetailPresenter;
    }

    @Override
    public void onAppDetailDataSuccess(AppDetailBean appDetailBean) {
        this.appDetailBean = appDetailBean;
        setDetailHead();
    }

    @Override
    public void onAppDetailDataError(String msg) {
        setContentView(R.layout.loading_page_empty);
    }


    private void setDetailHead() {
        Glide.with(UIUtils.getContext()).load(appDetailBean.getIcoUrl()).into(detail_app_icon);
        detail_app_name.setText(appDetailBean.getName());
        detail_app_download_count.setText(appDetailBean.getIntro());
        detail_app_stars.setRating(Float.parseFloat(appDetailBean.getStars()));

        setLabel();
        setSafeLabel();
        setSubTab();
        setDetailDown();

        detail_head_label_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expand) {
                    expand = false;
                    detail_head_safe_icon_layout.setVisibility(View.GONE);
                    detail_head_lable_folding.setBackgroundResource(R.drawable.ic_public_arrow_down);
                } else {
                    expand = true;
                    detail_head_safe_icon_layout.setVisibility(View.VISIBLE);
                    detail_head_lable_folding.setBackgroundResource(R.drawable.ic_public_arrow_up);
                }
            }
        });
    }

    private void setLabel() {
        for (AppDetailBean.LabelName labelNamesBean : appDetailBean.getLabelNameList()) {
            View labelView = UIUtils.inflate(R.layout.appdetail_item_head_label_item);
            TextView label = (TextView) labelView.findViewById(R.id.appdetail_head_label_textview);
            label.setText(labelNamesBean.getName());
            if (labelNamesBean.getType() == 1) {
                label.setTextColor(getResources().getColor(R.color.app_not_safe_textcolor));
            }
            detail_head_label_icon_layout.addView(labelView);
        }
    }

    private void setSafeLabel() {
        for (AppDetailBean.SafeLabel safeLabelsBean : appDetailBean.getSafeLabelList()) {
            View safeLabelView = UIUtils.inflate(R.layout.appdetail_item_head_safe_item);
            TextView safe_checker = (TextView) safeLabelView.findViewById(R.id.safe_checker_textview);
            TextView safe_checker_label = (TextView) safeLabelView.findViewById(R.id.safe_checker_label);
            ImageView detail_head_app_icon = (ImageView) safeLabelView.findViewById(R.id.detail_head_app_icon_imageview);
            TextView detail_safe_desc_textview = (TextView) safeLabelView.findViewById(R.id.detail_safe_desc_textview);

            safe_checker.setText(safeLabelsBean.getDetectorName());
            safe_checker_label.setText(safeLabelsBean.getDetectorDesc());
            Glide.with(UIUtils.getContext()).load(safeLabelsBean.getUrl()).into(detail_head_app_icon);
            detail_safe_desc_textview.setText(safeLabelsBean.getName());

            detail_head_safe_icon_container.addView(safeLabelView);
        }
    }

    private void setSubTab() {
        fragments = new ArrayList<>();
        AppDetailPagerAdapter appDetailPagerAdapter = new AppDetailPagerAdapter(getSupportFragmentManager());
        AppIntroductionFragment appIntroductionFragment = new AppIntroductionFragment();
        AppCommentFragment appCommentFragment = new AppCommentFragment();
        AppRecommendFragment appRecommendFragment = new AppRecommendFragment();

        fragments.add(appIntroductionFragment);
        fragments.add(appCommentFragment);
        fragments.add(appRecommendFragment);

        appDetailPagerAdapter.setFragments(fragments);
        mViewPager.setAdapter(appDetailPagerAdapter);
        mViewPager.setOnPageChangeListener(subTabNavigator);
        subTabNavigator.setViewPager(mViewPager);

        subTabNavigator.setLeftText(appDetailBean.getTabInfoList().get(0));
        subTabNavigator.setNoneText(appDetailBean.getTabInfoList().get(1));
        subTabNavigator.setRightText(appDetailBean.getTabInfoList().get(2));
    }

    private void setDetailDown() {
        if (downInfo == null) {
            detail_download_button.setStartText("安装 " + Formatter.formatFileSize(UIUtils.getContext(),
                    Long.parseLong(appDetailBean.getSize())));
        } else {
            if (downInfo.getState() == DownState.DOWN) {
                detail_download_button.setState(DownloadProgressButton.STATUS_PROGRESS_BAR_DOWNLOADING);
                manager.startDown(downInfo);
            } else if (downInfo.getState() == DownState.PAUSE) {
                detail_download_button.setState(DownloadProgressButton.STATUS_PROGRESS_BAR_PAUSE);
            } else if (downInfo.getState() == DownState.FINISH) {
                detail_download_button.setState(DownloadProgressButton.STATUS_PROGRESS_BAR_BEGIN);
            }
            detail_download_button.setProgress((int) (100 * downInfo.getReadLength() / downInfo.getCountLength()));
        }

        detail_download_button.setStateChangeListener(new DownloadProgressButton.StateChangeListener() {
            @Override
            public void onPauseTask() {
                manager.pause(downInfo);
            }

            @Override
            public void onFinishTask() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(3000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                AppInfoUtils.install(downInfo.getSavePath());
                                if (dbUtil != null && downInfo != null)
                                    dbUtil.update(downInfo);
                            }
                        });
                    }
                }).start();

            }

            @Override
            public void onLoadingTask() {
                detail_download_button.setMax(100);

                if (downInfo == null) {
                    downInfo = new DownInfo(appDetailBean.getDownloadUrl());
                    downInfo.setId((long) packageName.hashCode());
                    downInfo.setState(DownState.START);
                    downInfo.setSavePath(outputFile.getAbsolutePath());
                    dbUtil.save(downInfo);

                }
                if (downInfo.getState() != DownState.FINISH) {
                    manager.startDown(downInfo);
                }
            }
        });
    }

    public String getAppPackageName() {
        return packageName;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (manager != null) {
            manager.unRegisterObserver(this);
            if (downInfo != null)
                dbUtil.update(downInfo);
        }
    }

    @Override
    public void onDownloadStateChanged(DownInfo info) {

    }

    @Override
    public void onDownloadProgressed(DownInfo info) {
        if (downInfo != null && info.getId() == downInfo.getId()) {
            detail_download_button.setProgress((int) (100 * info.getReadLength() / info.getCountLength()));
        }
    }
}
