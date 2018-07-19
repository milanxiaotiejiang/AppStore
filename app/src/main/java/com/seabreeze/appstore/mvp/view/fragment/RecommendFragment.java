package com.seabreeze.appstore.mvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.seabreeze.appstore.R;
import com.seabreeze.appstore.adapter.RecommendAdapter;
import com.seabreeze.appstore.adapter.top.RecommendTopWrapper;
import com.seabreeze.appstore.base.BaseMvpFragment;
import com.seabreeze.appstore.bean.RecommendBean;
import com.seabreeze.appstore.mvp.presenter.impl.RecommendFragmentPresenterImpl;
import com.seabreeze.appstore.mvp.view.activity.AppDetailActivity;
import com.seabreeze.appstore.mvp.view.view.RecommendFragmentView;
import com.seabreeze.appstore.utils.UIUtils;
import com.seabreeze.appstore.view.MultipleStatusView;
import com.zhxu.recyclerview.pullrefresh.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class RecommendFragment extends BaseMvpFragment<RecommendFragmentPresenterImpl> implements RecommendFragmentView{

    private final static String TAG = "RecommendFragment" ;

    @BindView(R.id.rv_recommend)
    RecyclerView mRv ;
    @BindView(R.id.ptr)
    PullToRefreshView ptr ;

    private RecommendBean mRecommendBean ;
    private List<RecommendBean.RecommendAppBean> recommendAppBeanList = new ArrayList<>();
    private RecommendAdapter adapter ;
    private RecommendTopWrapper topWrapper ;



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    @Inject
    RecommendFragmentPresenterImpl mRecommendFragmentPresenter ;

    @Override
    public void onRecommendDataSuccess(RecommendBean recommendBean) {
        Log.i(TAG,"");
        mRecommendBean = recommendBean ;
        setState(MultipleStatusView.LoadResult.success);
    }

    @Override
    public void onRecommendDataMoreSuccess(RecommendBean recommendBean) {
        recommendAppBeanList.addAll(recommendBean.getRecommendAppBeanList());
        adapter.clearData();
        adapter.addDataAll(recommendAppBeanList);
        topWrapper.notifyDataSetChanged();
        ptr.onFinishLoading();
    }

    @Override
    public void onRecommendDataError(String msg) {
        Log.e(TAG,msg);
        setState(MultipleStatusView.LoadResult.error);
    }

    @Override
    protected RecommendFragmentPresenterImpl initInjector() {
        mFragmentComponent.inject(this);
        return mRecommendFragmentPresenter;
    }

    @Override
    public void initView() {
        adapter = new RecommendAdapter(getContext());
        adapter.addDataAll(mRecommendBean.getRecommendAppBeanList());

        topWrapper = new RecommendTopWrapper(getContext(),adapter) ;
        topWrapper.addDataAll(mRecommendBean.getBannerList());

        adapter.setAppItemListener(new RecommendAdapter.AppItemListener() {
            @Override
            public void goAppDetail(String packageName) {
                Intent intent = new Intent(mActivity, AppDetailActivity.class);
                intent.putExtra("packageName",packageName) ;
                mActivity.startActivity(intent);
            }
        });

        mRv.setAdapter(topWrapper);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));

        //不让其下拉刷新
        ptr.setPullDownEnable(false);

        ptr.setListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                mRecommendFragmentPresenter.getRecommendDataMore(mActivity);
            }
        });
    }

    @Override
    public View createSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_recommend);
        ButterKnife.bind(this,view) ;



        return view;
    }

    @Override
    public void load() {
        mRecommendFragmentPresenter.getRecommendData(mActivity);
    }
}
