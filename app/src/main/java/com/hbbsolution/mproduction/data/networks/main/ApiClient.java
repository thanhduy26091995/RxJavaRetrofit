package com.hbbsolution.mproduction.data.networks.main;


import com.hbbsolution.mproduction.utils.AppConstants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 18/07/2017.
 */

public class ApiClient {

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .method(original.method(), original.body()).build();
                        return chain.proceed(request);
                    }
                });

        OkHttpClient client = httpClient.build();
        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.URL_CURRENT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    public static Retrofit getClientRx() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
//                        Response response = chain.proceed(original);
//
//                        if(response.code() == 404) {
//
//                        }
//
                        Request request = original.newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .method(original.method(), original.body()).build();
                        return chain.proceed(request);
                    }
                });

        OkHttpClient client = httpClient.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.URL_CURRENT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

}
