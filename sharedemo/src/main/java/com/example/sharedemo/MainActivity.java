package com.example.sharedemo;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private EditText name;
    private EditText psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
        initView();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    private void initView() {
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
        name = (EditText) findViewById(R.id.name);
        name.setOnClickListener(this);
        psw = (EditText) findViewById(R.id.psw);
        psw.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                UMShareAPI.get(MainActivity.this).getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    private String profile_image_url;
                    private String screen_name;
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        Toast.makeText(MainActivity.this, "登录开始", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                        Intent in=new Intent(MainActivity.this,ShowActivity.class);
                        Set<String> strings = map.keySet();
                        for (String string:strings){
                            if (string.equals("iconurl")){
                                profile_image_url = map.get("iconurl");
                            }
                            if (string.equals("name")){
                                screen_name = map.get("name");
                            }
                        }

                        in.putExtra("profile_image_url",profile_image_url);
                        in.putExtra("screen_name",screen_name);
                        startActivity(in);
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                        Toast.makeText(MainActivity.this, "登录取消", Toast.LENGTH_LONG).show();
                    }
                });
                UMShareAPI.get(MainActivity.this).release();
                break;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {


    }
}
