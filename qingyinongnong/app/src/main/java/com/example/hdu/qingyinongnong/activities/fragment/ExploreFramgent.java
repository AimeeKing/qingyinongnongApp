package com.example.hdu.qingyinongnong.activities.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.activities.TextEditActivity;
import com.example.hdu.qingyinongnong.adapter.SimplePageAdapter;


public class ExploreFramgent extends Fragment {
    private static final int NONGNONGCIRCLE =2;
    ViewPager viewPager;
    TabLayout tabLayout;
    ImageButton editBtn;
    private SimplePageAdapter crowdfund_adapter;
    public ExploreFramgent() {
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
       View v = inflater.inflate(R.layout.fragment_explore, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        viewPager = (ViewPager) v.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) v.findViewById(R.id.tablayout);
        editBtn = (ImageButton) v.findViewById(R.id.edit_btn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TextEditActivity.class);
                startActivity(i);
            }
        });
        String tabTitles[] =new String[]{"农农圈","我的关注"};
        crowdfund_adapter = new SimplePageAdapter(getChildFragmentManager(), getContext(),tabTitles,NONGNONGCIRCLE );
        viewPager.setAdapter(crowdfund_adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
