package com.example.kaoshi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt;



    private Handler handler = new Handler() ;
    private Runnable runnable=new Runnable() {
        private int a = 5;

        @Override
        public void run() {
            a--;
            txt.setText(a + "");
            if (a == 0) {
                Intent in = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(in);

            }else{
                handler.postDelayed(runnable,1000);
            }
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);

        handler.postDelayed(runnable,1000);
    }
}
