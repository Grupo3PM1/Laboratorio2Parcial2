package com.example.laboratorio1p2.tabla;

import android.graphics.Bitmap;

public class Photograh {

    private Integer id;
    private Integer image;
    private String name;
    private String formato;
    private String descripcion;
    private byte[] size;
    private byte[] horafecha;


    public  Photograh(){}

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Photograh (Integer image, String descripcion) {

        this.image = image;
        this.descripcion = descripcion;

    }
    /*
    public Photograh (Integer id, String name, byte[] horafecha, String formato, byte[] size, byte[] image, String descripcion) {
        this.id = id;
        this.name = name;
        this.horafecha = horafecha;
        this.formato = formato;
        this.size = size;
        this.image = image;
        this.descripcion = descripcion;

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getSize() {
        return size;
    }

    public void setSize(byte[] size) {
        this.size = size;
    }

    public byte[] getHorafecha() {
        return horafecha;
    }

    public void setHorafecha(byte[] horafecha) {
        this.horafecha = horafecha;
    }

     */

}
