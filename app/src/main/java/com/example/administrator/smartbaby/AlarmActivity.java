package com.example.administrator.smartbaby;

import android.app.TabActivity;
import android.database.DataSetObserver;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class AlarmActivity extends TabActivity {
    private NetworkInfo.State mState;
    ImageView mImageView;
    List<ScanResult> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_layout);

       // init();
        //设置报警和统计标签
        TabHost mTabHost = this.getTabHost();
        TabHost.TabSpec tabAweak = mTabHost.newTabSpec("tab1").setIndicator("报警").setContent(R.id.tab1);
        mTabHost.addTab(tabAweak);
        TabHost.TabSpec tabStatistics = mTabHost.newTabSpec("tab2").setIndicator("统计").setContent(R.id.tab2);
        mTabHost.addTab(tabStatistics);
       // LayoutInflater.from(this).inflate(R.layout.alarm_items, mTabHost.getTabContentView(), true);
    }

   /* public void init(){
        mState = (NetworkInfo.State) getSystemService(state)
        list = (ArrayList<ScanResult>)mState.getScanResults();
        ListView listView = (ListView) findViewById(R.id.listView);
        if (list == null) {
            Toast.makeText(this, "宝宝在睡觉", Toast.LENGTH_LONG).show();
        } else {
            listView.setAdapter(new MyAdapter(this, list));
        }
    }

    private class MyAdapter implements ListAdapter {
        LayoutInflater inflater;
        List<xxx>list;
        public MyAdapter(AlarmActivity alarmActivity, List<xxx> list) {
            this.inflater = LayoutInflater.from(context);
            this.list = list;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int i) {
            return false;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View mView=null;
            mView = inflater.inflate(R.layout.alarm_items);
            //根据宝宝的状态显示提醒和相应的图标,0代表醒了，1代表蚊虫叮咬，2代表哭泣
            if (mState == 0) {
                mImageView .setImageDrawable(getResources().getDrawable(R.drawable.aweak));
            } else if (mState == 1) {
                mImageView.setImageDrawable(getResources().getDrawable(R.drawable.mosquito_bites));
            }else if (mState == 2) {
                mImageView.setImageDrawable(getResources().getDrawable(R.drawable.cry));
            }
            return view;
        }

        @Override
        public int getItemViewType(int i) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }
    */
}
