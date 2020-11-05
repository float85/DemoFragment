package com.float85.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Button btnFragment01, btnFragment02, btnFragment03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragment01 = findViewById(R.id.btnFragment1);
        btnFragment02 = findViewById(R.id.btnFragment2);
        btnFragment03 = findViewById(R.id.btnFragment3);

        getFragment(OrderFragment.newInstance());

        btnFragment01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragment(OrderFragment.newInstance());
            }
        });

        btnFragment02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragment(SellFragment.newInstance());
            }
        });
    }

    public void getFragment(Fragment fragment) {
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentLayout, fragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "getFragment: " + e.getMessage());
        }
    }
}