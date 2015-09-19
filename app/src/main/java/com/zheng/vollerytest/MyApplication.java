package com.zheng.vollerytest;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by michael on 2015/9/19.
 */
public class MyApplication extends Application {

    public static RequestQueue sRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        sRequestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getHttpRequestQueue(){

        return sRequestQueue;

    }


}
