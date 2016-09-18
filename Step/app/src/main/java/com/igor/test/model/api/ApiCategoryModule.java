package com.igor.test.model.api;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class ApiCategoryModule {

    private static final boolean ENABLE_AUTH = false;
    private static final String AUTH_64 = "***"; //your code here


    public static ApiCategoryInterface getApiInterface() {

        OkHttpClient httpClient = new OkHttpClient();
        httpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Authorization", "Basic " + AUTH_64)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });


        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl("http://figaro.service.yagasp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        if (ENABLE_AUTH) builder.client(httpClient);

        ApiCategoryInterface apiCategoryInterface = builder.build().create(ApiCategoryInterface.class);
        return apiCategoryInterface;
    }
}
