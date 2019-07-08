package com.tae.vkursimvp.di.module;

import com.tae.vkursimvp.NbuInterface;
import com.tae.vkursimvp.RetrofitClient;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    public static final String BASE_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/";

    @Provides
    @Singleton
    public Retrofit retrofitprovider(){  return new Retrofit.Builder()
            .baseUrl(BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    };

    @Provides
    @Singleton
    public NbuInterface getNbuInterface (Retrofit retrofit) {
        return retrofit.create(NbuInterface.class);
    }
}
