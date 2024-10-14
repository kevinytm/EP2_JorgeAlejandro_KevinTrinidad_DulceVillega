package com.mycompany.ep2.Controlador;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Adyacencia {
    private Vertice vertice;
    private double costo;

    public Adyacencia(Vertice vertice,double costo){
        this.vertice= vertice;
        this.costo=costo;
    }
    
    @Override
    public String toString(){
        return "["+vertice+","+costo+"]";
    }
}

