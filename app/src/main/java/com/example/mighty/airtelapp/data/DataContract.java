package com.example.mighty.airtelapp.data;

import android.net.Uri;
import android.provider.BaseColumns;
import android.view.View;

public class DataContract {

    public static final String CONTENT_AUTHORITY = "com.example.mighty.airtelapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_LOG = "log_path";
    public static final String PATH_OPERATION = "operation_path";
    public static final String PATH_DAILY_OPERATION = "daily_operation_path";

    private DataContract(){
    }

    public static final class DataEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_LOG);

        // Table and column names
        public final static String TABLE_NAME = "rightdata";
        public final static String COLUMN_NAME_ID = BaseColumns._ID;
        public final static String COLUMN_ORDER_NUMBER = "ordId";
        public final static String COLUMN_RECIPIENT_NUMBER = "recNum";
        public final static String COLUMN_DATA_BUNDLE_NAME = "dataName";
        public final static String COLUMN_DATA_BUNDLE_VALUE = "dataValue";
        public final static String COLUMN_DATA_BUNDLE_COST = "dataCost";
        public final static String COLUMN_SPINNER_ROW = "spinRow";
        public final static String COLUMN_TIME_RECEIVED = "timeReceived";
        public final static String COLUMN_STATUS = "status";
        public final static String COLUMN_TIME_DONE = "timeDone";
        public final static String COLUMN_DATE = "date";
        public final static String COLUMN_SHIFT_OPERATION = "shiftOperation";

        //Request source
        public static final String REQUEST_SOURCE_UNKNOWN = "Unknown";
        public static final String REQUEST_SOURCE_AIRTIME = "Airtime";
        public static final String REQUEST_SOURCE_CASH = "Cash";
        public static final String REQUEST_SOURCE_AGENT = "Agent";
        public static final String REQUEST_SOURCE_SALES_REP = "Sales Rep";
        public static final String REQUEST_SOURCE_WEB = "Web";
        public static final String REQUEST_SOURCE_API = "API";

        //Data Bundle Value
        public static final String REQUEST_VALUE_UNKNOWN = "Unknown";
        public static final String ONE_FIVE_GB = "1.5gb";
        public static final String THREE_FIVE_GB = "3.5gb";
        public static final String FIVE_GB = "5gb";

        //Data Cost price
        public static final String BUNDLE_VALUE_UNKNOWN = "Unknown";
        public static final String ONE_FIVE_GB_PRICE = "#1000";
        public static final String THREE_FIVE_GB_PRICE = "#3000";
        public static final String FIVE_GB_PRICE = "#4500";

        //Airtel data codes
        public static final String ONE_FIVE_GB_CODE = "141**5*2*1*5*1";
        public static final String THREE_FIVE_GB_CODE = "141**5*2*1*4*1";
        public static final String FIVE_GB_CODE = "141**5*2*1*3*1";

        //Shift operation
        public static final int DAY_SHIFT = 1;
        public static final int NIGHT_SHIFT = 2;

        //Daily operation report
        public static final int DAILY_OPERATION = 3;
        public static final int DAILY_DATE_PICKER_OPERATION = 4;

        public static boolean isoperationShift(int shift){
            return shift == DAY_SHIFT || shift == NIGHT_SHIFT;
        }
    }
}