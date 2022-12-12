package com.example.sprint3_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class activityHistorial extends AppCompatActivity {
    Adaptador adaptador;
    Intent it;
    Context contexto;
    Alumno a=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        FirebaseFirestore db=FirebaseFirestore.getInstance();
        List<Alumno> alm=new ArrayList<Alumno>();
        RecyclerView recyclerView=findViewById(R.id.recycView);
        recyclerView.setLayoutManager(new LinearLayoutManager(contexto));
        db.collection("Registros")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document: task.getResult()){
                                Log.d("Main",document.getId()+"=>"+document.getData());
                                String documento=document.getString("documento");
                                String estatura=document.get("estatura (cm)").toString();
                                String imc=document.getString("imc");
                                String peso=document.getString("peso (kg)");
                                a=new Alumno(documento,estatura,imc,peso);
                                alm.add(a);
                            }
                            adaptador=new Adaptador(getApplicationContext(),alm);
                            recyclerView.setAdapter(adaptador);
                        }else{
                            Log.w("Main","Error getting documents",task.getException());
                        }
                    }
                });

    }
}