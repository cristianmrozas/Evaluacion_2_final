package com.example.evaluacion_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

import Objetos.Juegos;
import Objetos.Usuarios;

public class MainActivity extends AppCompatActivity {
    private EditText user,pass;
    private TextView msj;
    private Usuarios us = new Usuarios();
    private Button btn;
    private ProgressBar barra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.uss);
        pass=findViewById(R.id.pass);
        msj=findViewById(R.id.msj);
        msj.setVisibility(View.INVISIBLE);
        btn=findViewById(R.id.btn);
        barra= findViewById(R.id.pb);

        barra.setVisibility(View.INVISIBLE);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //correr mi tarea asincrona...
            new Task().execute();

            }
        });



    }
    //tarea asincrona
    class Task extends AsyncTask<String, Void,String>
    {
        //define la configuracion inicial de mi tarea

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                for(int i=0; i<=10; i++){
                    Thread.sleep(400);//dormimos el proceso.....
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            return null;
        }
        //finaliza nuestra tarea asincrona
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            barra.setVisibility(View.INVISIBLE);
            String UsuarioUno= user.getText().toString().trim();
            String contraseña=pass.getText().toString().trim();

            String UserObj=us.getUsuario().trim();
            String passObj=us.getPass().trim();
            String UserObj1=us.getUsuario1().trim();
            String passObj1=us.getPass2().trim();

            switch (UsuarioUno) {
                case "Rodrigo":
                    if (UsuarioUno.equals(UserObj) && contraseña.equals(passObj)) {
                        user.setText("");
                        pass.setText("");
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i);

                    }
                    break;
                case "Cristian":
                    if (UsuarioUno.equals(UserObj1) && contraseña.equals(passObj1)) {
                        user.setText("");
                        pass.setText("");
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i);
                    }
                    break;

                case "":
                    if (UsuarioUno.equals("") && contraseña.isEmpty()) {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos vacios, favor intenta nuevamente.");
                    }
                    break;
                default:
                    if (!UsuarioUno.equals(UserObj) && !contraseña.equals(passObj)) {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos erroneos, favor intenta nuevamente.");
                    }
                    break;

            }
        }

    }

    public void youtube(View view)
    {
        Intent i= new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/user/LatamPlayStation"));
        startActivity(i);

    }
    public void facebook(View view)
    {
        Intent i= new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/Latam.PlayStation/"));
        startActivity(i);
    }
    public void Twitter(View view)
    {
        Intent i= new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://twitter.com/PlayStation_LA?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"));
        startActivity(i);
    }
    
}