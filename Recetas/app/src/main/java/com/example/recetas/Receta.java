package com.example.recetas;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Receta implements Serializable {

    private String id;                              // Identificador de la receta
    private String nombre;                          // Nombre de la receta
    private byte[] imagen;                          // Imagen de la receta
    private int duracionMinutos;                    // Tiempo de preparación en minutos
    private int numeroPersonas;                     // Número de personas
    private List<CantidadIngrediente> ingredientes; // Lista de ingredientes con sus cantidades
private String pasosReceta;                         // Texto de la receta

    public Receta(String id) {
        // TODO cargar receta de la base de datos
        this.id = id;
        this.nombre = "Receta de prueba";
        Bitmap.Config conf = Bitmap.Config.ARGB_8888;
        Bitmap bmp = Bitmap.createBitmap(200, 200, conf);
        Canvas canvas = new Canvas(bmp);
        canvas.drawColor(Color.RED);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(100,100, 100, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(20);
        canvas.drawText("Imagen\nreceta", 10, 100, paint);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        this.imagen = stream.toByteArray();
        Random r = new Random();
        this.duracionMinutos = r.nextInt(120) + 10;
        this.numeroPersonas = r.nextInt(3) + 1;
        this.ingredientes = new ArrayList<>();
        int numIngredientes = r.nextInt(10) + 5;
        for (int i = 0; i < numIngredientes; i++) {
            this.ingredientes.add(new CantidadIngrediente(new Ingrediente("Ingrediente de prueba " + i, null), numIngredientes - i, "gramos"));
        }
        this.pasosReceta = "Pasos para preparar una deliciosa receta de prueba";
    }

    private Receta(Receta r) {
        this.id = r.id;
        this.nombre = r.nombre;
        this.imagen = r.imagen;
        this.duracionMinutos = r.duracionMinutos;
        this.numeroPersonas = r.numeroPersonas;
        this.ingredientes = r.ingredientes;
        this.pasosReceta = r.pasosReceta;
    }

    /**
     * Devuelve el nombre de la receta
     * @return Cadena de texto con el nombre de la receta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la foto de la receta
     * @return Bitmap
     */
    public Bitmap getImagen() {
        return BitmapFactory.decodeByteArray(imagen, 0, imagen.length);
    }

    /**
     * Devuelve el número de personas para las que es la receta
     * @return String
     */
    public String getNumeroPersonas() {
        if (numeroPersonas == 1) {
            return "1 persona";
        }
        else {
            return String.format("%d personas", numeroPersonas);
        }
    }

    /**
     * Obtiene la lista de ingredientes con sus cantidades
     * @return Lista de CantidadIngrediente
     */
    public List<CantidadIngrediente> getIngredientes() {
        return ingredientes;
    }

    /**
     * Devuelve el texto de la receta
     * @return String con los pasos a seguir
     */
    public String getPasosReceta() {
        return pasosReceta;
    }

    /**
     * Devuelve un string con el tiempo de preparación en minutos u horas, depende de que sea más
     * conveniente
     * @return String con el tiempo de preparación
     */
    public String getTiempoPreparacion() {
        int horas = duracionMinutos / 60;
        int minutos = duracionMinutos % 60;

        if (horas == 0) {
            return duracionMinutos + " minutos";
        }
        else  {
            if (horas == 1) {
                if (minutos == 0) {
                    return "1 hora";
                }
                else if (minutos == 1) {
                    return "1 hora 1 minuto";
                }
                else {
                    return String.format("1 hora %d minutos", minutos);
                }
            }
            else {
                if (minutos == 0) {
                    return String.format("%d horas", horas);
                }
                else if (minutos == 1) {
                    return String.format("%d horas 1 minuto", horas);
                }
                else {
                    return String.format("%d horas %d minutos", horas, minutos);
                }
            }
        }
    }

    public Receta modificarProporciones(int numeroPersonas) {
        Receta r = new Receta(this);
        r.numeroPersonas = numeroPersonas;
        r.ingredientes = new ArrayList<>();

        for (CantidadIngrediente c : this.ingredientes) {
            r.ingredientes.add(
                    new CantidadIngrediente(
                            c.getIngrediente(),
                            numeroPersonas * c.cantidad / this.numeroPersonas)
            );
        }

        return r;
    }
}
