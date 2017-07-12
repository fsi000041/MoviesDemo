package com.example.caoyang.recyclerviewdemo;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 *
 */
public class getYukicom {

    private static Yukicom yukicom;
    private getYukicom(){}
    public static Yukicom getInstance(){
        if (yukicom == null) {
            yukicom = new Retrofit.Builder().baseUrl(AppConstant.BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).build().create(Yukicom.class);
        }
        return yukicom;

    }
}
