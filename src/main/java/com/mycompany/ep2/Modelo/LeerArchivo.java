package com.mycompany.ep2.Modelo;

import com.mycompany.ep2.Controlador.Vertice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo {
    
    public List<String> leerArchivoVertices(String nombreArchivo) {
        List<String> vertices = new ArrayList<>();
        try {
            File file = new File(nombreArchivo);
            List<String> contenido = Files.readAllLines(file.toPath());

            // Leer solo la primera línea que contiene los nombres de los vértices
            if (!contenido.isEmpty()) {
                String[] nombres = contenido.get(0).split(";"); // Divide por el delimitador
                for (String nombre : nombres) {
                    vertices.add(nombre.trim()); // Agregar cada nombre al listado
                }
            }
        } catch (IOException ex) {
            System.out.println("Error al leer los vértices: " + ex.getMessage());
        }
        return vertices;
    }

    public List<Vertice> leerArchivoAdyacencias(String nombreArchivo,List<Vertice> vertice) {
        List<String> adyacencias = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            br.readLine(); // Omitir la primera línea

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                //vertice = generarEnlaces(partes,vertice);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo de adyacencias: " + e.getMessage());
        }
        return vertice;
    }
    
    
    /*
    private List<Vertice> generarEnlaces(String[] partes,List<Vertice> vertice){
        for(Vertice v:vertice){
            if(partes[0].equals(v.getLabel())){
                for(int j=1;j<partes.length;j++){
                    for(Vertice b:vertice){
                        if(partes[j].equals(b.getLabel())){
                            v.getEdges().add(b);
                        }
                    }
                }
            }
        }
        return vertice;
     } 
     */
}
