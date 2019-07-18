package com.tae.vkursimvp.di.module;

import com.tae.vkursimvp.listcurrency.ListCurrencyContract;
import com.tae.vkursimvp.listcurrency.MainActivity;
import com.tae.vkursimvp.listcurrency.MainPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ViewModule {

    @Binds
    public abstract ListCurrencyContract.View view (MainActivity mainActivity);

    @Provides
    static ListCurrencyContract.Presenter provideAuthPresenter(ListCurrencyContract.View view, ListCurrencyContract.Model model) {
        return new MainPresenter(view, model);
    }
}
