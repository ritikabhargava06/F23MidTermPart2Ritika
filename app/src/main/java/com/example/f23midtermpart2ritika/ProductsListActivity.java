package com.example.f23midtermpart2ritika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ProductsListActivity extends AppCompatActivity {

    ListView productsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        productsListView = findViewById(R.id.productsListView);
        ProductBaseAdapter baseAdapter = new ProductBaseAdapter(((MyApp)getApplication()).getProductArrayList(),this);
        productsListView.setAdapter(baseAdapter);
    }
}