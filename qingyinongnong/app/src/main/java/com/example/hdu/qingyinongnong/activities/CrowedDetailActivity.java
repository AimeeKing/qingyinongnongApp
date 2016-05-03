package com.example.hdu.qingyinongnong.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hdu.qingyinongnong.R;

import java.util.ArrayList;
import java.util.List;

public class CrowedDetailActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private LinearLayout linearLayout;//放点的集合
    private List<ImageView> img;//图片集合
    private ImageView dot[];//点集合
    private ViewPager headViewPager;
    private List<String> path;//图片地址
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crowed_detail);
        initView();
    }
    private void initView()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        setViewPager();

    }

    private void setViewPager() {
        linearLayout = (LinearLayout) findViewById(R.id.dots);
        headViewPager = (ViewPager) findViewById(R.id.head_viewPager);
        path=new ArrayList<>();
        for (int i=0;i<4;i++)//暂时先这样
            path.add("url");
        //放点
        dot = new ImageView[path.size()];
        for (int i = 0; i < path.size(); i++) {
            ImageView imgview = new ImageView(this);
            imgview.setLayoutParams(new ActionBar.LayoutParams(10, 10));
            dot[i] = imgview;
            if (i == 0) {
                //初始化的时候第0张图片被选择
                dot[i].setBackgroundResource(R.drawable.login_point);
            } else {
                dot[i].setBackgroundResource(R.drawable.login_point);
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams
                    (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 5;
            layoutParams.rightMargin = 5;
            linearLayout.addView(imgview, layoutParams);
        }


        img = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            ImageView imgview = new ImageView(this);
            imgview.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img.add(imgview);
            setPic(imgview, path.get(i));//装载图片
        }

        headViewPager.setAdapter(new MyAdapter(img, this));

        headViewPager.addOnPageChangeListener(this);
    }

    private void setPic(ImageView imgview, String s) {
        imgview.setImageResource(R.drawable.shucai2);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int arg0) {
        for (int i = 0; i < dot.length; i++) {
            if (arg0 == i) {
                dot[i].setImageResource(R.drawable.login_point_selected);
            } else {
                dot[i].setImageResource(R.drawable.login_point);
            }
            if(arg0 !=0)
                dot[0].setImageResource(R.drawable.login_point);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    private class MyAdapter extends PagerAdapter {
        private List<ImageView> imageViews;
        private Context context;

        public MyAdapter(List<ImageView> imageViews, Context context) {
            this.imageViews = imageViews;
            this.context = context;
        }

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(imageViews.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager) container).addView(imageViews.get(position));
            return imageViews.get(position);
        }
    }
}
