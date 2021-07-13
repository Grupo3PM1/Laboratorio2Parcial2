package com.example.laboratorio1p2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.laboratorio1p2.tabla.Photograh;
import com.example.laboratorio1p2.ImageAdapter;
import com.example.laboratorio1p2.transacciones.Transacciones;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    SQLiteConexion conexion;

    RecyclerView recycler;

    ArrayList<Photograh> galeria;
    List<Photograh> items;
    ArrayList<String> ArregloFotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        galeria = new ArrayList<>();

        // Inicializar Imagenes
        GetListGallery();

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);

        // Usar un administrador para LinearLayout
        recycler.setLayoutManager(new LinearLayoutManager(this));

        // Crear un nuevo adaptador
        ImageAdapter adapter = new ImageAdapter(items);
        recycler.setAdapter(adapter);
    }


    private void GetListGallery() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        Photograh Items = null;
        galeria = new ArrayList<Photograh>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.tabla_fotos, null);

        while (cursor.moveToNext()) {
            Items = new Photograh();
            Items.setId(cursor.getInt(0));
            Items.setName(cursor.getString(1));
            Items.setHorafecha(cursor.getBlob(2));
            Items.setFormato(cursor.getString(3));
            Items.setSize(cursor.getBlob(4));
            Items.setImage(cursor.getBlob(5));
            Items.setDescripcion(cursor.getString(6));

            galeria.add(Items);
        }

        cursor.close();
        GalleryList();
    }

    private void GalleryList() {

        ArregloFotos = new ArrayList<String>();
        items = new ArrayList<>();

        for (int i = 0;  i < galeria.size(); i++){

            items.add(new Photograh(
                    galeria.get(i).getId(),
                    galeria.get(i).getName(),
                    galeria.get(i).getHorafecha(),
                    galeria.get(i).getFormato(),
                    galeria.get(i).getSize(),
                    galeria.get(i).getImage(),
                    galeria.get(i).getDescripcion()));
        }
    }
}