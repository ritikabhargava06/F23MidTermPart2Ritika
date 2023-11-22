package com.example.f23midtermpart2ritika;

import android.app.Application;

import java.util.ArrayList;

public class MyApp extends Application {

    private ArrayList<Product> productArrayList = new ArrayList<>();

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void addToProductArrayList(Product p) {
        productArrayList.add(p);
    }


}
