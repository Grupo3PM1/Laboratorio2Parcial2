package com.example.laboratorio1p2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio1p2.tabla.Photograh;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private List<Photograh> items;

    public ImageAdapter(List<Photograh> items) {
        this.items = items;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.image_card, viewGroup, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder viewHolder, int i) {
        viewHolder.id.setText(items.get(i).getId());

        /*viewHolder.nombre.setText(items.get(i).getName());
        viewHolder.fecha.setText("Fecha: "+String.valueOf(items.get(i).getHorafecha()));
        viewHolder.formato.setText("Formato: "+String.valueOf(items.get(i).getFormato()));
        viewHolder.bytes.setText("Tamaño: "+String.valueOf(items.get(i).getSize()));
        viewHolder.imagen.setImageResource(items.get(i).getId());*/
        viewHolder.descripcion.setText("Descripcion: "+String.valueOf(items.get(i).getDescripcion()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView id, nombre, fecha, formato, bytes, descripcion;

        public ImageViewHolder(View v) {
            super(v);
            id = (TextView) v.findViewById(R.id.id);
            /*nombre = (TextView) v.findViewById(R.id.nombre);
            fecha = (TextView) v.findViewById(R.id.fecha);
            formato = (TextView) v.findViewById(R.id.formato);
            bytes = (TextView) v.findViewById(R.id.bytes);
            imagen = (ImageView) v.findViewById(R.id.imagen);*/
            descripcion = (TextView) v.findViewById(R.id.descripcion);
        }
    }






}
