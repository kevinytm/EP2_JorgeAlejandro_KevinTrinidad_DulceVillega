package com.mycompany.ep2.Controlador;

import com.mycompany.ep2.Modelo.GuardarArchivo;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Archivo {
    
    private String nombre;
    
    public void guardarArchivo(List<String> nombres){
      GuardarArchivo ga = new GuardarArchivo(nombre);  
      ga.guardarArchivoNombres(nombres);
    }
    
    public void leerArchivo(){
        
    }
}
