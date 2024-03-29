package com.tae.vkursimvp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.tae.vkursimvp.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        context =getApplicationContext();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
    private void initDagger(){
        DaggerAppComponent.builder().application(this).build().inject(this);
    }

}
