package com.example.mighty.airtelapp.admintask;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.mighty.airtelapp.R;
import com.example.mighty.airtelapp.data.DataContract.DataEntry;

public class DayPickCursorAdapter extends CursorAdapter {
    public DayPickCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_day_pick, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //Extract views to modify
        TextView orderNumberTextView = (TextView) view.findViewById(R.id.order_number);
        TextView recipientNumberTextView = (TextView) view.findViewById(R.id.recipient_number);
        TextView dataBundleNameTextView = (TextView) view.findViewById(R.id.data_bundle_name);
        TextView dataBundleValueTextView = (TextView) view.findViewById(R.id.data_bundle_value);
        TextView dataBundleCostTextView = (TextView) view.findViewById(R.id.data_bundle_cost);
        TextView spinnerRowTextView = (TextView) view.findViewById(R.id.resource_spinner);
        TextView timeReceivedTextView = (TextView) view.findViewById(R.id.time_received);
        TextView timeDoneTextView = (TextView) view.findViewById(R.id.time_done);
        TextView dateTextView = (TextView) view.findViewById(R.id.date);
        TextView shiftoperationTextView = (TextView) view.findViewById(R.id.shift_operation);

        int orderNumberColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_ORDER_NUMBER);
        int recipientColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_RECIPIENT_NUMBER);
        int dataBundleNameColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_DATA_BUNDLE_NAME);
        int dataBundleValueColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_DATA_BUNDLE_VALUE);
        int dataBundleCostColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_DATA_BUNDLE_COST);
        int spinnerRowColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_SPINNER_ROW);
        int timeReceivedColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_TIME_RECEIVED);
        int timeDoneColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_TIME_RECEIVED);
        int dateColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_DATE);
        int shiftOperationColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_SHIFT_OPERATION);

        String orderNumber = cursor.getString(orderNumberColumnIndex);
        String recipientNumber = cursor.getString(recipientColumnIndex);
        String dataBundleName = cursor.getString(dataBundleNameColumnIndex);
        String dataBundleValue = cursor.getString(dataBundleValueColumnIndex);
        String dataBundleCost = cursor.getString(dataBundleCostColumnIndex);
        String spinnerRow = cursor.getString(spinnerRowColumnIndex);
        String timeReceived = cursor.getString(timeReceivedColumnIndex);
        String timeDone = cursor.getString(timeDoneColumnIndex);
        String date = cursor.getString(dateColumnIndex);
        String shiftOperation = cursor.getString(shiftOperationColumnIndex);

        orderNumberTextView.setText(orderNumber);
        recipientNumberTextView.setText(recipientNumber);
        dataBundleNameTextView.setText(dataBundleName);
        dataBundleValueTextView.setText(dataBundleValue);
        dataBundleCostTextView.setText(dataBundleCost);
        spinnerRowTextView.setText(spinnerRow);
        timeReceivedTextView.setText(timeReceived);
        timeDoneTextView.setText(timeDone);
        dateTextView.setText(date);
        shiftoperationTextView.setText(shiftOperation);
    }
}
