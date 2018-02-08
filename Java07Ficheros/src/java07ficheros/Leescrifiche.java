package java07ficheros;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Leescrifiche {
    String ruta, ruta2;
    String textolec;
    char[] charlec, charescri;
    FileWriter fw;
    FileReader fr;
    File fichero, fichescri;
    Scanner leer;
    
    public Leescrifiche(){
        ruta = "C:\\Users\\Alumno.ALUMNO20\\Documents\\AMM" + 
                "\\AMM - POO - UF1\\mifichero.txt";
        ruta2 = "C:\\Users\\Alumno.ALUMNO20\\Documents\\AMM" + 
                "\\AMM - POO - UF1\\mifichero2.txt";
        // Bufer de 200 caracteres, para leer textos de un tamaño máximo
        //charbu = new char[200];
        System.out.println("Intentando abrir el archivo " + ruta);
        try {
            // Abrir el fichero para poder comprobaciones de existencia o ver
            // tamaño
            fichero = new File(ruta);
            // **** LECTURA DE FICHERO *****
            // Crear filereader
            fr = new FileReader(ruta);
            System.out.println("Apertura correcta");
            // Crear buffer con tamaño del fichero
            int tamafiche = (int)fichero.length();
            charlec = new char[tamafiche];
            // Leer contenido de fichero en array/bufer
            fr.read(charlec, 0, tamafiche);
            //System.out.println(charlec.length + " " + fichero.length());
            // Convertir el array en string y mostrar el contenido
            textolec = new String(charlec);
            System.out.println("Contenido leido: \n" + textolec);
            // **** ESCRITURA DE FICHERO *****
            // Crear writer
            fw = new FileWriter(ruta2);
            // Texto que se escribirá
            String otrotexto = " Esto es Java, hoy es lunes y... hola ";
            leer = new Scanner(System.in);
            System.out.print("Introducir tu nombre: ");
            String name = leer.next();
            otrotexto += name + "!";
            // Añadir con cadenas
            //fw.write(textolec + otrotexto);
            //fw.flush();
            // Añadir con arrays de char
            // Buffer de escritura
            charescri = new char[tamafiche + otrotexto.length()];
            for(int i =0; i < charescri.length; i++) {
                if(i < tamafiche) charescri[i] = charlec[i];
                else charescri[i] = otrotexto.toCharArray()[i - tamafiche];
            }
            fw.write(charescri);
            fw.flush();
            //System.out.println(texto + mastexto);
            System.out.println("Se añadió el texto: \'" + otrotexto + 
                    "\' y se guardó en el archivo " + ruta2);         
            
        }
        catch (IOException e){
            System.out.println("Problema en apertura! " + e.toString());
            //e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Ocurrió una excepción");
        }
        finally {
            // Si la apertura fue correcta
            if (fr != null) {
                // Intentar cerrarlo
                try {
                    // Cerrar writer y reader
                    fr.close();
                    if (fw != null) fw.close();
                    System.out.println("Operaciones de cierre correctas");
                } 
                catch(IOException e){
                    System.out.println("No se pudo cerrar!! " + e.toString());
                }
            }
        }   
    }    
}
