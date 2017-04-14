package com.example.rodryvazquez.backupdata;

import android.app.backup.BackupHelper;
import android.app.backup.BackupManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rodryvazquez.backupdata.Helpers.BackupCloudHelper;

/**
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private BackupManager backupManager;
    private EditText enterData;
    private TextView showData;
    private Button save, show;

    private static final String TAG = "MainActivity";

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backupManager = new BackupManager(this);
        showData = (TextView)findViewById(R.id.load_data);
        enterData = (EditText)findViewById(R.id.enter_data);
        save = (Button) findViewById(R.id.save);
        show = (Button) findViewById(R.id.show);
        save.setOnClickListener(this);
        show.setOnClickListener(this);
        show.setEnabled(false);

        sharedPreferences = getSharedPreferences(BackupCloudHelper.PREFS_TEST, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        //Si existen datos al cargar la actividad mostramos el boton 'Show'
        if(showData().length()> 0){
            show.setEnabled(true);
        }
    }

    /**
     * Eventos Save y Show data
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:
                saveData("save",enterData.getText().toString());
                show.setEnabled(true);
                break;
            case R.id.show:
                showData.setText(showData());
                break;
        }
    }

    /**
     * Guardamos los valores
     * @param key
     * @param value
     */
    private void saveData(String key, String value){
        editor.putString(key,value);
        editor.commit();
        Log.d(TAG,"Calling backup");
        //Notificamos al backupManager que los datos han cambiado
        //este cambio no es instantaneo se programara la operacion de guardado
        backupManager.dataChanged();
    }

    /**
     * Retornamos los datos previamente guardados
     * @return
     */
    private String showData(){
        String savedData = sharedPreferences.getString("save","");
        return savedData;
    }
}
