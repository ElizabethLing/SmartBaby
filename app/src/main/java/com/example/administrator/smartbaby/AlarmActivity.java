package com.example.administrator.smartbaby;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/22.
 */


public class AlarmActivity extends Activity {
    private LinearLayout mLinearLayout;
    private LinearLayout mLinearLayoutAlarm;
    private LinearLayout mLinearLayoutStatistics;
    private ImageView ImageViewStatistics;
    private ImageView ImageViewAlarm;
    private ArrayList<View> mViewList;

    //0代表报警，1代表统计
    private int currentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_layout);

    }
    private void initView(){
        mLinearLayout = (LinearLayout)findViewById(R.id.linearLayout_content);
        mLinearLayoutAlarm = (LinearLayout)findViewById(R.id.button_layout_alarm);
        mLinearLayoutStatistics = (LinearLayout)findViewById(R.id.button_layout_statistics);

        //为报警和统计按钮设计监听器
        mLinearLayoutAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handTitleIndexImg(0);
                showCurrentListView();
            }
        });
        mLinearLayoutStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handTitleIndexImg(1);
                showCurrentListView();
            }
        });

    }
    //显示报警还是统计
    private void handTitleIndexImg(int position){
        currentType=position;
        ArrayList<View> list=new ArrayList<>();
        list.add(ImageViewStatistics);
        list.add(ImageViewAlarm);
        int size =list.size();
        for (int i=0;i<size;i++){
            list.get(i).setVisibility(View.INVISIBLE);
        }
        list.get(position).setVisibility(View.VISIBLE);
    }
    private void showCurrentListView(){
        mLinearLayout.removeAllViews();
        mLinearLayout.addView(mViewList.get(currentType));
    }


}
