package com.example.recetas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.Serializable;
import java.util.ArrayList;

public class Ingrediente implements Serializable {

    private String nombre;
    private byte[] imagen;
    private boolean selected;

    public Ingrediente(String nombre, byte[] imagen) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.selected = false;
    }

    public  static ArrayList<Ingrediente> getIngredientes() {
        // TODO Cargar los ingredientes desde el servidor
        ArrayList<Ingrediente> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(new Ingrediente("Ingrediente de prueba", null));
        }
        return l;
    }

    public String getNombre() {
        return nombre;
    }

    public Bitmap getImagen() {
        return BitmapFactory.decodeByteArray(imagen, 0, imagen.length);
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}


