package com.example.rodrigo.applicationtwo;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rodrigo.applicationtwo.Helpers.ApplicationConstants;

public class MainActivity extends AppCompatActivity {

    //Referenciamos los elementos de la vista
    private Button btnTest;
    private TextView txtMessage;
    int error = 0;
    private static final int requestCode_Intent = 3;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTest = (Button)findViewById(R.id.btnTest);
        txtMessage = (TextView) findViewById(R.id.txtMessage);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declaramos el intent para llamar ala ApplicationOne
                Intent intent = new Intent();
                intent.setAction(ApplicationConstants.ACTION);
                intent.addCategory(ApplicationConstants.CATEGORY);
                try {
                    startActivityForResult(intent,requestCode_Intent);
                }
                catch (Exception ex){
                    txtMessage.append("\n"+ex.getMessage()+"\n");
                    Toast.makeText(MainActivity.this,R.string.error_message_permission,Toast.LENGTH_SHORT).show();
                    error = 1;
                }
            }
        });
    }

    /**
     * Verificamos el requestCode, si fue exitoso mostramos un mensaje si no manejamos el error
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == requestCode_Intent && error == 0){
            txtMessage.append(getString(R.string.open_application_activity_message));
            Toast.makeText(this, R.string.open_application_message,Toast.LENGTH_SHORT).show();
            error = 0;
        }else{
            /* Manejamos la excepcion o error*/
        }
    }
}
