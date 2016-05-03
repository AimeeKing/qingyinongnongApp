package com.example.hdu.qingyinongnong.activities.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.adapter.AnswerRecyclerViewAdapter;
import com.example.hdu.qingyinongnong.model.Question;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyanswerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyanswerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int page_Position;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AnswerRecyclerViewAdapter recyclerAdapter;


    public static MyanswerFragment newInstance(int param1) {
        MyanswerFragment fragment = new MyanswerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public MyanswerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_knowladge_fragment, container, false);
        initview(v);
        return v;
    }

    private void initview(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        layoutManager =new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Question> itemList=nettask();
        recyclerAdapter = new AnswerRecyclerViewAdapter(getActivity(),getContext(),itemList);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private ArrayList<Question> nettask() {
        ArrayList<Question> itemList=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            Question c = new Question();
            c.setTitle("为什么豆荚加一下水会变成毛的，求大神解释一下");
            c.setLove_num(42);
            c.setTalk_num(15);
            Calendar cal =Calendar.getInstance();
            cal.set(Calendar.YEAR, 2016);
            cal.set(Calendar.MONTH, 8);
            cal.set(Calendar.DAY_OF_MONTH, 3);
            cal.add(Calendar.DATE, -4);
            Date date=cal.getTime();
            c.setTime(date);
            c.setImg("http://huaban.com/go/?pin_id=676320449");
            c.setUser_id(1010101);
            itemList.add(c);
        }
        return itemList;
    }



}
