package com.seabreeze.appstore.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.seabreeze.appstore.R;
import com.seabreeze.appstore.base.BaseMvpActivity;
import com.seabreeze.appstore.bean.AppBean;
import com.seabreeze.appstore.bean.AppMoreRecommendBean;
import com.seabreeze.appstore.mvp.presenter.impl.AppMoreRecommendPresenterImpl;
import com.seabreeze.appstore.mvp.view.view.AppMoreRecommendView;
import com.zhxu.recyclerview.adapter.CommonAdapter;
import com.zhxu.recyclerview.adapter.MultiItemTypeAdapter;
import com.zhxu.recyclerview.base.ViewHolder;

import javax.inject.Inject;

import butterknife.BindView;

public class AppMoreRecommendActivity extends BaseMvpActivity<AppMoreRecommendPresenterImpl> implements AppMoreRecommendView {

    @BindView(R.id.title_text)
    TextView title_text ;
//    @BindView(R.id.iv_search)
//    ImageView iv_search ;
    @BindView(R.id.rv)
    RecyclerView rv ;

    private String type = "";
    private String packageName = "";

    @Inject
    public AppMoreRecommendPresenterImpl appMoreRecommendPresenter ;

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_app_more_recommend);
    }

    @Override
    protected void initView() {
        type = getIntent().getStringExtra("type");
        packageName = getIntent().getStringExtra("packageName");

        //设置沉浸式状态栏
        setStatusBar();
//        iv_search.setVisibility(View.VISIBLE);
        //设置沉浸式状态栏背景
        title_bar.setBackgroundResource(R.color.black_alpha_5);
        if(type.equals("popular"))
            title_text.setText("流行应用");
        if(type.equals("taste"))
            title_text.setText("兴趣相近的用户也安装了");
        if(type.equals("hot"))
            title_text.setText("本周热议的应用");
    }

    @Override
    protected void initData() {
        super.initData();
        appMoreRecommendPresenter.getAppMoreRecommendData(this,type,packageName);
    }

    @Override
    protected AppMoreRecommendPresenterImpl initInjector() {
        mActivityComponent.inject(this);
        return appMoreRecommendPresenter;
    }

    @Override
    public void onAppMoreRecommendDataSuccess(AppMoreRecommendBean appMoreRecommendBean) {
        rv.setLayoutManager(new LinearLayoutManager(this));

        MoreRecommendAdapter adapter = new MoreRecommendAdapter(this);
        adapter.addDataAll(appMoreRecommendBean.getMoreAppBean());
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener<AppBean>() {

            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, AppBean o, int position) {
                Intent intent = new Intent(AppMoreRecommendActivity.this,AppDetailActivity.class);
                intent.putExtra("packageName",o.getPackageName());
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, AppBean o, int position) {
                return false;
            }
        });
    }

    @Override
    public void onAppMoreRecommendDataError(String msg) {

    }

    public class MoreRecommendAdapter extends CommonAdapter<AppBean> {

        public MoreRecommendAdapter(Context context) {
            super(context, R.layout.applistitem_recommend);
        }
        @Override
        protected void convert(ViewHolder holder, AppBean moreRecommendBean, int position) {
            holder.setText(R.id.appTitle,moreRecommendBean.getName());
            holder.setText(R.id.app_size,moreRecommendBean.getSizeDesc());
            holder.setText(R.id.app_des,moreRecommendBean.getMemo());
            holder.setImageUrl(R.id.appicon,moreRecommendBean.getIcon());
        }
    }
}
