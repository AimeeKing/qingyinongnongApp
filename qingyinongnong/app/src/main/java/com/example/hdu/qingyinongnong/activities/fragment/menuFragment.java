package com.example.hdu.qingyinongnong.activities.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.adapter.MenuRecyclerViewAdapter;
import com.example.hdu.qingyinongnong.model.Menu;

import java.util.ArrayList;


public class menuFragment extends Fragment {


    private RecyclerView menuRecyclerView;
    private MenuRecyclerViewAdapter menuRecyclerViewAdapter;
    private ArrayList<Menu> menuArrayList;

    public menuFragment() {
        // Required empty public constructor
    }

    public static menuFragment newInstance(String param1, String param2) {
        menuFragment fragment = new menuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        menuRecyclerView = (RecyclerView) v.findViewById(R.id.menu_recyclerview);
        menuArrayList = getMenuArrayList();
        menuRecyclerViewAdapter = new MenuRecyclerViewAdapter(getActivity(),getContext(),menuArrayList);
        menuRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        menuRecyclerView.setAdapter(menuRecyclerViewAdapter);
    }

    private ArrayList<Menu> getMenuArrayList() {//模拟获取网络数据
        ArrayList<Menu> menuList = new ArrayList<>();
        Menu menu;
        for(int i=0;i<11;i++)
        {
            menu = new Menu();
            menu.setLookNum(12*i);
            menu.setLoveNum(6*i*i-3+5*i+20);
            menu.setTitle("自制红烧肉");
            menu.setMainPic("http://img.hb.aicdn.com/3bf7b20885d0e476812e85cb0bfac94af6232bb8a1cc8-PeKPp7_fw658");
            menuList.add(menu);
        }
        return menuList;
    }


}
