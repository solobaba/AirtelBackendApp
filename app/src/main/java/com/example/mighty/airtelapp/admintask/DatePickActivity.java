package com.example.mighty.airtelapp.admintask;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.example.mighty.airtelapp.R;

import java.util.Calendar;

public class DatePickActivity extends AppCompatActivity {

    private AppCompatTextView textViewSelectedDate;
    AppCompatTextView textViewResult;

    DatePickerDialog datePickerDialog;
    String DATE_PICKER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        getSupportActionBar().setTitle("Date Picker");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewSelectedDate = (AppCompatTextView) findViewById(R.id.date_selected);
        textViewResult = (AppCompatTextView) findViewById(R.id.text_view_result);

        calendarDialog();

        textViewResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatePickActivity.this, DayPickActivity.class);
                intent.putExtra("Date selected", DATE_PICKER);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void calendarDialog(){
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        datePickerDialog = new DatePickerDialog(DatePickActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                Log.i("datePicker", dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                String DATE_PICKER = (dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                textViewSelectedDate.setText(DATE_PICKER);
            }
        }, year, month, day);
        try {
            datePickerDialog.show();
        }catch (Exception e){
            datePickerDialog.dismiss();
        }
    }
}
