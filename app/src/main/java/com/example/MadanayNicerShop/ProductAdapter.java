package com.example.MadanayNicerShop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.MadanayNicerShop.Model.Product;

import java.util.LinkedList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final LinkedList<Product> mProducList;
    private LayoutInflater mInflater;


    public ProductAdapter(LinkedList<Product> mProducList, Context context) {
        mInflater = LayoutInflater.from(context);
        this.mProducList = mProducList;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder productViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public final TextView productItemView;
        final ProductAdapter mAdapter;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productItemView = itemView.findFocus();
            this.mAdapter =
        }
    }
}
