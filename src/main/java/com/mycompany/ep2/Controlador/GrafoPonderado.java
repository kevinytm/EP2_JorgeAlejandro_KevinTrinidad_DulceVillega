package com.mycompany.ep2.Controlador;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class GrafoPonderado {
    private String nombre;
    private List<Vertice> vertices;
    
    public GrafoPonderado(String nombre){
        this.nombre = nombre;
        this.vertices = new LinkedList<>();
    }
    
    public void addVertice(Vertice... vertices){
        Collections.addAll(this.vertices, vertices);
    }
    
    public void mostrarGradoAdyacencias(){
        System.out.println("Lista de adyacencia");
        for(Vertice v:vertices){
            System.out.print(v+" "+v.getEtiqueta()+"-> {");
            for(Adyacencia adyacencia:v.getAdyacencias()){
                System.out.print(adyacencia+", ");
            }
            System.out.print("}\n");
        }
       
    }
    
    public void recorridoEnAnchura(Vertice inicio){
        Queue<Vertice> queue = new LinkedList<>();
        inicio.setVisitado(true);
        queue.add(inicio);
        
        Vertice actual;
        while(!queue.isEmpty()){
            actual =queue.poll();
            System.out.println(actual);
            for (Adyacencia a:actual.getAdyacencias()){
                if(!a.getVertice().isVisitado()){
                    a.getVertice().setVisitado(true);
                    queue.add(a.getVertice());
                }
            }
        }
    }
    
    public void recorridoEnProfundiad(Vertice inicio){
        Stack<Vertice> pila = new Stack<>();
        inicio.setVisitado(true);
        pila.add(inicio);
        
        Vertice actual;
        while(!pila.isEmpty()){
            actual =pila.pop();
            System.out.println(actual);
            for (Adyacencia a:actual.getAdyacencias()){
                if(!a.getVertice().isVisitado()){
                    a.getVertice().setVisitado(true);
                    pila.add(a.getVertice());
                }
            }
        }
    }
    
    //Necesita una revision
    public void caminoMasCorto(Vertice inicio){
        Queue<Vertice> queue = new LinkedList<>();
        inicio.setVisitado(true);
        inicio.setEtiqueta(new Etiqueta(null,0));
        queue.add(inicio);
        Vertice actual;
        
        while(!queue.isEmpty()){
            actual = queue.poll();
            for (Adyacencia a:actual.getAdyacencias()){
                Etiqueta nuevo= new Etiqueta(
                        actual,actual.getEtiqueta().getCosto()+a.getCosto()
                );
                if(!a.getVertice().isVisitado()){
                    a.getVertice().setVisitado(true);
                    a.getVertice().setEtiqueta(nuevo);
                    queue.add(a.getVertice());
                }
                if(nuevo.getCosto() < a.getVertice().getEtiqueta().getCosto()){
                    a.getVertice().setEtiqueta(nuevo);
                }

            }
        }
    }

    public void caminoMasEconomico(Vertice inicio) {
        // Cola de prioridad que ordena los vértices por el costo de la etiqueta
        PriorityQueue<Vertice> queue = new PriorityQueue<>((v1, v2) -> 
            Double.compare(v1.getEtiqueta().getCosto(), v2.getEtiqueta().getCosto())
        );
        inicio.setVisitado(true);
        inicio.setEtiqueta(new Etiqueta(null, 0));
        queue.add(inicio);

        while (!queue.isEmpty()) {
            Vertice actual = queue.poll(); // Extrae el vértice con menor costo
            for (Adyacencia a : actual.getAdyacencias()) {
                double nuevoCosto = actual.getEtiqueta().getCosto() + a.getCosto();
                Etiqueta nuevaEtiqueta = new Etiqueta(actual, nuevoCosto);

                // Si el vértice aún no ha sido visitado o si encuentra un costo más bajo
                if (!a.getVertice().isVisitado() || nuevoCosto < a.getVertice().getEtiqueta().getCosto()) {
                    a.getVertice().setVisitado(true);
                    a.getVertice().setEtiqueta(nuevaEtiqueta);
                    queue.add(a.getVertice()); // Agrega el vértice a la cola de prioridad
                }
            }
        }
    }
}

