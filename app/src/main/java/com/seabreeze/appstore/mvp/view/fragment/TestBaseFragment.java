package com.seabreeze.appstore.mvp.view.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seabreeze.appstore.R;
import com.seabreeze.appstore.view.MultipleStatusView;

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
