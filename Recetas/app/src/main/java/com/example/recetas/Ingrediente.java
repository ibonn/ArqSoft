package com.example.recetas;

import java.util.ArrayList;

public class Ingrediente {
    private String nombre;
    private boolean selected;

    private Ingrediente(String nombre) {
        this.nombre = nombre;
        this.selected = false;
    }

    public  static ArrayList<Ingrediente> getIngredientes() {
        // TODO Cargar los ingredientes desde el servidor
        ArrayList<Ingrediente> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(new Ingrediente("Ingrediente de prueba"));
        }
        return l;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}


