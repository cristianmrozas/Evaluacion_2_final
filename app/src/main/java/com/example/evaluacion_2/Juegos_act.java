package com.example.evaluacion_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Juegos;

public class Juegos_act extends AppCompatActivity {
    private Spinner juegos;
    private TextView texto;
    private RatingBar calificar;
    Juegos jue = new Juegos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        juegos= findViewById(R.id.spn_juegos);
        texto= findViewById(R.id.texto1);
        calificar= findViewById(R.id.rt);

        Bundle bun = getIntent().getExtras();

        String[] listado=bun.getStringArray("Juegos");

        ArrayAdapter adaptJuegos= new ArrayAdapter(this, android.R.layout.simple_list_item_1,listado);
        juegos.setAdapter(adaptJuegos);

    }
//calcular valor juegos
    public void Calcular(View view)
    {

        String Opcion = juegos.getSelectedItem().toString();
        int resultado=0;
        for (int i = 0; i<Opcion.length(); i++) {
            if (Opcion.equals(jue.getJuegos()[i]))//regunto por la seleccion
            {
                //resultado = jue.getPrecios()[i];
                resultado= jue.añadirAdicional(jue.getPrecios()[i] ,350);
                calificar.setRating(i);
                texto.setText("El juego que haz escogido es  " + Opcion+" y el valor en las tiendas es: "+ resultado);
                break;
            }
        }
    }

}