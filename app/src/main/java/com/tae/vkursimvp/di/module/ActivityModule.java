package com.tae.vkursimvp.di.module;

import com.tae.vkursimvp.historypage.HistoryActivity;
import com.tae.vkursimvp.listcurrency.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract HistoryActivity contributeHistoryActivity();
}
