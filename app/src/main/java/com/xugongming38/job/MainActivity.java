package com.xugongming38.job;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.xugongming38.job.entity.JobInfo;
import com.xugongming38.job.fragments.AddFragment;
import com.xugongming38.job.fragments.MeFragment;
import com.xugongming38.job.fragments.MessageFragment;
import com.xugongming38.job.fragments.MainFragment;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {
    TabLayout mTablayout;
    ViewPager mViewPager;

    private TabLayout.Tab main;
    private TabLayout.Tab message;
    private TabLayout.Tab add;
    private TabLayout.Tab me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init4Bmob();


        getSupportActionBar().setTitle("");//最上面一栏设置标题

        //当出现R变红报错，重启grade无果，考虑使用clear project
        //设置ActionBar背景
        Drawable draw=this.getResources().getDrawable(R.drawable.actionbar_bg);
        getSupportActionBar().setBackgroundDrawable(draw);


        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }

    private void init4Bmob() {
        Bmob.initialize(this, "3d2359dce4b8cbd89dc489cbcc544340");
    }

    private void initEvents() {
        mTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == mTablayout.getTabAt(0)) {
                    main.setIcon(getResources().getDrawable(R.drawable.main2));
                    mViewPager.setCurrentItem(0);
                } else if (tab == mTablayout.getTabAt(1)) {
                    message.setIcon(getResources().getDrawable(R.drawable.message2));
                    mViewPager.setCurrentItem(1);
                } else if (tab == mTablayout.getTabAt(2)) {
                    add.setIcon(getResources().getDrawable(R.drawable.add2));
                    mViewPager.setCurrentItem(2);
                } else if (tab == mTablayout.getTabAt(3)) {
                    me.setIcon(getResources().getDrawable(R.drawable.me2));
                    mViewPager.setCurrentItem(3);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab == mTablayout.getTabAt(0)) {
                    main.setIcon(getResources().getDrawable(R.drawable.main1));
                } else if (tab == mTablayout.getTabAt(1)) {
                    message.setIcon(getResources().getDrawable(R.drawable.message1));
                } else if (tab == mTablayout.getTabAt(2)) {
                    add.setIcon(getResources().getDrawable(R.drawable.add1));
                } else if (tab == mTablayout.getTabAt(3)) {
                    me.setIcon(getResources().getDrawable(R.drawable.me1));
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initViews() {
        mTablayout= (TabLayout) findViewById(R.id.tabLayout);
        mViewPager= (ViewPager) findViewById(R.id.viewPager);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            private String[] mTitles = new String[]{"首页","消息", "发布", "我"};

            @Override
            public Fragment getItem(int position) {
                if (position == 1) {
                    return new MessageFragment();
                }
                else if (position == 2) {
                    return new AddFragment();
                }
                else if (position == 3) {
                    return new MeFragment();
                }
                return new MainFragment();
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }

        });

        mTablayout.setupWithViewPager(mViewPager);

        main = mTablayout.getTabAt(0);
        message = mTablayout.getTabAt(1);
        add = mTablayout.getTabAt(2);
        me = mTablayout.getTabAt(3);

        main.setIcon(getResources().getDrawable(R.drawable.main1));
        message.setIcon(getResources().getDrawable(R.drawable.message1));
        add.setIcon(getResources().getDrawable(R.drawable.add1));
        me.setIcon(getResources().getDrawable(R.drawable.me1));

    }

}
