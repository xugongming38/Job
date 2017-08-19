package com.xugongming38.job.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xugongming38.job.MainActivity;
import com.xugongming38.job.R;
import com.xugongming38.job.entity.JobInfo;

import java.util.List;

/**
 * Created by dell on 2017/6/24.
 */


public class JobInfoAdapter extends BaseAdapter
{
    List<JobInfo> items = null;
    Context context=null;

    public JobInfoAdapter(Context context,List<JobInfo> items)
    {
        this.items = items;
        this.context = context;
    }

    public int getCount()
    {
        return this.items.size();
    }

    public Object getItem(int paramInt)
    {
        return null;
    }

    public long getItemId(int paramInt)
    {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
        if (paramView == null)
        {
            LayoutInflater localLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            paramView = localLayoutInflater.inflate(R.layout.list_item, paramViewGroup, false);
            localLayoutInflater.inflate(R.layout.list_item, paramViewGroup, false);
        }
        Typeface localTypeface = Typeface.createFromAsset(context.getAssets(), "Roboto-Thin.ttf");
        TextView tvTitle = (TextView)paramView.findViewById(R.id.title);
        TextView tvContent = (TextView)paramView.findViewById(R.id.content);
        TextView tvName = (TextView)paramView.findViewById(R.id.name);
        TextView tvPhone = (TextView)paramView.findViewById(R.id.phone);

        tvTitle.setTypeface(localTypeface);
        tvContent.setTypeface(localTypeface);
        tvName.setTypeface(localTypeface);
        tvPhone.setTypeface(localTypeface);

        JobInfo job = (JobInfo) this.items.get(paramInt);
        tvTitle.setText(job.getTitle());
        tvContent.setText(job.getContent());
        tvName.setText("联系人: "+job.getName());
        tvName.setText("电话: "+job.getPhone());

        return paramView;
    }
}
