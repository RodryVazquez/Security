package com.example.rodryvazquez.usingsharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enterData, loadData;
    private Button save, show;

    private static final String PREF_NAME = "save";
    static final int PRIVATE = MODE_PRIVATE;
    // TO DO deprecated
    static final int READABLE = MODE_WORLD_READABLE;
    static final int WRITEABLE = MODE_WORLD_WRITEABLE;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData = (EditText) findViewById(R.id.edtLoadData);
        enterData = (EditText)findViewById(R.id.edtEnterData);
        save = (Button)findViewById(R.id.btnSave);
        show = (Button)findViewById(R.id.btnShow);
        save.setOnClickListener(this);
        show.setOnClickListener(this);
        show.setEnabled(false);
    }

    /**
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                if(enterData.getText().toString().length() > 0) {
                    SavePreferences(PREF_NAME, enterData.getText().toString());
                    show.setEnabled(true);
                } else
                    Toast.makeText(this, R.string.message_enter_data, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnShow:
                loadData.setText(LoadPreferences());
                break;
        }
    }

    /**
     * Guarda la preferencia
     * @param key
     * @param value
     */
    private void SavePreferences(String key, String  value){
        SharedPreferences preferences = getPreferences(PRIVATE);
        SharedPreferences.Editor editor =
                            preferences.edit();

        editor.putString(key,value);
        editor.commit();
    }

    /**
     * Retorna el valor de la preferencia
     * @return
     */
    private String LoadPreferences(){
        SharedPreferences preferences = getPreferences(PRIVATE);
        return preferences.getString(PREF_NAME,"");
    }
}
