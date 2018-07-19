package com.seabreeze.appstore.adapter.top;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.seabreeze.appstore.banner.RecommendController;
import com.zhxu.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.List;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class RecommendTopWrapper extends HeaderAndFooterWrapper {

    private Context mContext ;
    private RecommendController mController ;
    public RecommendTopWrapper(Context context,RecyclerView.Adapter adapter) {
        super(adapter);
        this.mContext = context ;

        mController = new RecommendController(mContext);
        addHeaderView(mController.getContentView());
    }

    public void addDataAll(List<String> list){
        if(mController != null){
            mController.setData(list);
        }
    }
}
