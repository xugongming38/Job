package com.xugongming38.job.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xugongming38.job.BmobUtils.Genius;
import com.xugongming38.job.R;


public class AddFragment extends Fragment {
    EditText title;
    EditText content;
    EditText name;
    EditText phone;
    Button start_remembering;
    View view=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_add,container,false);

        title = (EditText) view.findViewById(R.id.title);
        content = (EditText) view.findViewById(R.id.content);
        name = (EditText) view.findViewById(R.id.name);
        phone = (EditText) view.findViewById(R.id.phone);

        start_remembering = (Button) view.findViewById(R.id.start_remembering);

        start_remembering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (!title.getText().toString().trim().isEmpty() && !content.getText().toString().trim().isEmpty() && !name.getText().toString().trim().isEmpty()&& !phone.getText().toString().trim().isEmpty())
                    {
                        Genius.Send(getContext(),title.getText().toString(),content.getText().toString(),name.getText().toString(),phone.getText().toString());

                        title.setText("");
                        content.setText("");
                        name.setText("");
                        phone.setText("");
                    }
                    else
                    {
                        Toast.makeText(getContext(),"请写点东西吧.",Toast.LENGTH_SHORT).show();
                        Genius.Receive(getContext());
                        //Toast.makeText(getContext(), Genius.Receive(getContext()).size()+"***",Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(getContext(),"错误，请重试！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
}

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
