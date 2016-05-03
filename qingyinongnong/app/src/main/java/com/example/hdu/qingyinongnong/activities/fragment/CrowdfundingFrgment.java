package com.example.hdu.qingyinongnong.activities.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.adapter.SimplePageAdapter;


public class CrowdfundingFrgment extends Fragment {
    private static final int CROWDFUND = 1;
    ViewPager viewPager;
    TabLayout tabLayout;
    private SimplePageAdapter crowdfund_adapter;

    public CrowdfundingFrgment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_croedfunding, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        viewPager = (ViewPager) v.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) v.findViewById(R.id.tablayout);
        String tabTitles[] =new String[]{"众筹精选","我的众筹"};
        crowdfund_adapter = new SimplePageAdapter(getChildFragmentManager(), getContext(),tabTitles,CROWDFUND );
        viewPager.setAdapter(crowdfund_adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
