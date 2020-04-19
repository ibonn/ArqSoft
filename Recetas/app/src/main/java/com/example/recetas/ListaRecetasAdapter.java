package com.example.recetas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListaRecetasAdapter extends RecyclerView.Adapter<ListaRecetasAdapter.MyViewHolder> {

    Context mContext;
    List<Receta> mData;
    RecyclerView recyclerView;

    public ListaRecetasAdapter(Context mContext, List<Receta> mData, RecyclerView recyclerView) {
        this.mContext = mContext;
        this.mData = mData;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.tarjeta_receta, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = recyclerView.getChildLayoutPosition(v);
                Receta receta = mData.get(itemPosition);

                // Mostrar activity_receta
                Intent intent = new Intent(mContext, ActivityReceta.class);
                intent.putExtra("receta", receta); // Pasar la receta a activity_receta
                mContext.startActivity(intent);
            }
        });
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imagen.setImageBitmap(mData.get(position).getImagen());
        holder.nombreReceta.setText(mData.get(position).getNombre());
        holder.duracion.setText(mData.get(position).getTiempoPreparacion());
        holder.numPersonas.setText(mData.get(position).getNumeroPersonas());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombreReceta, duracion, numPersonas;

        public MyViewHolder(View itemView){
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen);
            nombreReceta = itemView.findViewById(R.id.nombre);
            duracion = itemView.findViewById(R.id.duracion);
            numPersonas = itemView.findViewById(R.id.num_personas);
        }
    }

}

