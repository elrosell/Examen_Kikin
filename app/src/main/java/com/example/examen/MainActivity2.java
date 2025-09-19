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

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button otrosaludo, agregar, desplegar;
    EditText edita1, edita2;
    Spinner combo;
    TextView vista;

    Arreglito arreglito = new Arreglito();
    ArrayList<Clasesita> aRegresar = arreglito.aRegresar();
    String cadenitas[] = {"selecciona", "pulseras", "cadenas"};
    String opcionSeleccionada = "selecciona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        otrosaludo = findViewById(R.id.otrosaludo);
        otrosaludo.setOnClickListener(this);

        agregar = findViewById(R.id.agregar);
        agregar.setOnClickListener(this);

        desplegar = findViewById(R.id.desplegar);
        desplegar.setOnClickListener(this);

        edita1 = findViewById(R.id.edit1);
        edita2 = findViewById(R.id.edit2);
        vista = findViewById(R.id.vista);

        combo = findViewById(R.id.combo);
        ArrayAdapter<String> adaptadito = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cadenitas);
        adaptadito.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        combo.setAdapter(adaptadito);
        combo.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        String cadenita = ((Button) v).getText().toString();

        if (cadenita.equals("otro saludo")) {
            Saludito otrosal = new Saludito();
            Toast.makeText(this, otrosal.otrosaludo(), Toast.LENGTH_SHORT).show();
        } else if (cadenita.equals("agregar")) {
            if (opcionSeleccionada.equals("selecciona")) {
                Toast.makeText(this, "Selecciona pulseras o cadenas", Toast.LENGTH_SHORT).show();
                return;
            }

            String cantidadTexto = edita1.getText().toString();
            String costoTexto = edita2.getText().toString();

            if (cantidadTexto.isEmpty() || costoTexto.isEmpty()) {
                Toast.makeText(this, "Escribe la cantidad y el costo", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int cantidad = Integer.parseInt(cantidadTexto);
                int costo = Integer.parseInt(costoTexto);

                Clasesita objetito = new Clasesita();
                objetito.setTipo(opcionSeleccionada);
                objetito.setCantidad(cantidad);
                objetito.setCosto(costo);
                arreglito.agregar(objetito);

                edita1.setText("");
                edita2.setText("");
                Toast.makeText(this, "Artículo guardado", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException exception) {
                Toast.makeText(this, "Solo números en cantidad y costo", Toast.LENGTH_SHORT).show();
            }
        } else if (cadenita.equals("desplegar")) {
            aRegresar = arreglito.aRegresar();
            String cadenota = "";
            int total = 0;
            int cuantas = aRegresar.size();

            for (int i = 0; i < cuantas; i++) {
                cadenota += aRegresar.get(i).getTipo() + "\t" +
                        aRegresar.get(i).getCantidad() + "\t" +
                        aRegresar.get(i).getCosto() + "\n";
                total += aRegresar.get(i).getCosto();
            }

            if (cuantas > 0) {
                cadenota = cadenota + "Total:\t" + total;
            }

            vista.setText(cadenota);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        opcionSeleccionada = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        opcionSeleccionada = "selecciona";
    }
}