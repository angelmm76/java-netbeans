package java07ficheros;

import java.io.File;
import java.util.Date;

public class Estruc {
    File archi;
    int contador, contdir;
    int contallamadas;
    String ruta;
    Date fechamodif;
    
    public Estruc(){
        ruta = "C:\\Users\\Alumno.ALUMNO20\\Documents" + 
                "\\AMM\\AMM - POO - UF1\\JavaFroufe";
        // File puede ser archivo o directorio
        archi = new File(ruta);
        fechamodif = new Date();
        System.out.println("Archivos y directorios en " + ruta);
        if (archi.exists()){
            explorar(archi);
            System.out.println("En " + ruta + " hay " + contdir + 
                    " directorios y " + contador + " archivos grandes.");
        }
        else {
            System.out.println("La ruta " + ruta + " es incorrecta.");
        }
        
    }
    
    public void explorar(File arch){
        // Listado de rutas, si arch es directorio, o null si es archivo
        File[] arInter = arch.listFiles();
        contallamadas++;
        
        for (int i=0; i < arInter.length; i++){
            if (arInter[i].isDirectory()){
                // Si es otro directorio explorar los subdirectorios
                contdir++;
                System.out.println("Directorio nº " + contdir + ": " 
                        + arInter[i].getName());
                explorar(arInter[i].getAbsoluteFile());

            }
            else {
                // Si es archivo imprimir su nombre
                // contador++;
                //System.out.println(contador + ": " + arInter[i].getName());
                int tmin = 10*1024;
                if(arInter[i].length() > tmin){
                    // Archivos grandes
                    contador++;
                    fechamodif.setTime(arInter[i].lastModified());
                    System.out.println("Archivo grande nº " + contador + ": " + 
                            arInter[i].getName() + ", tamaño " + 
                            arInter[i].length()/1024 + " kB, " + 
                            fechamodif.toString());
                }
            }               
        }
        
    }
}
