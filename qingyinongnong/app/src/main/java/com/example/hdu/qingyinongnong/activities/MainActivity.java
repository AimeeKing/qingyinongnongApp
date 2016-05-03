package com.example.hdu.qingyinongnong.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.activities.fragment.CrowdfundingFrgment;
import com.example.hdu.qingyinongnong.activities.fragment.ExploreFramgent;
import com.example.hdu.qingyinongnong.activities.fragment.MyFramgent;
import com.example.hdu.qingyinongnong.activities.fragment.Question_fragment;
import com.example.hdu.qingyinongnong.activities.fragment.menuFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout mTabQuestion;
    private LinearLayout mTabExplore;
    private LinearLayout mTabCrowdFund;
    private LinearLayout mTabMy;
    private ImageButton [] mImg;
    private Fragment[]mTab ;
    private int imgWhite[] = { R.drawable.icon_1, R.drawable.icon_2, R.drawable.icon_3, R.drawable.icon_4 };
    private int imgBlack[] = { R.drawable.icon_1t, R.drawable.icon_2t, R.drawable.icon_3t, R.drawable.icon_4t };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        init_view();
        initEvernt();



    }

    private void init_view() {
        mImg=new ImageButton[5];
        mTab = new Fragment[5];//第5个界面是菜谱
        mTabQuestion = (LinearLayout) findViewById(R.id.question);
        mTabExplore = (LinearLayout) findViewById(R.id.explore);
        mTabCrowdFund = (LinearLayout) findViewById(R.id.crowdfunding);
        mTabMy = (LinearLayout) findViewById(R.id.my);

        mImg[0] = (ImageButton) findViewById(R.id.id_tab_question_img);
        mImg[1] = (ImageButton) findViewById(R.id.id_tab_explore_img);
        mImg[2] = (ImageButton) findViewById(R.id.id_tab_crowdfunding_img);
        mImg[3] = (ImageButton) findViewById(R.id.id_tab_my_img);
        mImg[4] = (ImageButton) findViewById(R.id.menu_btn);
        initFragment(0);


    }

    private void initFragment(int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fmtran=fm.beginTransaction();
        switch (position) {
            case 0:
                if (mTab[0] == null) {
                    mTab[0] = new Question_fragment();
                    fmtran.add(R.id.content, mTab[0]);
                } else
                    fmtran.show(mTab[0]);
                break;
            case 1:
                if (mTab[1] == null) {
                    mTab[1] = new ExploreFramgent();
                    fmtran.add(R.id.content, mTab[1]);
                } else
                    fmtran.show(mTab[1]);
                break;
            case 2:
                if (mTab[2] == null) {
                    mTab[2] = new CrowdfundingFrgment();
                    fmtran.add(R.id.content, mTab[2]);
                } else
                    fmtran.show(mTab[2]);
                break;
            case 3:
                if (mTab[3] == null) {
                    mTab[3] = new MyFramgent();
                    fmtran.add(R.id.content, mTab[3]);
                } else
                    fmtran.show(mTab[3]);
                break;
            case 4:
                if(mTab[4] == null)
                {
                    mTab[4] = new menuFragment();
                    fmtran.add(R.id.content,mTab[4]);
                }
                else
                    fmtran.show(mTab[4]);
                break;
        }
        if(position<4)
            mImg[position].setImageResource(imgBlack[position]);
        fmtran.commit();
    }

    private void initEvernt() {
        mTabQuestion.setOnClickListener(this);
        mTabExplore.setOnClickListener(this);
        mTabCrowdFund.setOnClickListener(this);
        mTabMy.setOnClickListener(this);
        mImg[4].setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fmtran = fm.beginTransaction();
        for(int i = 0;i < 5;i++)
        {
            if(mTab[i] != null)
                fmtran.hide(mTab[i]);
            if(i<4)
                mImg[i].setImageResource(imgWhite[i]);
        }
        fmtran.commit();
        switch (v.getId())
        {
            case R.id.question:
                //如果按的是第一个界面
                initFragment(0);
                break;
            case R.id.explore:
                initFragment(1);
                break;
            case R.id.crowdfunding:
                initFragment(2);
                break;
            case R.id.my:
                initFragment(3);
                break;
            case R.id.menu_btn:
                initFragment(4);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
