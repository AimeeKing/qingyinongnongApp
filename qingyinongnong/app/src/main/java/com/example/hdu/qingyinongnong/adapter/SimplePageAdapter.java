package com.example.hdu.qingyinongnong.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hdu.qingyinongnong.activities.fragment.CrowdAllFragment;
import com.example.hdu.qingyinongnong.activities.fragment.KnowladgeFragment;
import com.example.hdu.qingyinongnong.activities.fragment.MyCrowdfundFragement;
import com.example.hdu.qingyinongnong.activities.fragment.MyCircleFragment;
import com.example.hdu.qingyinongnong.activities.fragment.MyanswerFragment;
import com.example.hdu.qingyinongnong.activities.fragment.Nongnong_fragment;

/**
 * Created by Aimee on 2016/4/14.
 */
public class SimplePageAdapter extends FragmentPagerAdapter {
    private static final int QUESTION = 0;
    private static final int CROWDFUND = 1;
    private static final int NONGNONGCIRCLE =2;
    private int PAGE_COUNT = 2;
    private Context context;
    private int type;
    private String tabTitles[];
    public SimplePageAdapter(FragmentManager fm,Context context,String tabTitles[],int type) {
        super(fm);
        this.context = context;
        this.tabTitles =tabTitles;
        this.type = type;
    }

    @Override
    public Fragment getItem(int position) {
      if(QUESTION==type) {
          if (0 == position)
              return KnowladgeFragment.newInstance(position + 1);
          else
              return MyanswerFragment.newInstance(position + 1);
      }
        else if(CROWDFUND == type){
          if (0 == position)
              return CrowdAllFragment.newInstance(position + 1);
          else
              return MyCrowdfundFragement.newInstance(position + 1);
      }
        else
      {
          if (0 == position)
              return Nongnong_fragment.newInstance(position + 1);
          else
              return MyCircleFragment.newInstance(position + 1);
      }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
