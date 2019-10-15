package com.example.MadanayNicerShop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Author: Darrell-David Madanay
 * since 09/20/2019
 * Main Activity for shopping app
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Starts menu activity
     *
     * @param view View
     */
    public void startMenuActivity(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        Log.d(TAG, "Clicked on \"Start>\" button");
        startActivity(intent);
    }
}
