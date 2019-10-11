package com.example.MadanayNicerShop;

import android.app.Activity;

/**
 * Author: Darrell-David Madanay
 * since 09/20/2019
 * Checkout Activity for shopping app
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CheckoutActivity extends AppCompatActivity {
    private static final String TAG = "checkoutActivity";
    private static final double GST = 0.05;
    private static final double QST = 0.09975;

    /**
     * onCreate method that updates the total before taxes, the gst, the qst and the total after
     * taxes
     * @param savedInstanceState saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Intent intent = getIntent();
    }
}
