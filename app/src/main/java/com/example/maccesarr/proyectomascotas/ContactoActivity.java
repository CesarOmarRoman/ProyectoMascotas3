package com.example.maccesarr.proyectomascotas;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

public class ContactoActivity extends AppCompatActivity {

    EditText nombre, correo, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar_DETALLE);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText)findViewById(R.id.editTextNombre_Contacto);
        correo = (EditText)findViewById(R.id.editTextEmail_Contacto);
        mensaje = (EditText)findViewById(R.id.editTextMensaje_Contacto);

    }

    public void EnviarInformación (View view){
        String mensajeNombre = nombre.getText().toString();
        String mensajeMensaje = mensaje.getText().toString();
        String miCorreo = correo.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{miCorreo});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, mensajeNombre);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensajeMensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }



}

