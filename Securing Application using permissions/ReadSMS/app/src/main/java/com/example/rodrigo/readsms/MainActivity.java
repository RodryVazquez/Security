package com.example.rodrigo.readsms;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class SmsColumns{
        public static final String ID = "_id";
        public static final String ADDRESS = "address";
        public static final String DATE = "date";
        public static final String BODY = "body";
    }

    private class SmaCursorAdapter{
    }
}


