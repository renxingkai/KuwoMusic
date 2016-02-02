package com.example.administrator.kuwomusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Welcome extends AppCompatActivity {

    private static final String TAG = "Welcome";

    MediaPlayer mediaPlayer = new MediaPlayer();

    private final int delayTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        /**
         * 开启欢迎界面延时3秒进入主界面
         */
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(Welcome.this,MainInterface.class);
//                Welcome.this.startActivity(intent);
//                Welcome.this.finish();
//            }
//        },delayTime);
        /**
         * 在欢迎界面的同时播放“听音乐用酷我”
         */
        mediaPlayer = MediaPlayer.create(this, R.raw.kuwo);
        mediaPlayer.start();
        /**
         * 跳过广告按钮
         */
        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, MainInterface.class));
            }
        });
    }

}
