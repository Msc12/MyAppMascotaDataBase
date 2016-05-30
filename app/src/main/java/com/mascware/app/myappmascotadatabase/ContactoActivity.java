package com.mascware.app.myappmascotadatabase;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mascware.app.myappmascotadatabase.mail.SendMail;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactoActivity extends AppCompatActivity implements View.OnClickListener{
    TextInputEditText nombreContacto;
    TextInputEditText correoContacto;
    TextInputEditText mensajeContacto;
    Button botton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        nombreContacto= (TextInputEditText) findViewById(R.id.nameContacto);
        correoContacto= (TextInputEditText) findViewById(R.id.correoContacto);
        mensajeContacto= (TextInputEditText) findViewById(R.id.mensajeContacto);

        if(miActionBar!=null){
            setSupportActionBar(miActionBar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        botton = (Button) findViewById(R.id.buttonMail);
        botton.setOnClickListener(this);


    }

    private void sendEmail() {

        Toast.makeText(getBaseContext(), " Tu : " + nombreContacto.getText()  + " con mail : " + correoContacto.getText()
                        + " Enviaste el mensaje: " + mensajeContacto.getText()
                , Toast.LENGTH_LONG).show();
        //Creating SendMail object
        SendMail sm = new SendMail(this, correoContacto.getText().toString().trim(),
                nombreContacto.getText().toString().trim(), mensajeContacto.getText().toString().trim());


        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}
