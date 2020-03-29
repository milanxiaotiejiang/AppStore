package com.seabreeze.appstore.mvp.view.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.seabreeze.appstore.R;
import com.seabreeze.appstore.adapter.section.TopContactsSection;
import com.seabreeze.appstore.adapter.top.TopTopWrapper;
import com.seabreeze.appstore.base.BaseMvpFragment;
import com.seabreeze.appstore.bean.AppBean;
import com.seabreeze.appstore.bean.TopBean;
import com.seabreeze.appstore.mvp.presenter.impl.TopFragmentPresenterImpl;
import com.seabreeze.appstore.mvp.view.view.TopFragmentView;
import com.seabreeze.appstore.utils.UIUtils;
import com.seabreeze.appstore.view.MultipleStatusView;
import com.seabreeze.appstore.view.widget.ViewUpSearch;
import com.zhxu.recyclerview.section.SectionRVAdapter;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class TopFragment extends BaseMvpFragment<TopFragmentPresenterImpl> implements TopFragmentView {

    private static final String TAG = "TopFragment" ;

    @BindView(R.id.rv)
    RecyclerView rv ;
    @BindView(R.id.search)
    ViewUpSearch search ;

    private boolean isExpand = true ;

    @Inject
    TopFragmentPresenterImpl mTopFragmentPresenter ;

    private TopBean mTopBean ;


    @Override
    public void initView() {
        SectionRVAdapter sectionAdapter = new SectionRVAdapter(getContext());
        Map<String, List<AppBean>> appBeanMap = mTopBean.getAppBeanMap();
        Set<String> strings = appBeanMap.keySet();
        for(String name : strings){
            List<AppBean> appBeanList = appBeanMap.get(name);
            TopContactsSection section = new TopContactsSection(getContext(),name,appBeanList);

            sectionAdapter.addSection(section);
        }


        TopTopWrapper topTopWrapper = new TopTopWrapper(getContext(),sectionAdapter);
        topTopWrapper.addDataAll(mTopBean.getTopTopBeanList());

        rv.setAdapter(topTopWrapper);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                final int firstVisiblePosition = ((LinearLayoutManager)rv.getLayoutManager()).findFirstVisibleItemPosition();
                if(firstVisiblePosition == 0 && isExpand && dy > 0){
                    search.updateShow(!isExpand);
                    isExpand = false ;
                }else if(firstVisiblePosition == 0 && !isExpand && dy < 0){
                    search.updateShow(!isExpand);
                    isExpand = true ;
                }
            }
        });

    }

    @Override
    public View createSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_top) ;
        ButterKnife.bind(this,view) ;


        return view;
    }

    @Override
    public void load() {
        mTopFragmentPresenter.getTopData(mActivity);
    }

    @Override
    public void onTopDataSuccess(TopBean topBean) {
        this.mTopBean = topBean ;
        setState(MultipleStatusView.LoadResult.success);
    }

    @Override
    public void onTopDataError(String msg) {
        Log.i(TAG,msg);
        setState(MultipleStatusView.LoadResult.error);
    }

    @Override
    protected TopFragmentPresenterImpl initInjector() {
        mFragmentComponent.inject(this);
        return mTopFragmentPresenter;
    }
}
