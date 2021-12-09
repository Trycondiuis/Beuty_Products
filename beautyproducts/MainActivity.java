package com.example.beautyproducts;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets contents of the main activity layout
        setContentView(R.layout.activity_main);
        //initialize the tool bar in main activity
        Toolbar tb = findViewById(R.id.toolbar);
        tb.setTitleTextColor(Color.LTGRAY);
        setSupportActionBar(tb);
    }
}