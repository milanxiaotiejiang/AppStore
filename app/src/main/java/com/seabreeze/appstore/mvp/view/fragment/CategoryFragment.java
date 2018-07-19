package com.seabreeze.appstore.mvp.view.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.seabreeze.appstore.R;
import com.seabreeze.appstore.adapter.section.CategoryContactsSection;
import com.seabreeze.appstore.adapter.top.CategoryTopWrapper;
import com.seabreeze.appstore.base.BaseMvpFragment;
import com.seabreeze.appstore.bean.CategoryBean;
import com.seabreeze.appstore.mvp.presenter.impl.CategoryFragmentPresenterImpl;
import com.seabreeze.appstore.mvp.view.activity.CategoryNecessaryActivity;
import com.seabreeze.appstore.mvp.view.activity.CategoryNewActivity;
import com.seabreeze.appstore.mvp.view.activity.CategorySubjectActivity;
import com.seabreeze.appstore.mvp.view.activity.CategorySubscribeActivity;
import com.seabreeze.appstore.mvp.view.activity.CategoryToolActivity;
import com.seabreeze.appstore.mvp.view.activity.HomeActivity;
import com.seabreeze.appstore.mvp.view.view.CategoryFragmentView;
import com.seabreeze.appstore.utils.UIUtils;
import com.seabreeze.appstore.view.MultipleStatusView;
import com.seabreeze.appstore.view.widget.ViewUpSearch;
import com.zhxu.recyclerview.section.SectionRVAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategoryFragment extends BaseMvpFragment<CategoryFragmentPresenterImpl> implements CategoryFragmentView {

    private static final String TAG = "CategoryFragment" ;

    @BindView(R.id.rv)
    RecyclerView rv ;
    @BindView(R.id.search)
    ViewUpSearch search ;

    private boolean isExpand = true ;




    @Inject
    public CategoryFragmentPresenterImpl mCategoryFragmentPresenter ;

    private CategoryBean mCategoryBean ;

    @Override
    public void initView() {
        SectionRVAdapter adapter = new SectionRVAdapter(getContext()) ;
        CategoryContactsSection categoryContactsSection = new CategoryContactsSection(getContext(),mCategoryBean.getTitle(),mCategoryBean.getCategoryDataBeanList());
        adapter.addSection(categoryContactsSection);

        CategoryTopWrapper categoryTopWrapper = new CategoryTopWrapper(getContext(),adapter);
        categoryTopWrapper.addDataAll(mCategoryBean.getCategoryTopBeanList());
        rv.setAdapter(categoryTopWrapper);
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

        categoryContactsSection.setOnItemClickListener(new CategoryContactsSection.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getContext(),CategoryToolActivity.class) ;
                intent.putExtra("name",mCategoryBean.getCategoryDataBeanList().get(position).getName());
                ((HomeActivity)getActivity()).startActivity(intent);

            }
        });

        categoryTopWrapper.setOnItemClickListener(new CategoryTopWrapper.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(position == 0){
                    mActivity.startActivity(new Intent(mActivity, CategorySubscribeActivity.class));
                }else if(position == 1){
                    mActivity.startActivity(new Intent(mActivity,CategoryNecessaryActivity.class));
                }else if(position == 2){
                    mActivity.startActivity(new Intent(mActivity,CategoryNewActivity.class));
                }else {
                    mActivity.startActivity(new Intent(mActivity,CategorySubjectActivity.class));
                }
            }
        });
    }

    @Override
    public View createSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_category);
        ButterKnife.bind(this,view) ;



        return view;
    }

    @Override
    public void load() {
        mCategoryFragmentPresenter.getCategoryData(mActivity);
    }




    @Override
    public void onCategoryDataSuccess(CategoryBean categoryBean) {
        this.mCategoryBean = categoryBean ;
        setState(MultipleStatusView.LoadResult.success);
    }

    @Override
    public void onCategoryDataError(String msg) {
        setState(MultipleStatusView.LoadResult.error);
    }

    @Override
    protected CategoryFragmentPresenterImpl initInjector() {
        mFragmentComponent.inject(this);
        return mCategoryFragmentPresenter;
    }
}
