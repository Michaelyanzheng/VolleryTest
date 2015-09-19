package com.zheng.vollerytest;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

/**
 * Created by michael on 2015/9/19.
 */
public class RequestUtils {

    public static AsyncHttpClient sAsyncHttpClient = new AsyncHttpClient();

    public static void ClientGet(String url,NetCallBack netCallBack){
        sAsyncHttpClient.get(url,netCallBack);
    }

    public static void ClientPost(String url,
                                  RequestParams requestParams,
                                  NetCallBack netCallBack){

        sAsyncHttpClient.post(url,requestParams,netCallBack);
    }
}
