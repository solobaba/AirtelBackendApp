package com.example.mighty.airtelapp.data;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mighty.airtelapp.CreateUser;
import com.example.mighty.airtelapp.R;
import com.example.mighty.airtelapp.data.DataContract.DataEntry;

public class RequestHistory extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final int REQUEST_LOADER = 0;
    RequestCursorAdapter requestCursorAdapter;
    ListView listView;

    Toolbar mtoolbar;

    private Button buttonRemove;
    private EditText editTextRemove;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_activity);

        getSupportActionBar().setTitle("API_Request");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mtoolbar);
//        mtoolbar.setTitle("Request History");
//        mtoolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
//        mtoolbar.setOnClickListener (new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                backToMain();
//            }
//        });


        listView = (ListView) findViewById(R.id.recyclerView);
        int columnNumbers = 2;
        requestCursorAdapter = new RequestCursorAdapter(this, null, columnNumbers);
        listView.setAdapter(requestCursorAdapter);
        getLoaderManager().initLoader(REQUEST_LOADER, null, this);

        editTextRemove = findViewById(R.id.edittext_remove);
        buttonRemove = findViewById(R.id.button_remove);
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });

//        GridView listView = (GridView) findViewById(R.id.request_list);
//        int columnNumbers = 2;
//        requestCursorAdapter = new RequestCursorAdapter(this, null, columnNumbers);
//        listView.setAdapter(requestCursorAdapter);
//        getLoaderManager().initLoader(REQUEST_LOADER, null, this);
    }

    public void removeItem(int position){
    }

//    private void backToMain() {
//        startActivity(new Intent(this, CreateUser.class));
//    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        //Define a projection to show relevant columns
        String[] projection = {
                DataEntry._ID,
                DataEntry.COLUMN_ORDER_NUMBER,
                DataEntry.COLUMN_RECIPIENT_NUMBER,
                DataEntry.COLUMN_DATA_BUNDLE_NAME,
                DataEntry.COLUMN_DATA_BUNDLE_VALUE,
                DataEntry.COLUMN_DATA_BUNDLE_COST,
                DataEntry.COLUMN_SPINNER_ROW,
                DataEntry.COLUMN_TIME_RECEIVED,
                DataEntry.COLUMN_STATUS,
                DataEntry.COLUMN_TIME_DONE
        };
        return new CursorLoader(this,
                DataEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        requestCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        requestCursorAdapter.swapCursor(null);
    }
}
