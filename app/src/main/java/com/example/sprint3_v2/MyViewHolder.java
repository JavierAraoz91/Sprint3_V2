package com.example.sprint3_v2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView docView, estatView, pesoView, imcView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.imgView);
        docView=itemView.findViewById(R.id.tvDoc);
        estatView=itemView.findViewById(R.id.tvEstat);
        pesoView=itemView.findViewById(R.id.tvPeso);
        imcView=itemView.findViewById(R.id.tvImc);
    }
}
