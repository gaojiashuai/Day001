package com.example.sharedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout fragment_layout;
    private TextView name;
    private ImageView img;

    private LinearLayout menu_layout;
    private DrawerLayout drawer_layout;
    private TextView tet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        inserte();
    }

    private void inserte() {
        Intent intent = getIntent();
        String iconurl = intent.getStringExtra("profile_image_url");
        Picasso.with(ShowActivity.this).load(iconurl).into(img);
        String name2 = intent.getStringExtra("screen_name");
        name.setText(name2);
    }

    private void initView() {


        fragment_layout = (LinearLayout) findViewById(R.id.fragment_layout);

        name = (TextView) findViewById(R.id.name);

        img = (ImageView) findViewById(R.id.img);


        menu_layout = (LinearLayout) findViewById(R.id.menu_layout);

        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);

        tet = (TextView) findViewById(R.id.tet);
        tet.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        UMShareAPI.get(ShowActivity.this).deleteOauth(ShowActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Toast.makeText(ShowActivity.this, "已退出当前账号", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });
        finish();
    }
}
