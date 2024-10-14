package com.mycompany.ep2.Vista;

import com.mycompany.ep2.Controlador.Archivo;
import com.mycompany.ep2.Controlador.GrafoPonderado;
import com.mycompany.ep2.Controlador.Vertice;
import com.mycompany.ep2.Modelo.GuardarArchivo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    
   private void opciones() {
        System.out.println("=================================================================");
        System.out.printf("%-25s Menu Principal%25s", "", "");
        System.out.println("\n=================================================================");
        System.out.println("0. Finalizar Programa");
        System.out.println("1. Crear Grafo");
        System.out.println("2. Agregar Nodos");
        System.out.println("3. Agregar adyacencias (nodos)");
        System.out.println("4. Mostrar datos del Grafo Actual");
        System.out.println("5. Cargar grafo de un archivo");
        System.out.println("6. Agregar Nuevo Nodo");
        System.out.println("7. Agregar Nueva Adyacencia");
        System.out.println("8. Guardar el grafo");
    }
    
    private void opcionesGrafos(){
        System.out.println("=================================================================");
        System.out.printf("%-23s¿Qué desea viusalizar?%20s", "", "");
        System.out.println("\n=================================================================");
        System.out.println("0. Retornar al menu Prinicpal");
        System.out.println("1. Número, nombre y grado de los nodos que componen el grafo");
        System.out.println("2. Mostrar nodos y adyacencias");
        System.out.println("3. Recorrido en anchura y profundidad iniciando desde cualquier nodo.");
        System.out.println("4. Determinar si el grafo es conexo");
    }
    
    public void menu(){
        Scanner sc = new Scanner(System.in);
        Archivo a = new Archivo();
        GrafoPonderado gp;
        Vertice v;
        
        String nombre="";
        
        List<Vertice> ve = new ArrayList<>();
        List<String> leerArchivoVertices = new ArrayList<>();
        List<String> leerArchivoAdyacencias = new ArrayList<>();
        
        int numNodos=0;
        List<String> nombres = new ArrayList<>();
        List<String> adyacencias = new ArrayList<>();
        boolean flag=true;
       
        while(flag){
            opciones();
            int opc = sc.nextInt();
            if(opc==0){
               flag = false;  
            }
            switch (opc) {
                case 1:
                    gp = crearGrafo();
                    a.setNombre(gp.getNombre());
                    break;
                case 2:
                    sc.nextLine();
                    numNodos = getNumNodos();
                    nombres = getNombres(numNodos);
                    a.guardarArchivo(nombres);
                    break;
                case 3:
                    break;
                case 4:
                    int opc2 = sc.nextInt();
                    switch (opc2) {
                        case 1:
                            
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            /*
                            sc.nextLine();
                            System.out.println("Ingrese el nombre sel Vertice");
                            String ver = sc.nextLine();
                            v=buscarVertice(ver,ve);
                            System.out.println("Recorrido en anchura:");
                            gr.recorridoEnAnchura(v);
                            
                            for(Vertice c:ve){
                                c.setVisited(false);
                            }
                            
                            System.out.println("Recorrido por profuncidad:");
                            gr.recorridoEnProfundidad(v);
                            */
                            break;
                        case 4:
                            
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                case 5:
                    break;
                case 6:
                    
                    
                break;
                case 7:
                    
                break;
                default:
                    System.out.println("Programa finalizado");
            }
        }
    }    
   
    private GrafoPonderado crearGrafo(){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        
        System.out.println("Escriba el nombre del nuevo grafo");
        String nombre = sc.nextLine();
        nombre= nombre+".map";
        GrafoPonderado gp = new GrafoPonderado(nombre);
        return gp;
    }

    private int getNumNodos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de nodos");
        return sc.nextInt();
    }

    private List<String> getNombres(int numNodos) {
        List<String> nombres = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < numNodos; i++) {
            System.out.println("Ingrese el nombre para el nodo " + (i + 1) + ": ");
            String nom = sc.next();
            nombres.add(nom);
        }
        return nombres;
    }

    private List<String> getAdyacencias(int numNodos, List<String> nombres) {
        Scanner sc = new Scanner(System.in);
        List<String> adyacencias = new ArrayList<>();
        
        System.out.println("Asigna las adyacencias, (Nodo1,Nodo2)");
        for (String nombre : nombres) {
            System.out.println("[" + nombre + "]: ");
            String adyacencia = sc.next();
            adyacencias.add(nombre + ";" + adyacencia);
        }
        return adyacencias;
    }

//    private void agregarVertice(Grafo g, String nombreArchivo) {
//        Scanner sc = new Scanner(System.in);
//
//        // Ingreso del nuevo vértice
//        System.out.println("Ingrese el nombre del nuevo Nodo: ");
//        String nombreVertice = sc.next();
//
//        // Crear el nuevo vértice
//        Vertice nuevoVertice = new Vertice(nombreVertice, 0); // 'data' se inicializa en 0 o cualquier valor deseado
//
//        // Agregar el nuevo vértice al grafo
//        g.addVertice(nuevoVertice);
//
//        // Guardar el nuevo vértice en el archivo
//        Archivo arc = new Archivo(nombreArchivo); // Archivo específico para el grafo
//        arc.agregarVerticeAlArchivo(nombreVertice); // Solo se almacena el nombre del vértice  
//    }

//    private void agregarAdya(Grafo g, String nombreArchivo) {
//        Scanner sc = new Scanner(System.in);
//
//        // Pregunta por el vertice al que se le anadiran las adyacencias
//        System.out.println("Ingrese el nombre del vertice al que desea agregar adyacencias: ");
//        String nombreVertice = sc.next();
//
//        // Buscar el vertice en el grafo
//        Vertice vertice = g.getVerticeByLabel(nombreVertice);
//
//        if (vertice == null) {
//            System.out.println("El vertice '" + nombreVertice + "' no existe en el grafo.");
//            return;
//        }
//
//        // Pregunta por las adyacencias
//        System.out.println("Asigna las Nuevas adyacencias, (Nodo1,Nodo2): ");
//        
//         System.out.print("[" + nombreVertice + "]: ");
//         String adyacencias = sc.next();
//
//        // Separar los nombres de los vertices adyacentes
//        String[] verticesAdyacentes = adyacencias.split(";");
//
//        // Procesar cada vertice adyacente
//        for (String nombreAdyacente : verticesAdyacentes) {
//            nombreAdyacente = nombreAdyacente.trim(); // Eliminar espacios adicionales
//
//            //System.out.println("Buscando vertice: " + nombreAdyacente);
//            Vertice verticeAdyacente = g.getVerticeByLabel(nombreAdyacente);
//
//            if (verticeAdyacente != null) {
//                // Anadir adyacencia al vertice
//                vertice.addEdges(verticeAdyacente);
//                //System.out.println("Adyacencia agregada: " + nombreVertice + " -> " + nombreAdyacente);
//
//               
//                // Guardar la nueva adyacencia en el archivo
//                Archivo arc = new Archivo(nombreArchivo); // Usar el archivo especifico para el grafo
//                arc.guardarArchivoAdyacencias(List.of(nombreVertice + ";" + nombreAdyacente));
//            } else {
//                System.out.println("El vertice adyacente '" + nombreAdyacente + "' no existe en el grafo.");
//            }
//        }
//    }
//
//    public Vertice buscarVertice(String nombre,List<Vertice> vertice){
//        for(Vertice v:vertice){
//            if(v.getLabel().equals(nombre)){
//                return v;
//            }
//            
//        }
//        return null;
//    }    
}
