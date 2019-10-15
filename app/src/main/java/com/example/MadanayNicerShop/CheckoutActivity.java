/**
 * @Author: Darrell-David Madanay
 * @since 09/20/2019
 * Checkout Activity for shopping app. It contains the total before taxes, the gst, the qst, the
 * shipping cost and the total after taxes
 */

package com.example.MadanayNicerShop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {
    private static final String TAG = "checkoutActivity";
    private static final double GST = 0.05;
    private static final double QST = 0.09975;

    /**
     * onCreate method that updates the total before taxes, the gst, the qst and the total after
     * taxes
     *
     * @param savedInstanceState saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        TextView shippingCost;
        TextView totalView = findViewById(R.id.total_before_taxes_num);
        TextView gstView = findViewById(R.id.gst_num);
        TextView qstView = findViewById(R.id.qst_num);
        TextView totalAfterTaxesView = findViewById(R.id.total_num);
        Intent intent = getIntent();
        double totalb4Taxes = 0;
        double gstNum;
        double qstNum;
        double totalAfterTaxes;
        String formatTotalB4Taxes;
        String formatTotalAfterTaxes;
        String formatGST;
        String formatQST;

        // get total before taxes
        for (int i = 0; i < intent.getIntExtra("LIST_SIZE", 0); i++) {
            totalb4Taxes += Double.parseDouble(intent.getStringExtra("SUBTOTAL" + i));
        }
        formatTotalB4Taxes = String.format("%.2f", totalb4Taxes);
        totalView.setText(formatTotalB4Taxes);

        // set GST
        gstNum = totalb4Taxes * GST;
        formatGST = String.format("%.2f", gstNum);
        gstView.setText(formatGST);

        // set QST
        qstNum = totalb4Taxes * QST;
        formatQST = String.format("%.2f", qstNum);
        qstView.setText(formatQST);

        // Set shipping cost
        shippingCost = findViewById(R.id.shipping_num);
        shippingCost.setText(intent.getStringExtra(MenuActivity.EXTRA_KEY));
        Log.d(TAG, shippingCost.getText().toString());

        // Calculate Total
        totalAfterTaxes = totalb4Taxes + gstNum + qstNum + Double.parseDouble(shippingCost.getText().toString());
        formatTotalAfterTaxes = String.format("%.2f", totalAfterTaxes);
        totalAfterTaxesView.setText(formatTotalAfterTaxes);
    }
}
