package com.example.MadanayNicerShop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.MadanayNicerShop.Model.Product;

import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {
    private LinkedList<Product> mProductList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new ProductAdapter(mProductList, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create products
        mProductList.addLast(new Product(getString(R.string.barbell_title), getString(R.string.barbell_description),
                getString(R.string.barbell_price_tag), getString(R.string.barbell_quantity), getString(R.string.barbell_subtotal),
                R.drawable.olympic_barbell));
        mProductList.addLast(new Product(getString(R.string.eleiko_title), getString(R.string.eleiko_description),
                getString(R.string.eleiko_price_tag), getString(R.string.eleiko_quantity), getString(R.string.plates_subtotal),
                R.drawable.eleiko_plates));
        mProductList.addLast(new Product(getString(R.string.squat_stand_title), getString(R.string.squat_rack_description),
                getString(R.string.squat_rack_price_tag), getString(R.string.squat_rack_quantity), getString(R.string.squat_stand_subtotal),  R.drawable.squat_rack));
        mProductList.addLast(new Product(getString(R.string.bench_title),
                getString(R.string.bench_description), getString(R.string.bench_price), getString(R.string.bench_subtotal),
                getString(R.string.bench_quantity), R.drawable.bench));
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

        // Floating button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
