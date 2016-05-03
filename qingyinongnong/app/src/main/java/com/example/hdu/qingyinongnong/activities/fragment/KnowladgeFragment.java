package com.example.hdu.qingyinongnong.activities.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.adapter.KnowledgeRecyclerAdapter;
import com.example.hdu.qingyinongnong.model.Question;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*这个界面对应农农小知识和我的回答中的recyclerview部分*/
public class KnowladgeFragment extends Fragment {
    private int page_Position;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private KnowledgeRecyclerAdapter recyclerAdapter;

    public static KnowladgeFragment newInstance(int position) {

        Bundle args = new Bundle();

        KnowladgeFragment fragment = new KnowladgeFragment();
        args.putInt("page_Position",position);
        fragment.setArguments(args);
        return fragment;
    }
    public KnowladgeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            page_Position = getArguments().getInt("page_Position");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_knowladge_fragment, container, false);
        initview(v);
        return v;
    }

    private void initview(View v) {
         recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        layoutManager =new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Question> itemList=nettask();
        recyclerAdapter = new KnowledgeRecyclerAdapter(getActivity(),getContext(),itemList);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private ArrayList<Question> nettask() {
        ArrayList<Question> itemList=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            Question c = new Question();
            c.setTitle("进口圆茄产量丰富");
            c.setDescrib("所以知乎要想停止堕落,必须要保证非常高的问题质量。想到两点,一是允许用户对问题给出支持和反对的评价。");
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
