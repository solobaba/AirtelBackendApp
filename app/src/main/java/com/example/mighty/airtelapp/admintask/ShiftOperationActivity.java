package com.example.mighty.airtelapp.admintask;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.widget.ListView;

import com.example.mighty.airtelapp.CreateUser;
import com.example.mighty.airtelapp.R;
import com.example.mighty.airtelapp.data.DataContract.DataEntry;

import java.text.DecimalFormat;

public class ShiftOperationActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private AppCompatTextView textViewTotalSales;
    Double totalPrice;
    private static final int SHIFT_LOADER = 100;
    ShiftCursorAdapter shiftCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift_operation);

        getSupportActionBar().setTitle("Shift Operation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewTotalSales = (AppCompatTextView) findViewById(R.id.text_view_total_sales);
        ListView listView = (ListView)findViewById(R.id.daily_pick_list_shift);
        shiftCursorAdapter = new ShiftCursorAdapter(this, null);
        listView.setAdapter(shiftCursorAdapter);
        getLoaderManager().initLoader(SHIFT_LOADER, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        //Check if time is > 19, then it is day shift else night shift
        if (CreateUser.mTime < CreateUser.tm){
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
                    DataEntry.COLUMN_TIME_DONE,
                    DataEntry.COLUMN_DATE,
                    DataEntry.COLUMN_SHIFT_OPERATION
            };

            //Shift for current date
            String selection = DataEntry.COLUMN_SHIFT_OPERATION + "=?" + " AND " + DataEntry.COLUMN_DATE + "=?";
            String[] selctionArgs = new String[]{
                    "1", CreateUser.date
            };

            //This loader will execute the ContentProvider's query methid on the background
            return new CursorLoader(this,
                    DataEntry.CONTENT_URI,
                    projection,
                    selection,
                    selctionArgs,
                    null);
        } else {
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
                    DataEntry.COLUMN_TIME_DONE,
                    DataEntry.COLUMN_DATE,
                    DataEntry.COLUMN_SHIFT_OPERATION
            };

            //Shift for current date
            String selection = DataEntry.COLUMN_SHIFT_OPERATION + "=?" + " AND " + DataEntry.COLUMN_DATE + "=?";
            String[] selctionArgs = new String[]{
                    "2", CreateUser.date
            };

            //This loader will execute the ContentProvider's query methid on the background
            return new CursorLoader(this,
                    DataEntry.CONTENT_URI,
                    projection,
                    selection,
                    selctionArgs,
                    null);
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        shiftCursorAdapter.swapCursor(data);
        grandTotal(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        shiftCursorAdapter.swapCursor(null);
    }

    //Grand total method
    private double grandTotal(Cursor cursor){
        totalPrice = 0.00;
        for (int i = 0; i < cursor.getCount(); i++){
            int price = cursor.getColumnIndex(DataEntry.COLUMN_DATA_BUNDLE_COST);
            cursor.moveToPosition(i);
            Double m_Amount = cursor.getDouble(price);
            totalPrice += m_Amount;
        }

        Log.i("ShiftTotal :", String.valueOf(totalPrice));
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        textViewTotalSales.setText("N " + decimalFormat.format(totalPrice));
        Log.i("total price", "N" + decimalFormat.format(totalPrice));
        return totalPrice;
    }
}
