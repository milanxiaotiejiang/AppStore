package com.cn5.appstore.mvp.view.fragment;

import android.view.View;
import android.widget.GridView;

import com.cn5.appstore.R;
import com.cn5.appstore.adapter.MySubAdapter;
import com.cn5.appstore.base.BaseFragment;
import com.cn5.appstore.bean.MyGvBean;
import com.cn5.appstore.utils.UIUtils;
import com.cn5.appstore.view.MultipleStatusView;
import com.cn5.appstore.view.widget.MyEnterLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.gv_title_grid)
    GridView gv_title_grid ;
    @BindView(R.id.book_game_layout)
    MyEnterLayout book_game_layout ;
    @BindView(R.id.buy_layout)
    MyEnterLayout buy_layout ;
    @BindView(R.id.huaban_layout)
    MyEnterLayout huaban_layout ;
    @BindView(R.id.setting_computer)
    MyEnterLayout setting_computer ;
    @BindView(R.id.faq_layout)
    MyEnterLayout faq_layout ;
    @BindView(R.id.check_update_layout)
    MyEnterLayout check_update_layout ;
    @BindView(R.id.about_layout)
    MyEnterLayout about_layout ;

    private List<MyGvBean> gvBeanList = new ArrayList<>() ;
    private String[] titles = {"奖品","礼包",""};

    @Override
    public void initView() {

        gvBeanList.clear();

        gvBeanList.add(new MyGvBean(UIUtils.getString(R.string.market_prize),R.drawable.icon_market_lucky_draw));
        gvBeanList.add(new MyGvBean(UIUtils.getString(R.string.market_gift),R.drawable.ic_mine_package_normal));
        gvBeanList.add(new MyGvBean(UIUtils.getString(R.string.appzone_comments),R.drawable.icon_market_comment));
        gvBeanList.add(new MyGvBean(UIUtils.getString(R.string.market_mine_message),R.drawable.icon_market_message));

        MySubAdapter adapter = new MySubAdapter(getContext(),gvBeanList) ;
        gv_title_grid.setNumColumns(gvBeanList.size());
        gv_title_grid.setAdapter(adapter);

        book_game_layout.setTitle(UIUtils.getString(R.string.reserve_warpup_game_str));
        buy_layout.setTitle(UIUtils.getString(R.string.purchase_title));
        huaban_layout.setTitle(UIUtils.getString(R.string.mine_point_area));
        setting_computer.setTitle(UIUtils.getString(R.string.action_settings));
        faq_layout.setTitle(UIUtils.getString(R.string.menu_feedback));
        check_update_layout.setTitle(UIUtils.getString(R.string.settings_check_version_update));
        about_layout.setTitle(UIUtils.getString(R.string.about));
    }

    @Override
    public View createSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_my) ;
        ButterKnife.bind(this,view) ;





        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        gvBeanList.clear();
    }

    @Override
    public void load() {
        setState(MultipleStatusView.LoadResult.success);
    }
}
