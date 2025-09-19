package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button siguiente, saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        siguiente = findViewById(R.id.siguiente);
        siguiente.setOnClickListener(this);

        saludo = findViewById(R.id.saludo);
        saludo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String cadenita = ((Button)v).getText().toString();

        if (cadenita.equals("saludo")){
            Saludito saludote = new Saludito();
            Toast.makeText(this, saludote.saludo() , Toast.LENGTH_SHORT).show();

        }
        else
        if (cadenita.equals("siguiente")){
            Intent intento = new Intent(this, MainActivity2.class);
            startActivity(intento);
        }

    }
}