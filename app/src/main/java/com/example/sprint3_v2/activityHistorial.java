package com.example.sprint3_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class activityHistorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        List<Alumno> alm=new ArrayList<Alumno>();
        alm.add(new Alumno("Santiago Pisterra","4A",45,R.drawable.logounabheader));
        alm.add(new Alumno("Emilio Varela","7B",50,R.drawable.carafeliz));
        alm.add(new Alumno("Juan Guzman","9B",85,R.drawable.nino));


        RecyclerView recyclerView=findViewById(R.id.recycView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adaptador adaptador=new Adaptador(getApplicationContext(),alm);
        recyclerView.setAdapter(adaptador);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Main Activity","Presionado: " + alm.get(recyclerView.getChildAdapterPosition(view)).getNombre());
            }
        });
    }
}