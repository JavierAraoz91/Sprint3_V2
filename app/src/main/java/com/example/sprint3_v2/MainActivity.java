package com.example.sprint3_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contexto=getApplicationContext();
        btn1=findViewById(R.id.btnIniciar);
        btn2=findViewById(R.id.btnRegistrar);
        btn1.setOnClickListener(rolActivity);
        btn2.setOnClickListener(registroActivity);



        FirebaseFirestore db=FirebaseFirestore.getInstance();
        Map<String, Object> alum = new HashMap<>();
        alum.put("nombre", "Juan");
        alum.put("apellido","Pelaez");
        alum.put("correo","jpelaez@hotmail.com");
        alum.put("contraseña","hasuybr");
        alum.put("documento","15020120");
        db.collection("Establecimientos")
                .add(alum)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("MAin", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Main", "Error adding document", e);
                    }
                });
    }
    private View.OnClickListener rolActivity=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent int1= new Intent(contexto, rolActivity.class);
            startActivity(int1);
        }
    };
    private View.OnClickListener registroActivity=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent int1= new Intent(contexto, registroActivity.class);
            startActivity(int1);
        }
    };
}