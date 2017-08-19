package com.xugongming38.job.fragments;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xugongming38.job.R;
import com.xugongming38.job.activity.LoginActiviyy;
import com.xugongming38.job.activity.RegisterActivity;
import com.xugongming38.job.utils.FastBlurUtils;
import com.xugongming38.job.view.CircleImageView;

import cn.bmob.push.config.Constant;

public class MeFragment extends Fragment implements View.OnClickListener {

    CircleImageView CircleTmg=null;
    RelativeLayout rl=null;
    View view=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_me, container, false);
        CircleTmg=(CircleImageView)view.findViewById(R.id.head);
        rl=(RelativeLayout)view.findViewById(R.id.bg);
        CircleTmg.setOnClickListener(this);
        return view;
    }

    public void setB(RelativeLayout rl) {
        Resources res = getResources();
        //图片太大易导致崩溃
        Bitmap bmp= BitmapFactory.decodeResource(res, R.drawable.meback);
        Bitmap bmp2= FastBlurUtils.doBlur(bmp,100,false);
        //rl.setImageBitmap(bmp2);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(getContext(), LoginActiviyy.class));
    }
}
