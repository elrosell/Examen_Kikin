package com.example.examen;

import java.util.ArrayList;

public class Arreglito {

    ArrayList<Clasesita> apulseritas = new ArrayList<>();

    public void agregar(Clasesita objetito){
        apulseritas.add(objetito);
    }

    public ArrayList<Clasesita> aRegresar(){
        return apulseritas;
    }
}
