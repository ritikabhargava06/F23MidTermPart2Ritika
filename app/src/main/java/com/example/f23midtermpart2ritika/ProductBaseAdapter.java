package com.example.f23midtermpart2ritika;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductBaseAdapter extends BaseAdapter {

    ArrayList<Product> productsList;
    Context context;

    public ProductBaseAdapter(ArrayList<Product> productsList, Context context) {
        this.productsList = productsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return productsList.size();
    }

    @Override
    public Object getItem(int position) {
        return productsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View productRowView = LayoutInflater.from(context).inflate(R.layout.product_row, parent,false);
        ImageView productRowImage = productRowView.findViewById(R.id.product_row_imageView);
        TextView productRowTextView = productRowView.findViewById(R.id.product_row_textView);
        productRowImage.setImageBitmap(productsList.get(position).getProductImage());
        productRowTextView.setText(productsList.get(position).getProductName());
        return productRowView;
    }
}
