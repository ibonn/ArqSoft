package com.example.recetas;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.io.ByteArrayOutputStream;
import java.util.Random;


public class Receta {

    private String id;                          // Identificador de la receta
    private String nombre;                      // Nombre de la receta
    private byte[] imagen;                      // Imagen de la receta
    private int duracionMinutos;                // Tiempo de preparación en minutos
    private int numeroPersonas;                 // Número de personas
    private CantidadIngrediente[] ingredientes; // Lista de ingredientes con sus cantidades
private String pasosReceta;                     // Texto de la receta

    public Receta(String id) {
        // TODO cargar receta de la base de datos
        this.id = id;
        this.nombre = "Receta de prueba";
        Bitmap.Config conf = Bitmap.Config.ARGB_8888;
        Bitmap bmp = Bitmap.createBitmap(50, 50, conf);
        Canvas canvas = new Canvas(bmp);
        canvas.drawColor(Color.RED);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(25,25, 25, paint);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        this.imagen = stream.toByteArray();
        Random r = new Random();
        this.duracionMinutos = r.nextInt(120) + 10;
        this.numeroPersonas = r.nextInt(3) + 1;
        this.ingredientes = new CantidadIngrediente[5];
        for (int i = 0; i < 5; i++) {
            this.ingredientes[i] = new CantidadIngrediente(new Ingrediente("Ingrediente de prueba " + i), 6 - i);
        }
        this.pasosReceta = "Pasos para preparar una deliciosa receta de prueba";
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
     * @return Lista de bytes, deberá ser transfomada a Bitmap
     */
    public byte[] getImagen() {
        return imagen;
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
    public CantidadIngrediente[] getIngredientes() {
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
}
