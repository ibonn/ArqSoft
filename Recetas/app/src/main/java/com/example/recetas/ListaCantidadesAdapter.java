package com.example.recetas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListaCantidadesAdapter extends RecyclerView.Adapter<ListaCantidadesAdapter.MyViewHolder> {

    Context mContext;
    List<CantidadIngrediente> mData;

    public ListaCantidadesAdapter(Context mContext, List<CantidadIngrediente> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.item_cantidad_ingrediente, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        /*byte[] foto = mData.get(position).getImagen();
        Bitmap fotoBmp = BitmapFactory.decodeByteArray(foto, 0, foto.length);

        holder.imagen.setImageBitmap(fotoBmp);*/

        holder.nombre.setText(mData.get(position).getIngrediente().getNombre());
        holder.cantidad.setText(mData.get(position).getCantidad());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre, cantidad;

        public MyViewHolder(View itemView){
            super(itemView);
            //imagen = itemView.findViewById(R.id.imagen);
            nombre = itemView.findViewById(R.id.nombre_ingrediente);
            cantidad = itemView.findViewById(R.id.cantidad_ingrediente);
        }
    }

}

