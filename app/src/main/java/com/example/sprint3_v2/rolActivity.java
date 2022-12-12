package com.example.sprint3_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sprint3_v2.R;

public class rolActivity extends AppCompatActivity implements View.OnClickListener {
    Context contexto1;
    Button btn1;
    /*pii1*/
    Context contexto2;
    Button btn2;
    /*pif1*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol);
        btn1=findViewById(R.id.btnEst);

        btn2.findViewById(R.id.btnFun);

        contexto1=getApplicationContext();

        btn1.setOnClickListener(informacionActivity);

        /*pii2*/

        btn2.setOnClickListener(activityHistorial);


        /*pii2*/
    }
    @Override
    public void onClick(View view) {
    }
    private View.OnClickListener informacionActivity=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent int3= new Intent(contexto1, informacionActivity.class);
            startActivity(int3);
        }
    };
    /*pii3*/


    private View.OnClickListener activityHistorial=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent int4= new Intent(contexto2, activityHistorial.class);
            startActivity(int4);
        }
    };


    /*pif3*/
}