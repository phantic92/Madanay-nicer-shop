package com.example.MadanayNicerShop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.MadanayNicerShop.Model.Product;
import java.util.LinkedList;

/**
 * @Author: Darrell-Davidd Madanay
 * @since 14/10/2019
 * This is menu activity. It contains the title, description, quantity, price, subtoal and
 * image of the items.
 */
public class MenuActivity extends AppCompatActivity {
    private static final String EXPRESS_SHIP = "50.00";
    private static final String REGULAR_SHIP = "10.00";
    private static final String NO_HURRY_SHIP = "0.00";
    public static final String EXTRA_KEY = "shipping cost";
    private static final String TAG = MenuActivity.class.getSimpleName();
    private LinkedList<Product> mProductList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;
    private boolean mStartActivityFlag;

    /**
     * This creates the list of products and sets the product adapter to the recyclerview. It
     * also contains the onClickListener for the FAB.
     * @param savedInstanceState saved instance state when activity is destroyed
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new ProductAdapter(mProductList, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        String restoreQuantity;
        String restoreSubtotal;

        // Create products
        mProductList.addLast(new Product(getString(R.string.barbell_title), getString(R.string.barbell_description),
                getString(R.string.barbell_price_tag), getString(R.string.barbell_quantity), getString(R.string.barbell_subtotal),
                R.drawable.olympic_barbell));
        mProductList.addLast(new Product(getString(R.string.eleiko_title), getString(R.string.eleiko_description),
                getString(R.string.eleiko_price_tag), getString(R.string.eleiko_quantity), getString(R.string.plates_subtotal),
                R.drawable.eleiko_plates));
        mProductList.addLast(new Product(getString(R.string.squat_stand_title), getString(R.string.squat_rack_description),
                getString(R.string.squat_rack_price_tag), getString(R.string.squat_rack_quantity), getString(R.string.squat_stand_subtotal), R.drawable.squat_rack));
        mProductList.addLast(new Product(getString(R.string.bench_title),
                getString(R.string.bench_description), getString(R.string.bench_price), getString(R.string.bench_quantity),
                getString(R.string.bench_subtotal), R.drawable.bench));
        mProductList.addLast(new Product(getString(R.string.lifting_shoes_title),
                getString(R.string.lifting_shoes_description), getString(R.string.lifting_shoes_price),
                getString(R.string.lifting_shoes_quantity), getString(R.string.squat_shoes_subtotal), R.drawable.squat_shoes));
        mProductList.addLast(new Product(getString(R.string.belt_title), getString(R.string.belt_description),
                getString(R.string.belt_price), getString(R.string.belt_quantity), getString(R.string.belt_subtotal), R.drawable.lifting_belt));
        mProductList.addLast(new Product("Lifting Straps", "Lifting Straps", "20.99",
                "0", getString(R.string.straps_subtotal), R.drawable.lifting_straps));
        mProductList.addLast(new Product("Chalk Block", "Lifting chalk", "16.31",
                "0", getString(R.string.chalk_subtotal), R.drawable.chalk_block));
        mProductList.addLast(new Product(getString(R.string.pullup_bar_title),
                getString(R.string.pullup_bar_description), getString(R.string.pullup_bar_price),
                getString(R.string.pullup_bar_quantity), getString(R.string.pullup_subtotal), R.drawable.pullup_bar));
        mProductList.addLast(new Product(getString(R.string.bands_title), getString(R.string.bands_description),
                getString(R.string.bands_price), getString(R.string.bands_quantity),
                getString(R.string.bands_subtotal), R.drawable.resistance_bands));

        // Restore saved instance state
        if (savedInstanceState != null) {
            for (int i = 0; i < mProductList.size(); i++) {
                restoreQuantity = savedInstanceState.getString("quantity" + i);
                restoreSubtotal = savedInstanceState.getString("subtotal" + i);
                mProductList.get(i).setQuantity(restoreQuantity);
                mProductList.get(i).setSubtotal(restoreSubtotal);
                Log.d(TAG, "Quantity=" + restoreQuantity + " Subtotal=" + restoreSubtotal);
            }
        }

        // Floating button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] SHIPPING_OPTIONS = {"Express - $" + EXPRESS_SHIP,
                        "Regular - $" + REGULAR_SHIP, "No hurry - $" + NO_HURRY_SHIP};
                AlertDialog.Builder shippingAlert = new AlertDialog.Builder(MenuActivity.this);
                final Intent intent = new Intent(MenuActivity.this, CheckoutActivity.class);

                // Set the dialog title and message
                shippingAlert.setTitle("Shipping Options");

                // put size of product list into extra
                intent.putExtra("LIST_SIZE", mProductList.size());
                // Put data in extra
                for (int i = 0; i < mProductList.size(); i++) {
                    intent.putExtra("SUBTOTAL" + i, mProductList.get(i).getSubtotal());
                }

                // Add radio buttons for shipping options
                shippingAlert.setSingleChoiceItems(SHIPPING_OPTIONS, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch (i) {
                                    case 0:
                                        intent.putExtra(EXTRA_KEY, EXPRESS_SHIP);
                                        break;
                                    case 1:
                                        intent.putExtra(EXTRA_KEY, REGULAR_SHIP);
                                        break;
                                    case 2:
                                        intent.putExtra(EXTRA_KEY, NO_HURRY_SHIP);
                                }
                                mStartActivityFlag = true;
                            }
                        });

                // Set dialog buttons
                shippingAlert.setPositiveButton(R.string.checkout_alert_text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (mStartActivityFlag)
                            startActivity(intent);
                        else
                            Toast.makeText(getApplicationContext(),
                                    "Please Choose Delivery Method!", Toast.LENGTH_LONG).show();
                    }
                });
                shippingAlert.setNegativeButton(R.string.cancel_alert_text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                // Display alert dialog
                shippingAlert.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.language:
                Toast.makeText(getApplicationContext(), "You Clicked on Language", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.theme:
                Toast.makeText(getApplicationContext(), "You Clicked on Theme", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sign_up:
                Toast.makeText(getApplicationContext(), "You CLicked on Sign up", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "You Clicked on Account Settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.location:
                Toast.makeText(getApplicationContext(), "You Clicked on Location", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sign_in:
                Toast.makeText(getApplicationContext(), "You clicked on Sign in", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Saves the quantity and the subtotal of each product to be restored when the device is
     * rotated.
     * @param outState Bundle of instance state
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save quantities and subtotals for each product
        for (int i = 0; i < mProductList.size(); i++) {
            outState.putString("quantity" + i, mProductList.get(i).getQuantity());
            outState.putString("subtotal" + i, mProductList.get(i).getSubtotal());
        }
    }
}
