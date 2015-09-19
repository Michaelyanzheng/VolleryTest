package com.zheng.vollerytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        vollery_Get();
//        vollery_Post();

//        asynchttpGet();
//        asynchttpPost();

        requestUtilsPost();

    }

    private void requestUtilsPost() {

        String url = "http://web.juhe.cn:8080/finance/stock/hs?";

        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams requestParams = new RequestParams();

        requestParams.put("gid","sh601009");
        requestParams.put("key","dd2ea2be8f94515b079238abe59f56f1");

        RequestUtils.ClientPost(url, requestParams, new NetCallBack() {
            @Override
            public void onMySuccess(String result) {
                Toast.makeText(MainActivity.this, result,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onMyFailure(Throwable throwable, String s) {

                Toast.makeText(MainActivity.this, "加载失败",Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void asynchttpPost() {

        String url = "http://web.juhe.cn:8080/finance/stock/hs?";

        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams requestParams = new RequestParams();

        requestParams.put("gid","sh601009");
        requestParams.put("key","dd2ea2be8f94515b079238abe59f56f1");

        client.post(url,requestParams,new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                Toast.makeText(MainActivity.this, s,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Throwable throwable, String s) {
                super.onFailure(throwable, s);
                Toast.makeText(MainActivity.this, "加载失败",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void asynchttpGet() {

        String url = "http://web.juhe.cn:8080/finance/stock/hs?gid=sh601009&key=dd2ea2be8f94515b079238abe59f56f1";


        AsyncHttpClient client = new AsyncHttpClient();

        client.get(url,new AsyncHttpResponseHandler(){

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                Toast.makeText(MainActivity.this, s,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Throwable throwable, String s) {
                super.onFailure(throwable, s);

                Toast.makeText(MainActivity.this, "加载失败",Toast.LENGTH_SHORT).show();
            }
        });


    }


    private void vollery_Get() {

        String url = "http://web.juhe.cn:8080/finance/stock/hs?gid=sh601009&key=dd2ea2be8f94515b079238abe59f56f1";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {

                Toast.makeText(MainActivity.this, string,Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(MainActivity.this, "加载失败",Toast.LENGTH_SHORT).show();

            }
        });

        request.setTag("abcGet");
        MyApplication.getHttpRequestQueue().add(request);
    }

    private void vollery_Post() {

        String url = "http://web.juhe.cn:8080/finance/stock/hs?";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {

                Toast.makeText(MainActivity.this, string,Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(MainActivity.this, "加载失败",Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String,String> map = new HashMap<String,String>();

                map.put("gid","sh601009");
                map.put("key","dd2ea2be8f94515b079238abe59f56f1");

                return map;
            }
        };

        request.setTag("abcPost");
        MyApplication.getHttpRequestQueue().add(request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();

        MyApplication.getHttpRequestQueue().cancelAll("abcPost");
        MyApplication.getHttpRequestQueue().cancelAll("abcGet");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
