package com.example.administrator.my_10_17fragment.okhttp;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/10/17.
 */

public class OkhttpUtils {
    private static OkhttpUtils okhttpUtils;
    private OkHttpClient client;
   public OkhttpUtils(){
       client=new OkHttpClient.Builder().build();
   }

    public static synchronized OkhttpUtils getInstance() {
        if (okhttpUtils==null){
            okhttpUtils=new OkhttpUtils();
        }
        return okhttpUtils;
    }
    public void setGet(String url, Callback callback){
        Request build = new Request.Builder().url(url).build();
        Call call = client.newCall(build);
        call.enqueue(callback);
    }
}
