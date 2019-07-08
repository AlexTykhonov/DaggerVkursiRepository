package com.tae.vkursimvp.listcurrency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

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

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements ListCurrencyContract.View{

    @Inject
    User user;

    RecyclerView recyclerView;
    PostsAdapter postsAdapter;
    ArrayList vallist = new ArrayList();
    Date today;
    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(user+ " THIS IS USER FROM DAGGER");


        ListCurrencyContract.Presenter presenter = new MainPresenter(this);

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
