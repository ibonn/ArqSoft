package com.example.recetas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.io.ByteArrayOutputStream;
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
        // TODO una vez obtenida la imagen del servidor descomentar la línea de abajo y eliminar el resto
        // return BitmapFactory.decodeByteArray(imagen, 0, imagen.length);
        Bitmap.Config conf = Bitmap.Config.ARGB_8888;
        Bitmap bmp = Bitmap.createBitmap(50, 50, conf);
        Canvas canvas = new Canvas(bmp);
        canvas.drawColor(Color.RED);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(25,25, 25, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(10);
        canvas.drawText("Imagen", 5, 10, paint);
        canvas.drawText("ingrediente", 5, 20, paint);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return bmp;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}


