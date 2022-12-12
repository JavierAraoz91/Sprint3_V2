package com.example.sprint3_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class registroActivity extends AppCompatActivity {
    Button btn1;
    EditText et_name;
    EditText et_lastName;
    EditText et_email;
    EditText et_passrd;
    EditText et_idNum;
    String name;
    String lastName;
    String correo;
    String passrd;
    String numDoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btn1=findViewById(R.id.btnReg);
        btn1.setOnClickListener(ev);

    }
    View.OnClickListener ev=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FirebaseFirestore db=FirebaseFirestore.getInstance();
            et_name= (EditText) findViewById(R.id.nameR);
            et_lastName=(EditText) findViewById(R.id.lNameR);
            et_email=(EditText) findViewById(R.id.emailReg);
            et_passrd=(EditText) findViewById(R.id.contraseñaR);
            et_idNum=(EditText) findViewById(R.id.documentR);
            name=et_name.getText().toString();
            lastName=et_lastName.getText().toString();
            correo=et_email.getText().toString();
            passrd=et_passrd.getText().toString();
            numDoc=et_idNum.getText().toString();

            Map<String, Object> alum = new HashMap<>();
            alum.put("nombre", name);
            alum.put("apellido",lastName);
            alum.put("correo",correo);
            alum.put("contraseña",passrd);
            alum.put("documento",numDoc);
            db.collection("Registros")
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
    };
}
