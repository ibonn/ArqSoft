package com.example.recetas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ActivityReceta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Receta r = (Receta)getIntent().getSerializableExtra("receta");
        setContentView(R.layout.activity_receta);

        // Añadir acción al pulsar el botón
        Button botonAjustar = findViewById(R.id.boton_ajustar_prop);
        botonAjustar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cargar la receta con las nuevas proporciones
                EditText numComensales = findViewById(R.id.ajustar_proporcion);
                int numPersonas = Integer.parseInt(numComensales.getText().toString());
                cargarReceta(r.modificarProporciones(numPersonas));
            }
        });

        // Cargar la receta seleccionada
        cargarReceta(r);
    }

    private void cargarReceta(Receta r) {
        // Obtener los campos a rellenar
        ImageView imagen = findViewById(R.id.imagen);
        TextView nombre = findViewById(R.id.nombre);
        TextView duracion = findViewById(R.id.duracion);
        TextView comensales = findViewById(R.id.comensales);
        RecyclerView ingredientes = findViewById(R.id.lista_ingredientes);
        TextView preparacion = findViewById(R.id.preparacion);

        // Rellenar los campos
        imagen.setImageBitmap(r.getImagen());
        nombre.setText(r.getNombre());
        duracion.setText(r.getTiempoPreparacion());
        comensales.setText(r.getNumeroPersonas());

        LinearLayoutManager manager = new LinearLayoutManager(this);
        ingredientes.setLayoutManager(manager);
        ingredientes.setAdapter(new ListaCantidadesAdapter(this, r.getIngredientes()));

        preparacion.setText(r.getPasosReceta());
    }
}
