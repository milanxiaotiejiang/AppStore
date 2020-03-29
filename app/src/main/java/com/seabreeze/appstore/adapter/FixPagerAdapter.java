package com.seabreeze.appstore.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xzhang on 2017/5/6.
 */

public class FixPagerAdapter extends FragmentStatePagerAdapter {

    private String[] titles ;


    private List<Fragment> fragments = null ;

    public void setFragments(List<Fragment> fragments){
        this.fragments = fragments ;
    }

    public void setTitles(String[] titles){
        this.titles = titles ;
    }

    public FixPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment=null;
        try{
            fragment=(Fragment)super.instantiateItem(container,position);
        }catch (Exception e){

        }
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position] ;
    }
}
