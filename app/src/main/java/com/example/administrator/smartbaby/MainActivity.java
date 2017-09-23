package com.example.administrator.smartbaby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {
    VideoView mVideoView;
    private String mVideoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoPath = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
        mVideoView = (VideoView)findViewById(R.id.videoView);
        mVideoView = (VideoView)findViewById(R.id.videoView);
        mVideoView.setMediaController(new MediaController(this));

        Button playButton = (Button)findViewById(R.id.button_play);
        ImageButton imageButton1  = (ImageButton)findViewById(R.id.menu_monitor);
        ImageButton imageButton2  = (ImageButton)findViewById(R.id.menu_statistics);
        ImageButton imageButton3  = (ImageButton)findViewById(R.id.menu_interactive);
        ImageButton imageButton4  = (ImageButton)findViewById(R.id.menu_mine);

        playButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                mVideoView.setVideoPath(mVideoPath);
                mVideoView.requestFocus();
                mVideoView.start();
            }
        });
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mVideoView.setVideoPath(mVideoPath);
                mVideoView.requestFocus();
                mVideoView.start();
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,AlarmActivity.class);
                startActivity(intent);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,InteractiveActivity.class);
                startActivity(intent);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MineActivity.class);
                startActivity(intent);
            }
        });

    }


    /**play rtmp stream
    private void PlayRtmpStream(String rtmpUrl){
        mVideoView.setVideoURI(Uri.parse(rtmpUrl));
        mVideoView.requestFocus();
        mVideoView.start();
    }
    */

}
