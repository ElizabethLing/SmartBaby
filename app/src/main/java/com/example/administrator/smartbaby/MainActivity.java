package com.example.administrator.smartbaby;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {
    VideoView mVideoView;
    EditText Url;
    private String mVideoPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url = (EditText)findViewById(R.id.url);
        mVideoView = (VideoView)findViewById(R.id.videoView);
        mVideoView.setVideoPath(mVideoPath);
        mVideoView.setMediaController(new MediaController(this));
        mVideoPath = Url.getEditableText().toString();
        ImageButton imageButton1  = (ImageButton)findViewById(R.id.menu_monitor);
        ImageButton imageButton2  = (ImageButton)findViewById(R.id.menu_statistics);
        ImageButton imageButton3  = (ImageButton)findViewById(R.id.menu_interactive);
        ImageButton imageButton4  = (ImageButton)findViewById(R.id.menu_mine);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.setVideoURI(Uri.parse(mVideoPath));
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


}
