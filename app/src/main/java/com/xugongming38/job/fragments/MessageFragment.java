package com.xugongming38.job.fragments;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.xugongming38.job.BmobUtils.Genius;
import com.xugongming38.job.R;
import com.xugongming38.job.adapter.JobInfoAdapter;
import com.xugongming38.job.entity.JobInfo;

import java.util.ArrayList;
import java.util.List;

import lumenghz.com.pullrefresh.PullToRefreshView;

import static com.xugongming38.job.R.*;


public class MessageFragment extends Fragment {

    private ReceiveBroadCast receiveBroadCast;

    PullToRefreshView mPullToRefreshView=null;
    ListView mListView=null;
    View view;
    static ArrayList<JobInfo> strs = new ArrayList<JobInfo>();

    @Override
    public void onAttach(Activity activity) {
        /** 注册广播 */
        receiveBroadCast = new ReceiveBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.MessageFragment");    //只有持有相同的action的接受者才能接收此广播
        activity.registerReceiver(receiveBroadCast, filter);
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(layout.fragment_message,container,false);

        //getActivity().getActionBar().setTitle("消息");

        mListView= (ListView) view.findViewById(id.list_view);

        if(strs.size()==0){
            strs=(ArrayList<JobInfo>)Genius.Receive(getContext());
        }
        mListView.setAdapter(new JobInfoAdapter(getContext(),strs));
        //mListView.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.list_item, R.id.tv,strs));


        mPullToRefreshView=(PullToRefreshView)view.findViewById(id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //getActivity().setTitle("刷新中..");
                        Intent intent = new Intent(); // Itent就是我们要发送的内容
                        intent.setAction("com.MessageFragment"); // 设置你这个广播的action
                        getContext().sendBroadcast(intent); // 发送广播
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, 10);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    class ReceiveBroadCast extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            System.out.println("!!!");
            strs=(ArrayList<JobInfo>)Genius.Receive(getContext());
            mListView.setAdapter(new JobInfoAdapter(getContext(),strs));
            //mListView.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.list_item, R.id.tv,strs));
            //mListView.getAdapter().notify();
            //for(int i=0;i<strs.size();i++)
            //    System.out.println(strs.get(i));
            //getActivity().setTitle("");
           //mListView.getAdapter().
            //mListView.notify();
        }
    }

    /**
     *注销广播...暂时不注销
     * */
    @Override
    public void onDestroyView() {
        //getActivity().unregisterReceiver(receiveBroadCast);
        super.onDestroyView();
    }

}
