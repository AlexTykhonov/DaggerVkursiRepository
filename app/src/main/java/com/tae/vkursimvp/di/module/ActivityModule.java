package com.tae.vkursimvp.di.module;

import com.tae.vkursimvp.historypage.HistoryActivity;
import com.tae.vkursimvp.listcurrency.ListCurrencyContract;
import com.tae.vkursimvp.listcurrency.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector (modules = {ViewModule.class})
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract HistoryActivity contributeHistoryActivity();

}
