package com.example.recetas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListaRecetasAdapter extends RecyclerView.Adapter<ListaRecetasAdapter.MyViewHolder> {

    Context mContext;
    List<Receta> mData;

    public ListaRecetasAdapter(Context mContext, List<Receta> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.tarjeta_receta, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // TODO añadir imagen (descomentar lo de abajo)
        /*byte[] foto = mData.get(position).getImagen();
        Bitmap fotoBmp = BitmapFactory.decodeByteArray(foto, 0, foto.length);

        holder.imagen.setImageBitmap(Bitmap.createScaledBitmap(
                fotoBmp,
                holder.imagen.getWidth(),
                holder.imagen.getHeight(),
                false
        ));*/

        holder.nombreReceta.setText(mData.get(position).getNombre());
        holder.duracion.setText(mData.get(position).getTiempoPreparacion());
        holder.numPersonas.setText(mData.get(position).getNumeroPersonas());
        /*holder.botonVerMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO cargar la ruta
                // mostrar la ruta en el mapa
                // TODO cambiar a la pestaña de mapa
            }
        });*/
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

