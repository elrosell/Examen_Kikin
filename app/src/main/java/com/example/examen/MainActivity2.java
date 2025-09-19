package com.example.examen;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    Button otrosaludo, agregar, despliega;
    EditText edita1, edita2;
    Spinner combo;
    TextView vista;

    Arreglito arreglito = new Arreglito();
    ArrayList<Clasesita> aRegresar = arreglito.aRegresar();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        String cadenitas[]= {"selecciona", "pulseras", "cadenas"};
        ArrayAdapter adaptadito;

        otrosaludo =  findViewById(R.id.otrosaludo);
        otrosaludo.setOnClickListener(this);

        vista = findViewById(R.id.vista);

        combo = findViewById(R.id.combo);
        combo.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String cadenita = ((Button)v).getText().toString();

        if (cadenita.equals("otro saludo")){
            Saludito otrosal = new Saludito();
            Toast.makeText(this,otrosal.otrosaludo(), Toast.LENGTH_SHORT).show();
        }else
        if(cadenita.equals("pulseras")){
            Clasesita objetito = new Clasesita();
            objetito.setTipo("pulserita");
            objetito.setCantidad(Integer.parseInt(edita1.getText().toString()));
            objetito.setCosto(Integer.parseInt(edita2.getText().toString()));
            arreglito.agregar(objetito);
        }
        else
        if(cadenita.equals("cadenas")){
            Clasesita objetito = new Clasesita();
            objetito.setTipo("cadenitas");
            objetito.setCantidad(Integer.parseInt(edita1.getText().toString()));
            objetito.setCosto(Integer.parseInt(edita2.getText().toString()));
            arreglito.agregar(objetito);
        }
        else
        if (cadenita.equals("desplegar")){
            Clasesita objetito = new Clasesita();
            aRegresar = arreglito.aRegresar();
            String cadenota = "";
            int total = 0;
            int cuantas = aRegresar.size();
            for (int i = 0; i < cuantas; i++){

                cadenota += aRegresar.get(i).getTipo() + "\t"
                        + aRegresar.get(i).getCantidad() + "\t"
                        + aRegresar.get(i).getCosto();
                total += aRegresar.get(i).getCosto();
            }
            cadenota = cadenota + "\n" + total;


        }

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String cadenita = combo.getOnItemSelectedListener().toString();

        if(cadenita.equals("otro saludo") || cadenita.equals("agregar") || cadenita.equals("pulseras") || cadenita.equals("cadenas") || cadenita.equals("agregar") || cadenita.equals("desplegar")){
            if (cadenita.equals("otro saludo")){
                Saludito otrosal = new Saludito();
                Toast.makeText(this,otrosal.otrosaludo(), Toast.LENGTH_SHORT).show();
            }else
            if(cadenita.equals("pulseras")){
                Clasesita objetito = new Clasesita();
                objetito.setTipo("pulserita");
                objetito.setCantidad(Integer.parseInt(edita1.getText().toString()));
                objetito.setCosto(Integer.parseInt(edita2.getText().toString()));
                arreglito.agregar(objetito);
            }
            else
            if(cadenita.equals("cadenas")){
                Clasesita objetito = new Clasesita();
                objetito.setTipo("pulserita");
                objetito.setCantidad(Integer.parseInt(edita1.getText().toString()));
                objetito.setCosto(Integer.parseInt(edita2.getText().toString()));
                arreglito.agregar(objetito);
            }

            else
            if (cadenita.equals("desplegar")){
                Clasesita objetito = new Clasesita();
                aRegresar = arreglito.aRegresar();
                String cadenota = "";
                int total = 0;
                int cuantas = aRegresar.size();
                for (int i = 0; i < cuantas; i++){

                    cadenota += aRegresar.get(i).getTipo() +
                            "\t" + aRegresar.get(i).getCantidad() +
                            "\t" + aRegresar.get(i).getCosto();
                    total += aRegresar.get(i).getCosto();
                }
                cadenota = cadenota + "\n" + total;
            }
        }


    }
}