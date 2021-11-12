package com.example.evaluacion_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Juegos;

public class Home_act extends AppCompatActivity {
    private Juegos ju = new Juegos();
    private VideoView videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        videoview=findViewById(R.id.vw);
        //obtener la ruta
        String ruta= "android.resource://" + getPackageName() + "/"+ R.raw.video;
        Uri uri = Uri.parse(ruta);//parseo la ruta.

        videoview.setVideoURI(uri);

        videoview.start();

        //MediaController media= new MediaController(this);
       // videoview.setMediaController(media);
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
        Intent i = new Intent(getBaseContext(),MainActivity.class);
        startActivity(i);
    }
    public void Contacto(View view)
    {
        Intent i = new Intent(getBaseContext(), Contacto_act.class);
        startActivity(i);
    }
}