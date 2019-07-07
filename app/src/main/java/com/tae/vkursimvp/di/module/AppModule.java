package com.tae.vkursimvp.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    public Context providesContext(Application application){
        return application;

    }

    // генерация зависимости
    @Provides
    @Singleton
    public SharedPreferences providesSharedPreferences(Context context)
    { return PreferenceManager.getDefaultSharedPreferences(context);

    }
}
