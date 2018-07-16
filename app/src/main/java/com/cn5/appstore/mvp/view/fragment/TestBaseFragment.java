package com.cn5.appstore.mvp.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn5.appstore.R;
import com.cn5.appstore.view.MultipleStatusView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public abstract class TestBaseFragment extends Fragment{

    public MultipleStatusView pager ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.base_fragment,null) ;
        if(pager == null)
            pager = (MultipleStatusView) view.findViewById(R.id.pager);

        pager.setLoadListener(new MultipleStatusView.LoadListener() {
            @Override
            public void loading() {
                TestBaseFragment.this.load();
            }

            @Override
            public void loadView() {

            }
        });

        pager.setSuccessView(createSuccessView());

        return view;
    }

    public void show(){
        if(pager != null)
            pager.showStateView();
    }

    public abstract void load();
    public abstract View createSuccessView() ;
}
