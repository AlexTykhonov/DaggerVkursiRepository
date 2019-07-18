package com.tae.vkursimvp.di.module;

import com.tae.vkursimvp.User;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class UserProvider {

    @Singleton
    @Provides
public User userProvider () {
        User user = new User();
    return user;
}

}
