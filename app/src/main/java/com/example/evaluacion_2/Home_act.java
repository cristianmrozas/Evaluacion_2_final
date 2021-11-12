package com.example.evaluacion_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import Objetos.Juegos;

public class Home_act extends AppCompatActivity {
    private Juegos ju = new Juegos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void juegos(View view)
    {
        Intent i = new Intent(getBaseContext(), Juegos_act.class);
        Bundle bun = new Bundle();//necesario para enviar arreglos.
        bun.putStringArray("Juegos", ju.getJuegos());
        i.putExtras(bun);
        startActivity(i);
    }

    public void salir(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}