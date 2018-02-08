package java09xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerXML {
    private File xmlFile;
    private DocumentBuilderFactory dbf;
    private DocumentBuilder builder;
    private Document doc;
    private ArrayList<Book> arrbooks;
    
    // Constructor
    public LeerXML(){
        try {
            dbf = DocumentBuilderFactory.newInstance();
            builder = dbf.newDocumentBuilder();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // Método para leer
    public void leer(String filename){
        //Leer XML y mostrar datos en consola
        String ruta = "C:\\Users\\Alumno.ALUMNO20\\Documents\\AMM" + 
                "\\AMM - POO - UF1\\" + filename + ".xml";
        try {
            xmlFile = new File(ruta);
            doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("\nRaiz del xml: " + 
                doc.getDocumentElement().getNodeName());
            // Lista de hijos con etiqueta book
            NodeList nList = doc.getElementsByTagName("book");
            System.out.println("Nº de books: " + nList.getLength());
            
            // Bucle sobre books
            for (int i = 0; i < nList.getLength(); i++){
                Node nNode = nList.item(i);
                //System.out.print(nNode.getNodeName());
                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    System.out.print("Book nº " + (i + 1));
                    // Código del book
                    System.out.print("\tCódigo: " + 
                            eElement.getAttribute("code"));
                    // Contenido de tags/nodos de cada book
                    System.out.print("\tTitle: " + 
                        eElement.getElementsByTagName("title").item(0)
                            .getTextContent());
                    System.out.print("\tAuthor: " + 
                        eElement.getElementsByTagName("author").item(0)
                            .getTextContent());
                    System.out.println("\tPub Date: " + 
                        eElement.getElementsByTagName("publdate").item(0)
                            .getTextContent());
                }
            }
            System.out.println("Datos leidos de archivo XML guardado en "
                    + ruta);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        // Leer array de archivo serializado
        String rutaser = "C:\\Users\\Alumno.ALUMNO20\\Documents\\AMM" + 
                "\\AMM - POO - UF1\\serial_" + filename + ".ser" ;
        try {
            FileInputStream fis = new FileInputStream(rutaser);
            ObjectInputStream ois = new ObjectInputStream(fis);
            // Leer objeto y hacer cast
            arrbooks = (ArrayList<Book>) ois.readObject();
            ois.close();
            fis.close();
        } 
        catch (IOException i) {
            i.printStackTrace(); 
        }
        catch (ClassNotFoundException c) {
            System.out.println("ArrayList<Book> class not found");
            c.printStackTrace();
        }
        // Mostrar objetos Book "deserializados" en consola 
        for (Book bo: arrbooks){
            System.out.println(bo.toString());
        }
        System.out.println("Datos leidos de archivo serializado guardado en "
            + rutaser);
        
    }
}
