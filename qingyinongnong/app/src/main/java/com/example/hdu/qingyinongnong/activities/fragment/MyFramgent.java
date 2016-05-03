package com.example.hdu.qingyinongnong.activities.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.activities.MyDataActivity;
import com.example.hdu.qingyinongnong.adapter.EntryAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyFramgent extends Fragment {

    public MyFramgent() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my, container, false);
        initView(v);
        return v;
    }

    public ImageView profile_image;
    public TextView user_name;
    public TextView user_sign;
    public ListView my_setting;
    public ImageView setting;
    void initView(View v)
    {
         profile_image= (ImageView) v.findViewById(R.id.profile_image);
         user_name= (TextView) v.findViewById(R.id.user_name);
         user_sign= (TextView) v.findViewById(R.id.user_sign);
         my_setting= (ListView) v.findViewById(R.id.my_setting);
         setting = (ImageView) v.findViewById(R.id.setting);
         setting.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(getActivity(), MyDataActivity.class);
                 startActivity(i);
             }
         });
         String []listName1 = {null,"我的提问","我的众筹","我的收藏","我的钱包",null,"意见反馈","关于我们"};
         int []listImg1 ={16,R.drawable.page5_icon1,R.drawable.page5_icon2,R.drawable.page5_icon3,R.drawable.page5_icon4,
                32,R.drawable.page5_icon5,R.drawable.page5_icon6};
         EntryAdapter settingAdapter = new EntryAdapter(getContext(),getData(listName1,listImg1));
         my_setting.setAdapter(settingAdapter);
}

    private List< Map<String, Object>> getData(String[] listName1, int[] listImg1) {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = null;
        for (int i=0;i<listImg1.length;i++)
        {
            map=new HashMap<>();
            map.put("img",listImg1[i]);
            map.put("title", listName1[i]);
            list.add(map);
        }
        return list;
    }

    }
