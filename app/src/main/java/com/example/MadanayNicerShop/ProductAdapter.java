package com.example.MadanayNicerShop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mItemView = mInflater.inflate(R.layout.product_template, parent, false);
        return new ProductViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Product mCurrent = mProducList.get(position);
        holder.mTitle.setText(mCurrent.getTitle());
        holder.mDescription.setText(mCurrent.getDescription());
        holder.mPrice.setText(mCurrent.getPrice());
        holder.mQuantity.setText(mCurrent.getQuantity());
        holder.mSubtotal.setText(mCurrent.getSubtotal());
        holder.mImage.setImageResource(mCurrent.getImage());
    }

    @Override
    public int getItemCount() {
        return mProducList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mTitle;
        public final TextView mDescription;
        public final TextView mPrice;
        public final TextView mQuantity;
        public final ImageView mImage;
        public final TextView mSubtotal;
        public final Button mIncreaseButton;
        public final Button mDecreaseButton;
        final ProductAdapter mAdapter;
        private int quantityNum;

        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.item_title);
            mDescription = itemView.findViewById(R.id.item_description);
            mPrice = itemView.findViewById(R.id.item_price_num);
            mQuantity = itemView.findViewById(R.id.item_quantity);
            mSubtotal = itemView.findViewById(R.id.item_subtotal_num);
            mIncreaseButton = itemView.findViewById(R.id.increase_button);
            mDecreaseButton = itemView.findViewById(R.id.decrease_button);
            mImage = itemView.findViewById(R.id.item_image);
            this.mAdapter = adapter;
            mIncreaseButton.setOnClickListener(this);
            mDecreaseButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.decrease_button:
                    Log.d("Product Adapter", "Clicked on decrease button");
                    quantityNum = Integer.parseInt(mQuantity.getText().toString());
                    if (quantityNum > 0)
                        quantityNum--;
                    updateSubtotal(quantityNum);
                    mQuantity.setText(quantityNum + "");
                    break;
                case R.id.increase_button:
                    Log.d("Product Adapter", "Clicked on increase button");
                    quantityNum = Integer.parseInt(mQuantity.getText().toString());
                    quantityNum++;
                    updateSubtotal(quantityNum);
                    mQuantity.setText(quantityNum + "");
                    break;
            }
        }

        public void updateSubtotal(int quantity) {
            double subtotalNum;
            String formatSubtotal;

            subtotalNum = quantity * Double.parseDouble(mPrice.getText().toString());
            formatSubtotal = String.format("%.2f", subtotalNum);
            mSubtotal.setText(formatSubtotal);
        }
    }
}
