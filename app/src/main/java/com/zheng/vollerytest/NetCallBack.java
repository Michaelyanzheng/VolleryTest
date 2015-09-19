package com.zheng.vollerytest;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * Created by michael on 2015/9/19.
 */
public abstract class NetCallBack extends AsyncHttpResponseHandler {

    private static final String TAG = "NetCallBack";

    @Override
    public void onSuccess(String s) {
        super.onSuccess(s);

        Log.d(TAG, "-------onSuccess--------");

        onMySuccess(s);
    }

    @Override
    public void onFailure(Throwable throwable, String s) {
        super.onFailure(throwable, s);
        Log.d(TAG, "-------onFailure--------");

        onMyFailure(throwable,s);
    }

    public abstract void onMySuccess(String result);
    public abstract void onMyFailure(Throwable throwable, String s);
}
