package com.example.f23midtermpart2ritika;

import android.graphics.Bitmap;

public class Product {

    private String productName;
    private Bitmap productImage;

    public Product(String productName, Bitmap productImage) {
        this.productName = productName;
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public Bitmap getProductImage() {
        return productImage;
    }
}
