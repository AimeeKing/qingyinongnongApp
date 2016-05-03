package com.example.hdu.qingyinongnong.activities.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.adapter.CrowRecyclerAdapter;
import com.example.hdu.qingyinongnong.model.Crow_funding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MyCrowdfundFragement extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CrowRecyclerAdapter crow_recyclerAdapter;
    // TODO: Rename and change types of parameters
    private int mParam1;

    // TODO: Rename and change types and number of parameters
    public static MyCrowdfundFragement newInstance(int param1) {
        MyCrowdfundFragement fragment = new MyCrowdfundFragement();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    public MyCrowdfundFragement() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_knowladge_fragment, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        recyclerView= (RecyclerView) v.findViewById(R.id.recyclerview);
        ArrayList< Crow_funding > itemList =nettask();
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        crow_recyclerAdapter = new CrowRecyclerAdapter(getActivity(), getContext(),itemList);
        recyclerView.setAdapter(crow_recyclerAdapter);

    }

    private ArrayList< Crow_funding > nettask() {
        ArrayList< Crow_funding > itemList =new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            Crow_funding c = new Crow_funding();
            c.setStatus(i % 2);
            c.setTitle("进口圆茄产量丰富");
            c.setDescrib("所以知乎要想停止堕落,必须要保证非常高的问题质量。想到两点,一是允许用户对问题给出支持和反对的评价。");
            c.setAim_fund(1000);
            c.setHave_fund(100);
            c.setHave_sold(100);
            c.setPeople(123);
            Calendar cal =Calendar.getInstance();
            cal.set(Calendar.YEAR, 2016);
            cal.set(Calendar.MONTH, 8);
            cal.set(Calendar.DAY_OF_MONTH, 3);
            cal.add(Calendar.DATE, -4);
            Date date=cal.getTime();
            c.setPublic_time(date);
            c.setImg("http://huaban.com/go/?pin_id=676320449");
            c.setUser_id(1010101);
            itemList.add(c);
        }
        return itemList;
    }


}
