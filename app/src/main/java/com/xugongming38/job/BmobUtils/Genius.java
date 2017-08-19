package com.xugongming38.job.BmobUtils;

import android.content.Context;
import android.widget.Toast;

import com.xugongming38.job.MainActivity;
import com.xugongming38.job.entity.JobInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by dell on 2017/6/22.
 */

public class Genius {
    public static void Send(final Context context,String title,String content,String name,String phone){
        JobInfo job = new JobInfo();
        job.setTitle(title);
        job.setContent(content);
        job.setName(name);
        job.setPhone(phone);
        job.save(context,new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(context,"兼职发布成功!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(context,"兼职发布失败！请重试",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static List<JobInfo> Receive(final Context context) {

        final List<JobInfo> QueryResults =new ArrayList<JobInfo>();

        BmobQuery<JobInfo> bmobQuery = new BmobQuery<JobInfo>();

        String start = "2017-06-22 09:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date  = null;
        try {
            date = sdf.parse(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bmobQuery.addWhereGreaterThanOrEqualTo("createdAt",new BmobDate(date));
        bmobQuery.findObjects(context, new FindListener<JobInfo>() {
            @Override
            public void onSuccess(List<JobInfo> list) {
                Toast.makeText(context,"刷新成功",Toast.LENGTH_SHORT).show();
                for(int i=list.size()-1;i>=0;i--){
                    //String T="[招聘]:"+list.get(i).getTitle()+"\n 详细信息：  "+list.get(i).getContent()+"\n联系人： "+list.get(i).getName()+"\n电话: "+list.get(i).getPhone();
                    //System.out.println(T);
                    QueryResults.add(list.get(i));
                }
            }

            @Override
            public void onError(int i, String s) {
                Toast.makeText(context,"刷新失败",Toast.LENGTH_SHORT).show();
            }
        });
        return QueryResults;
    }
}
