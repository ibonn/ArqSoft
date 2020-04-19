package com.example.recetas;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class CantidadIngrediente implements Serializable {

    private Ingrediente ingrediente;    // El ingrediente
    protected int cantidad;               // Cantidad
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

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public String getCantidad() {
        if (this.unidad == null) {
            return String.format("%d", this.cantidad);
        }
        else {
            return String.format("%d %s", this.cantidad, this.unidad);
        }
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
