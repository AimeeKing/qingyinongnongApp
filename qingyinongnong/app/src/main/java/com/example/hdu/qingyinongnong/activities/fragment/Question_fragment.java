package com.example.hdu.qingyinongnong.activities.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.adapter.SimplePageAdapter;


public class Question_fragment extends Fragment {
    private static final int QUESTION = 0;
    private TabLayout tab;
    private ViewPager viewPager;
    private SimplePageAdapter adapter;

    public Question_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_question, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        tab = (TabLayout) v.findViewById(R.id.tablayout);
        viewPager = (ViewPager) v.findViewById(R.id.viewPager);
        adapter = new SimplePageAdapter(getChildFragmentManager(),getContext(),
                new String[]{"农农小知识","我的回答"},QUESTION);
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
    }


}
