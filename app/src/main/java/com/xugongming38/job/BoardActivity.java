package com.xugongming38.job;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xugongming38.job.fragments.AddFragment;
import com.xugongming38.job.fragments.MainFragment;
import com.xugongming38.job.fragments.MeFragment;
import com.xugongming38.job.fragments.MessageFragment;
import com.xugongming38.job.fragments.RecentFragment;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import eu.long1.spacetablayout.SpaceTabLayout;

public class BoardActivity extends AppCompatActivity {

    SpaceTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        init4Bmob();
        //add the fragments you want to display in a List
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MainFragment());
        fragmentList.add(new MessageFragment());
        fragmentList.add(new AddFragment());
        fragmentList.add(new RecentFragment());
        fragmentList.add(new MeFragment());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (SpaceTabLayout) findViewById(R.id.spaceTabLayout);

        //we need the savedInstanceState to get the position
        tabLayout.initialize(viewPager, getSupportFragmentManager(),
                fragmentList, savedInstanceState);

    }

    //we need the outState to save the position
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        tabLayout.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    private void init4Bmob() {
        Bmob.initialize(this, "3d2359dce4b8cbd89dc489cbcc544340");
    }

}
