package com.example.rodrigo.applicationtwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnTest;
    private TextView txtMessage;
    int error = 0;
    private static final int requestCode_Intent = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTest = (Button)findViewById(R.id.btnTest);
        txtMessage = (TextView) findViewById(R.id.txtMessage);

    }
}
