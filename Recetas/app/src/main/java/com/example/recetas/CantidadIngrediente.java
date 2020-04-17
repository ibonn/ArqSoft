package com.example.recetas;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

public class CantidadIngrediente {

    private Ingrediente ingrediente;    // El ingrediente
    private int cantidad;               // Cantidad
    private String unidad;              // Unidad si la hay (gramos, cucharadas, tazas...)

    public CantidadIngrediente(Ingrediente ingrediente, int cantidad) {
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
        this.unidad = null;
    }

    public CantidadIngrediente(Ingrediente ingrediente, int cantidad, String unidad) {
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public String toString() {
        if (this.unidad == null) {
            return String.format("%d ✕ $s", this.cantidad, this.ingrediente.getNombre());
        }
        else {
            return String.format("%d %s ✕ $s", this.cantidad, this.unidad, this.ingrediente.getNombre());
        }

    }
}
