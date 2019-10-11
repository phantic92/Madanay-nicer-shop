package com.example.MadanayNicerShop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.MadanayNicerShop.Model.Product;

import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {
    private LinkedList<Product> mProductList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        // Create products
        mProductList.addLast(new Product(getString(R.string.barbell_title), getString(R.string.barbell_description),
                getString(R.string.barbell_price_tag), getString(R.string.barbell_quantity),
                R.drawable.olympic_barbell));
        mProductList.addLast(new Product(getString(R.string.eleiko_title), getString(R.string.eleiko_description),
                getString(R.string.eleiko_price_tag), getString(R.string.eleiko_quantity),
                R.drawable.eleiko_plates));
        mProductList.addLast(new Product(getString(R.string.squat_stand_title), getString(R.string.squat_rack_description),
                getString(R.string.squat_rack_price_tag), getString(R.string.squat_rack_quantity), R.drawable.squat_rack));
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
