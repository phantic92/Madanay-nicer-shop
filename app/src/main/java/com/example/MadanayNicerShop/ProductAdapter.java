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
import com.example.MadanayNicerShop.Model.Product;
import java.util.LinkedList;

/**
 * @author Darrell-David Madanay
 * @since 13/10/2019
 * This is the product adapter for the recyclerview. It links the data of the products to the
 * recyclerview in the Menu Activity.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final LinkedList<Product> mProducList;
    private LayoutInflater mInflater;
    private final static String TAG = ProductAdapter.class.getSimpleName();

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

    /**
     * Adds the product data into the appropriate Views.
     * @param holder Product View Holder
     * @param position position
     */
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
        private double subTotalNum;
        private String formatSubtotal;

        /**
         * Constructor
         * @param itemView View
         * @param adapter adapter
         */
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

        /**
         * Listens for click on the decrease or increase buttons. This will then update the quantity
         * TextView and calculate the subtotal.
         * @param view view
         */
        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            Product selectedProduct = mProducList.get(position);
            switch (view.getId()) {
                case R.id.decrease_button:
                    quantityNum = Integer.parseInt(selectedProduct.getQuantity());
                    if (quantityNum > 0) {
                        quantityNum--;
                        Log.d(TAG, "Removing " + selectedProduct.getTitle() +
                                ", Price: " + selectedProduct.getPrice());
                    }
                    break;
                case R.id.increase_button:
                    Log.d(TAG, "Adding " + selectedProduct.getTitle() + " Price: " +
                            selectedProduct.getPrice());
                    quantityNum = Integer.parseInt(selectedProduct.getQuantity());
                    quantityNum++;
                    mQuantity.setText(selectedProduct.getQuantity());
                    break;
            }
            // Display quantity
            selectedProduct.setQuantity(quantityNum + "");
            mQuantity.setText(selectedProduct.getQuantity());
            mQuantity.setText(selectedProduct.getQuantity());

            // Update Subtotal numbers
            subTotalNum = quantityNum * Double.parseDouble(selectedProduct.getPrice());
            formatSubtotal = String.format("%.2f", subTotalNum);
            selectedProduct.setSubtotal(formatSubtotal);
            mSubtotal.setText(selectedProduct.getSubtotal());

            // Update Recyclerview to display the data
            mAdapter.notifyDataSetChanged();
        }
    }
}
