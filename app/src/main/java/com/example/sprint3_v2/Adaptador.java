package com.example.sprint3_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class  Adaptador extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener{
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
        vista.setOnClickListener((View.OnClickListener) this);
        return new MyViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.docView.setText(items.get(position).getDocumento());
        holder.estatView.setText(String.valueOf(items.get(position).getEstatura()));
        holder.pesoView.setText(String.valueOf(items.get(position).getPeso()));
        holder.imcView.setText(String.valueOf(items.get(position).getImc()));
        holder.imageView.setImageResource(R.drawable.avatar);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(View view){
        if(listener!=null){
            listener.onClick(view);
        }
    }
    public void setOnCliclListener(View.OnClickListener listener){
        this.listener=listener;
    }
}
