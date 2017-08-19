package com.xugongming38.job.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.xugongming38.job.view.AutoEditText;
import com.xugongming38.job.R;

import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {
    private AutoEditText name;
    private AutoEditText passWord;
    private AutoEditText passWordComfirm;
    private Button register;
    private ImageView bg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    private void initViews() {
        name = (AutoEditText) findViewById(R.id.aet_register_name);
        passWord = (AutoEditText) findViewById(R.id.aet_register_password);
        passWordComfirm = (AutoEditText) findViewById(R.id.aet_register_password_confirm);
        register = (Button) findViewById(R.id.btn_register_confirm);
        bg = (ImageView) findViewById(R.id.iv_register_bg);register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText().toString().trim())) {
                    name.startShakeAnimation();
                    return;
                }
                if (TextUtils.isEmpty(passWord.getText())) {
                    return;
                }
                if (TextUtils.isEmpty(passWordComfirm.getText())) {
                    passWordComfirm.startShakeAnimation();
                    return;
                }
                if (!passWord.getText().toString().trim().equals(passWordComfirm.getText().toString().trim())) {
                    return;
                }

                /*User user = new User();
//                                默认注册为男性
                user.setSex(true);
//                                 设备类型
                user.setDeviceType("android");
//                                与设备ID绑定
                user.setInstallId(BmobInstallation.getInstallationId(RegisterActivity.this));
                user.setNick(RandomData.getRandomNick());
                user.setAvatar(RandomData.getRandomAvatar());
                user.setSortedKey(CommonUtils.getSortedKey(user.getNick()));
                user.setUsername(name.getText().toString().trim());
                user.setPassword(passWord.getText().toString().trim());
                user.setTitleWallPaper(RandomData.getRandomTitleWallPaper());
                user.setWallPaper(RandomData.getRandomWallPaper());
                user.signUp(CustomApplication.getInstance(), new SaveListener() {
                    @Override
                    public void onSuccess() {
//                                                      进行用户Id和设备的绑定
                        if (UserManager.getInstance().getCurrentUser() != null) {
                            LogUtil.e("uid：" + UserManager.getInstance().getCurrentUser().getObjectId());
                        }
                        Intent intent = new Intent();
                        intent.putExtra("username", name.getText().toString().trim());
                        intent.putExtra("password", passWord.getText().toString().trim());
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        dismissLoadDialog();
                        ToastUtils.showShortToast("注册失败" + s + i);
                    }
                });
                */
            }
        });
    }


}
