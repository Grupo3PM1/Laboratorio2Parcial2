package com.example.laboratorio1p2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.laboratorio1p2.tabla.Photograh;
import com.example.laboratorio1p2.transacciones.Transacciones;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    SQLiteConexion conexion;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    ArrayList<Photograh> galeria;
    List<Photograh> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        // Inicializar Animes
        GalleryList();

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new ImageAdapter(items);
        recycler.setAdapter(adapter);
    }

    private void ObtenerListaPersonas() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Photograh Items = null;
        galeria = new ArrayList<Photograh>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.tabla_fotos, null);

        while (cursor.moveToNext()){
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