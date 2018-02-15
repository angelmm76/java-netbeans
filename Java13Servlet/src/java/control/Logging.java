package control;

import java.io.FileWriter;
import java.io.IOException;

public class Logging {
    private String ruta;
    private FileWriter fw;
    
    public Logging(){
        ruta = "C:\\Users\\Alumno.ALUMNO20\\Documents\\AMM\\LogServletSQL.txt";
    }   
    
    public void writeLine(String line){
        // **** ESCRITURA DE FICHERO *****
        try {     
            // Crear writer
            fw = new FileWriter(ruta, true);
            String rc = System.lineSeparator();
            fw.write(line + rc);
            fw.flush();

            System.out.println("Se añadió el texto: " + line + " en " + ruta); 
        }
        catch (IOException e){
            System.out.println("Problema en apertura! " + e.toString());
            //e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Ocurrió una excepción");
        }
        finally {
            try {
                // Cerrar writer y reader
                if (fw != null) fw.close();
                System.out.println("Operaciones de cierre correctas");
            } 
            catch(IOException ioe){
                System.out.println("No se pudo cerrar!! " + ioe.toString());
                ioe.printStackTrace();
            }
            catch (Exception e){
                System.out.println("Ocurrió una excepción");
                e.printStackTrace();
            }
        }  
        
    }
}
