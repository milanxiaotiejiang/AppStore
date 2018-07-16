package com.cn5.appstore.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.cn5.appstore.R;
import com.cn5.appstore.bean.AppBean;
import com.cn5.appstore.bean.RecommendBean;
import com.zhxu.recyclerview.adapter.CommonAdapter;
import com.zhxu.recyclerview.adapter.MultiItemTypeAdapter;
import com.zhxu.recyclerview.base.ItemViewDelegate;
import com.zhxu.recyclerview.base.ViewHolder;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class RecommendAdapter extends MultiItemTypeAdapter<RecommendBean.RecommendAppBean> {

    private Context mContext ;
    private AppItemListener mListener ;

    public void setAppItemListener(AppItemListener listener){
        this.mListener = listener ;
    }

    public interface AppItemListener{
        void goAppDetail(String packageName) ;
    }

    public RecommendAdapter(Context context) {
        super(context);
        this.mContext = context ;

        addItemViewDelegate(new AppDelegate());
        addItemViewDelegate(new AdDetegate()) ;
    }

    public void set(){}

    /**
     * APP横向列表类型
     */
    public class AppDelegate implements ItemViewDelegate<RecommendBean.RecommendAppBean>{

        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_applist_horizontal;
        }

        @Override
        public boolean isForViewType(RecommendBean.RecommendAppBean item, int position) {
            return item.getType() == 0;
        }

        @Override
        public void convert(ViewHolder holder, final RecommendBean.RecommendAppBean recommendAppBean, int position) {
            holder.setText(R.id.tv_item_title,recommendAppBean.getTitle());
            RecyclerView rv = holder.getView(R.id.rv_applist_item);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext) ;
            linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
            rv.setLayoutManager(linearLayoutManager);
            final AppItemAdapter adapter = new AppItemAdapter(mContext);
            adapter.addDataAll(recommendAppBean.getAppList());
            rv.setAdapter(adapter);

            adapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                    if(mListener != null){
                        mListener.goAppDetail(recommendAppBean.getAppList().get(position).getPackageName());

                        //recyclerview中的点击事件一般需要自定义在adapter中，
                        // 所以直接调用adapter中的setOnItemClickListener方法
                        //onItemClick方法参数中的position就是点击的位置，
                        // 同时可以在adapter中定义setSelectedPosition()方法设置点击的位置，
                        //然后在adapter中定义getSelectedPosition()获取被选中的位置

                        //1 、通过调用getSelectedPosition()方法获取上一次被选中的位置
                        //如果首次点击的话获取到的是-1
                        int selectedPosition = adapter.getSelectedPosition();
                        //如果是同一个位置就return
                        if(selectedPosition == position){
                            return ;
                        }
                        //如果不是同一个位置，再去做相关的业务逻辑，
                        // 最后调用setSelectedPosition方法将此次点击的位置设定为选中的位置
                        adapter.setSelectedPosition(position);
                    }
                }

                @Override
                public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                    return false;
                }
            });

            //更多按钮的点击事件
            holder.setOnClickListener(R.id.more_btn, new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            }) ;
        }
    }

    public class AdDetegate implements ItemViewDelegate<RecommendBean.RecommendAppBean>{

        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_ad;
        }

        @Override
        public boolean isForViewType(RecommendBean.RecommendAppBean item, int position) {
            return item.getType() == 1;
        }

        @Override
        public void convert(ViewHolder holder, RecommendBean.RecommendAppBean recommendAppBean, int position) {
            holder.setImageUrl(R.id.iv_ad1,recommendAppBean.getIconList().get(0));
            holder.setImageUrl(R.id.iv_ad2,recommendAppBean.getIconList().get(1));
        }
    }

    public class AppItemAdapter extends CommonAdapter<AppBean>{

        public AppItemAdapter(Context context) {
            super(context, R.layout.item_app);
        }

        @Override
        protected void convert(ViewHolder holder, AppBean appBean, int position) {
            holder.setImageUrl(R.id.iv_app_icon,appBean.getIcon());
            holder.setText(R.id.tv_app_name,appBean.getName()) ;
            holder.setText(R.id.tv_app_size,appBean.getSizeDesc());
            holder.setTypeface(Typeface.DEFAULT_BOLD,R.id.tv_app_name);
        }

        //adapter中定义两个方法，用于设置选中的位置和获取选中的位置
        //定义变量用于存储被选中的位置，默认值-1
        private int selectedPosition = -1 ;
        public void setSelectedPosition(int position){
            this.selectedPosition = position ;
        }


        public int getSelectedPosition(){
            return selectedPosition ;
        }
    }

}
