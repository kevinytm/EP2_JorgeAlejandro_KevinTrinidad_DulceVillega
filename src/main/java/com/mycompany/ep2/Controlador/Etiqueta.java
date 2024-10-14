package com.mycompany.ep2.Controlador;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Etiqueta {
    private Vertice vertice;
    private double costo;
    
    @Override
    public String toString(){
        return "["+vertice+","+costo+"]";
    }   
}
