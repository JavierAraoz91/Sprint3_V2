package com.example.sprint3_v2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {
    Context contexto;
    List<Alumno> items;
    private View.OnClickListener listener;

    public Adaptador (Context contexto, List<Alumno> items){
        this.contexto=contexto;
        this.items=items;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("vamos bien");
            }
        });
        return new MyViewHolder(vista);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nomView.setText(items.get(position).getNombre());
        holder.curView.setText(items.get(position).getCurso());
        holder.pesoView.setText(String.valueOf(items.get(position).getPeso()));
        holder.imgView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView;
        TextView nomView, curView,pesoView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView=itemView.findViewById(R.id.imgView);
            nomView=itemView.findViewById(R.id.tvNombre);
            curView=itemView.findViewById(R.id.tvCurso);
            pesoView=itemView.findViewById(R.id.tvPeso);
        }
    }
}
