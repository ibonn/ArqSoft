package com.example.recetas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ActivityListaRecetas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas);

        RecyclerView recyclerRecetas = findViewById(R.id.lista_recetas);
        List<Receta> listaRecetas = new ArrayList<>();

        // TODO cargar las recetas desde el servidor en función del tiempo máximo y los ingredientes seleccionados
        for (int i = 0; i < 10; i++) {
            listaRecetas.add(new Receta("idReceta"));
        }

        ListaRecetasAdapter listaRecetasAdapter = new ListaRecetasAdapter(this, listaRecetas, recyclerRecetas);
        LinearLayoutManager manager = new LinearLayoutManager(this);

        recyclerRecetas.setLayoutManager(manager);
        recyclerRecetas.setAdapter(listaRecetasAdapter);

    }
}
