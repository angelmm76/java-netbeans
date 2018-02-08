package java02arrays;

import java.util.ArrayList;
import java.util.Random;

public class Arrlis {
    ArrayList<Float> datos;

    String expresion;
    Random ran;
    
    // Constructor
    public Arrlis(){
        expresion = "]";
        ran = new Random();
        datos = new ArrayList<>();
    }
    
    // Método para rellenar
    public void relle(int nelem) {
        for (int i=0; i<nelem; i++){
            datos.add(100 * ran.nextFloat());
            System.out.println(" ArrayList " + i + ": " + datos.get(i) + 
                    ", tamaño: " + datos.size() + " " + datos.toString());
        }
        
        float fmax = datos.get(0);
        float fmin = datos.get(0);
        for (int i=1; i < datos.size(); i++){
            if (datos.get(i) > fmax) fmax = datos.get(i);
            if (datos.get(i) < fmin) fmin = datos.get(i);
        }
        System.out.println("Máximo:" + fmax + ", mínimo: " + fmin);
        
        for (int i=0; i<datos.size(); i++){
            if (datos.get(i) > 80) datos.set(i, 80.f);
            if (datos.get(i) < 20) datos.set(i, 20.f);    
        }
        System.out.println("ArrayList modif " + datos.toString());
                
    } 
}
