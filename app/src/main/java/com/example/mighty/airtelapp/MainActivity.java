package com.example.mighty.airtelapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mighty.airtelapp.data.DataDbHelper;

public class MainActivity extends AppCompatActivity {

    //Database helper that will provide access to the database
    private DataDbHelper mDbHelper;

    Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mtoolbar);
//        mtoolbar.setTitle("Request History");
////        mtoolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
//        mtoolbar.setOnClickListener (new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                backToMain();
//            }
//        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateUser.class);
                startActivity(intent);
            }
        });

        //To access our database, we instantiate our subclass of SQLiteOpener
        //and pass the context, which is the current activity
        mDbHelper = new DataDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
