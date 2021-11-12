package com.example.evaluacion_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Contacto_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }



    //intent implicito

    public void Marcado(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL); //accion para el marcado
        i.setData(Uri.parse("tel:"+"963166854"));//marcado.
        startActivity(i);//inicia marcado
    }
    public void Maps(View view)
    {
        Intent i = new Intent(this,MapsActivity.class);
        startActivity(i);
    }

}