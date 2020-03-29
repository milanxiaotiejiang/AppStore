package com.seabreeze.appstore.adapter.top;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.seabreeze.appstore.R;
import com.seabreeze.appstore.bean.CategoryBean;
import com.seabreeze.appstore.utils.UIUtils;
import com.zhxu.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.List;


/**
 * Created by xzhang on 2017/5/25.
 */

public class CategoryTopWrapper extends HeaderAndFooterWrapper {

    private Context mContext ;
    private View headerView ;
    private List<CategoryBean.CategoryTopBean> topBeanList ;

    private GridView gv_title_grid ;


    public CategoryTopWrapper(Context context , RecyclerView.Adapter adapter) {
        super(adapter);
        this.mContext = context ;
        headerView = UIUtils.inflate(R.layout.header_top) ;
        gv_title_grid = (GridView) headerView.findViewById(R.id.gv_title_grid);
        addHeaderView(headerView);
    }

    public void addTopView() {
        addHeaderView(headerView);
    }

    public void deleteTopView() {
        deleteHeaderView(headerView);
    }

    public void addDataAll(List<CategoryBean.CategoryTopBean> list) {
        this.topBeanList = list ;

        CategorySubAdapter adapter = new CategorySubAdapter(mContext,topBeanList);
        gv_title_grid.setNumColumns(topBeanList.size());
        gv_title_grid.setAdapter(adapter);

        gv_title_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mListener != null){
                    mListener.onItemClick(position);
                }
            }
        });

    }

    private OnItemClickListener  mListener ;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener ;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void clearData() {
        if(topBeanList != null)
            topBeanList.clear();
    }
}
