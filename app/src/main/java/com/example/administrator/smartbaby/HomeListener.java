package com.example.administrator.smartbaby;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Created by Administrator on 2017/9/24.
 */

public class HomeListener implements View.OnClickListener {
    private Activity activity;
    public HomeListener(Activity activity)
    {
        this.activity = activity;
    }
    @Override
    public void onClick(View source)
    {
        Intent i = new Intent(activity , MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(i);
    }
}
