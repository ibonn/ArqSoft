package com.example.recetas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaIngredientes extends RecyclerView.Adapter<ListaIngredientes.MyViewHolder> {
    private Context myContext;
    private List<Ingrediente> listaIngredientes;
    private List<Ingrediente> checkedIngredientes;

    public ListaIngredientes(Context myContext, List<Ingrediente> myData) {
        this.myContext = myContext;
        this.listaIngredientes = myData;
        this.checkedIngredientes = new ArrayList<>();
    }

    public List<Ingrediente> getCheckedIngredientes() {
        return checkedIngredientes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View v = inflater.inflate(R.layout.item_ingrediente, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        // Rellenar los campos de la tarjeta de ingrediente con los valores correspondientes
        // TODO descomentar la línea de abajo
        // holder.imagenIngrediente.setImageBitmap(listaIngredientes.get(position).getImagen());
        holder.checkIngrediente.setText(listaIngredientes.get(position).getNombre());
        holder.checkIngrediente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext, "Pulsado el ingrediente número " + position, Toast.LENGTH_SHORT).show();
                if (listaIngredientes.get(position).getSelected()) {
                    listaIngredientes.get(position).setSelected(false);
                    checkedIngredientes.remove(listaIngredientes.get(position));
                }
                else {
                    listaIngredientes.get(position).setSelected(true);
                    checkedIngredientes.add(listaIngredientes.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaIngredientes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Obtener los campos de la tarjeta
        private CheckBox checkIngrediente;  // Checkbox con el nombre del ingrediente
        private ImageView imagenIngrediente;    // Imagen del ingrediente

        public MyViewHolder(View itemView){
            super(itemView);
            checkIngrediente = itemView.findViewById(R.id.check_ingrediente);
            imagenIngrediente = itemView.findViewById(R.id.imagen_ingrediente);
        }
    }
}
