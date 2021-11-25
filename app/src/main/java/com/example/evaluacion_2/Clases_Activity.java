package com.example.evaluacion_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evaluacion_2.database.AdminSQLiteOpenHelper;
import com.google.android.gms.common.internal.Objects;

public class Clases_Activity extends AppCompatActivity {

    private EditText code, name, adres;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        code = findViewById(R.id.code);
        name = findViewById(R.id.name);
        adres = findViewById(R.id.adres);
    }

    public void añadirDatos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"PSAPP", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();//permite la sobreescritura.

        String codigo = code.getText().toString();
        String nombre = name.getText().toString();
        String direccion = adres.getText().toString();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("codigo", codigo);
            cont.put("nombre", nombre);
            cont.put("direccion", direccion);

            db.insert("clases", null, cont);
            Clean();
            db.close();

            Toast.makeText(getBaseContext(),"Has guardado un local!", Toast.LENGTH_LONG).show();
        }

        else
        {
            Toast.makeText(getBaseContext(),"Debe completar los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarDatos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"PSAPP", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();//permite la sobreescritura.

        String codigo = code.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor file = db.rawQuery("SELECT nombre, direccion FROM clases WHERE codigo="+codigo, null);

            if (file.moveToFirst())
            {
                name.setText(file.getString(0));
                adres.setText(file.getString(1));
            }
            else
            {
                Toast.makeText(getBaseContext(), "No hay datos asociados", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(getBaseContext(), "El código no debe estar vacío", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarDatos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"PSAPP", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();//permite la sobreescritura.

        String codigo = code.getText().toString();

        if (!codigo.isEmpty())
        {
            db.delete("clases", "codigo="+codigo, null );
            db.close();
            Toast.makeText(getBaseContext(), "Has eliminado una dirección"+codigo, Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getBaseContext(), "El codigo no debe estar vacío", Toast.LENGTH_LONG).show();
        }

    }

    public void actualizarDatos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"PSAPP", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();//permite la sobreescritura.

        String codigo = code.getText().toString();
        String nombre = name.getText().toString();
        String direccion = adres.getText().toString();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("nombre", nombre);
            cont.put("direccion", direccion);

            db.update("clases", cont, "codigo="+codigo, null);
            db.close();
            Toast.makeText(getBaseContext(), "Has actualizado: "+codigo, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(), "Debe llenar los campos", Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para limpiar campos
    public void Clean()
    {
        code.setText("");
        name.setText("");
        adres.setText("");
    }
}