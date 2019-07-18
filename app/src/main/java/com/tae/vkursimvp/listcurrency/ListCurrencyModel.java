package com.tae.vkursimvp.listcurrency;

import com.tae.vkursimvp.NbuInterface;
import com.tae.vkursimvp.RetrofitClient;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ListCurrencyModel implements ListCurrencyContract.Model {

   //@Inject
    NbuInterface nbuInterface1;

public ListCurrencyModel ()
{ }
public ListCurrencyModel (NbuInterface nbuInterface)
{
 this.nbuInterface1 = nbuInterface;
}

    NbuInterface nbuInterface = RetrofitClient.callRetrofit().create(NbuInterface.class);

    @Override
    public void getCurrencyList(ListCurrencyContract.APIListener apiListener) {
        nbuInterface.getNbuData()
                .subscribeOn(Schedulers.computation())
               .observeOn(AndroidSchedulers.mainThread())
                .subscribe(apiListener::onSuccess, apiListener::onFailure);
        System.out.println(nbuInterface1+"____Interface from MODEL________________________________________---------------");

    }
}
