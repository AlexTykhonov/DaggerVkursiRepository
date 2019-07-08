package com.tae.vkursimvp.di.component;

import android.app.Application;

import com.tae.vkursimvp.App;
import com.tae.vkursimvp.di.module.ActivityModule;
import com.tae.vkursimvp.di.module.AppModule;
import com.tae.vkursimvp.di.module.RetrofitModule;
import com.tae.vkursimvp.di.module.UserProvider;

import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules={AndroidSupportInjectionModule.class, ActivityModule.class, AppModule.class, RetrofitModule.class, UserProvider.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);
}
