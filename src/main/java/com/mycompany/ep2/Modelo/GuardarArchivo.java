package com.mycompany.ep2.Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class GuardarArchivo {
     private String nombreArchivo;

    public GuardarArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public void guardarArchivoNombres(List<String> nombres) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write(String.join(";", nombres));
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
    
//    public void guardarArchivoAdyacencia(List<String> nuevasAdyacencias) {
//        Map<String, Vertice> verticesMap = new HashMap<>();
//
//        // Leer el archivo existente y cargar las adyacencias
//        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
//            String linea;
//            while ((linea = br.readLine()) != null) {
//                String[] partes = linea.split(";");
//                String verticeLabel = partes[0].trim();
//                Vertice vertice = new Vertice(verticeLabel, 0); // Data puede ser 0 por defecto
//
//                // Agregar el vértice al mapa
//                verticesMap.put(verticeLabel, vertice);
//
//                if (partes.length > 1) {
//                    for (int i = 1; i < partes.length; i++) {
//                        String adyacenteLabel = partes[i].trim();
//                        vertice.addEdges(new Vertice(adyacenteLabel, 0)); // Asumimos data como 0 para los adyacentes
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Error al leer el archivo: " + e.getMessage());
//        }
//
//        // Agregar las nuevas adyacencias
//        for (String nueva : nuevasAdyacencias) {
//            String[] partes = nueva.split(";");
//            if (partes.length < 2) {
//                System.out.println("Formato incorrecto en la nueva adyacencia: " + nueva);
//                continue; // Salta este registro si no tiene el formato esperado
//            }
//
//            String verticeNombre = partes[0].trim();
//            String adyacenteNombre = partes[1].trim();
//
//            // Obtener o crear el vértice
//            Vertice vertice = verticesMap.computeIfAbsent(verticeNombre, k -> new Vertice(k, 0));
//            vertice.addEdges(new Vertice(adyacenteNombre, 0)); // Añadir la adyacencia
//
//            // Asegurarse de que el adyacente también esté en el mapa
//            verticesMap.computeIfAbsent(adyacenteNombre, k -> new Vertice(k, 0));
//        }
//
//        // Sobrescribir el archivo con los vértices y las adyacencias
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
//            // Escribir la primera línea con todos los vértices
//            bw.write(String.join(";", verticesMap.keySet()));
//            bw.newLine();
//
//            // Escribir las adyacencias correspondientes
//            for (Vertice vertice : verticesMap.values()) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(vertice.getLabel());
//                List<String> adyacencias = vertice.getEdges().stream()
//                        .map(Vertice::getLabel)
//                        .toList();
//                if (!adyacencias.isEmpty()) {
//                    sb.append(";").append(String.join(";", adyacencias));
//                }
//                bw.write(sb.toString());
//                bw.newLine();
//            }
//        } catch (IOException e) {
//            System.out.println("Error al sobrescribir el archivo: " + e.getMessage());
//        }
//    }


    
    public void guardarArchivoAdyacencias(List<String> adyacencias){
        try{
            File file = new File(nombreArchivo);
            FileWriter fw = new FileWriter(file,true);  
            for(String adyacencia:adyacencias){
                fw.append(adyacencia); 
                fw.append("\n");
            }
            fw.close();
        }catch(IOException ex){
            System.out.println("Error: "+ex);
        }        
    }

    public void agregarVerticeAlArchivo(String vertice) {
        // Este método puede no ser necesario si ya guardas adyacencias al agregar un vértice.
        // Pero si lo necesitas, aquí está el ejemplo:
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(vertice + ";");
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al agregar el vértice: " + e.getMessage());
        }
    }  
}
