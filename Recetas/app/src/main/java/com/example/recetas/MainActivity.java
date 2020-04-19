package com.example.recetas;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Cargar los ingredientes en la lista
        RecyclerView recyclerIngredientes = findViewById(R.id.lista_ingredientes);
        final ListaIngredientes adapterListaIngredientes = new ListaIngredientes(this, Ingrediente.getIngredientes());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerIngredientes.setLayoutManager(manager);
        recyclerIngredientes.setAdapter(adapterListaIngredientes);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numIngredientes = adapterListaIngredientes.getCheckedIngredientes().size();
                if (numIngredientes == 0) {
                    Snackbar.make(view, R.string.selecciona_ingredientes, Snackbar.LENGTH_LONG).show();
                }
                else {
                    // TODO Realizar la búsqueda de las recetas con los ingredientes que hay en adapterListaIngredientes.getCheckedIngredientes()
                    Snackbar.make(view, "Número de ingredientes seleccionados: " + numIngredientes, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent intentListRecetas = new Intent(MainActivity.this, ActivityListaRecetas.class);
                    MainActivity.this.startActivity(intentListRecetas);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
