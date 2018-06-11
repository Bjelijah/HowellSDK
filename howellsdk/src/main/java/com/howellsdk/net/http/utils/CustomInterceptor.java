package com.howellsdk.net.http.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by PandaQ on 2016/11/10.
 * email : 767807368@qq.com
 */

public class CustomInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .header("User-agent", "Mozilla/4.0")
                .build();

        Log.i("123","url="+request.url()+"    connect="+chain.connection()+"   head="+request.headers()+"  req body"+request.body());
        Response response = chain.proceed(request);
        ResponseBody body= response.peekBody(1024*1024);
        Log.i("123","res="+response.toString()+"  head="+response.headers()+"   body="+body.string());
        return response;
    }
}
