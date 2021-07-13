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

        viewHolder.imagen.setImageResource(items.get(i).getImage());
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
            imagen = (ImageView) v.findViewById(R.id.imagen);
            descripcion = (TextView) v.findViewById(R.id.descripcion);
        }
    }






}
