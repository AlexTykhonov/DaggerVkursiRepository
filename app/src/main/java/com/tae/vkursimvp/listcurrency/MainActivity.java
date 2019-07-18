package com.tae.vkursimvp.listcurrency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.tae.vkursimvp.NbuInterface;
import com.tae.vkursimvp.PojoVal;
import com.tae.vkursimvp.PostsAdapter;
import com.tae.vkursimvp.R;
import com.tae.vkursimvp.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import dagger.Binds;
import dagger.android.support.DaggerAppCompatActivity;
import retrofit2.Retrofit;

public class MainActivity extends DaggerAppCompatActivity implements ListCurrencyContract.View{


    @Inject
    ListCurrencyContract.Presenter presenter;

    RecyclerView recyclerView;
    PostsAdapter postsAdapter;
    ArrayList vallist = new ArrayList();
    Date today;
    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(presenter+ " THIS IS PRESENTER FROM DAGGER");

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postsAdapter = new PostsAdapter(this);
        recyclerView.setAdapter(postsAdapter);

        today = new Date();
        DateFormat dateformat = new SimpleDateFormat("dd.MM.YY");
        System.out.println(dateformat.format(today));
        data = findViewById(R.id.datatoday);
        String t= dateformat.format(today);
        data.setText(t);
    }

    @Override
    public void displayCurrency(ArrayList<PojoVal> pojoNbu) {
        vallist.clear();
        vallist.addAll(pojoNbu);
        postsAdapter.setData(vallist);
        postsAdapter.notifyDataSetChanged();
        System.out.println("________________VIEW___________---------------"+pojoNbu);

    }
}
