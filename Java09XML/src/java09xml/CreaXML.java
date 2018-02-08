package java09xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreaXML {
    // Atributos
    private Document doc;  // DOM Document W3C
    private Element root;
    private Transformer trans;
    private ArrayList<Book> arrbooks;
    
    // Constructor
    public CreaXML (){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            // Construir documento DOM
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.newDocument();
            root = doc.createElement("library");
            doc.appendChild(root);
        } 
        catch (ParserConfigurationException e){
            System.out.println("Excepcion: " + e.toString());
        }
        catch(Exception e){
            System.out.println("Excepcion: " + e.toString());
            e.printStackTrace();
        }
        arrbooks = new ArrayList<Book>();
    }
       
    public void insertBook(String code, String titl, String auth, int pd){
        // Nuevo hijo (book)
        Element book = doc.createElement("book");
        book.setAttribute("code", code);  // Atributo del hijo
        root.appendChild(book); // Agregar book al root
        
        // Hijos de book
        Element title = doc.createElement("title");  // Título
        title.appendChild(doc.createTextNode(titl));
        book.appendChild(title);
        
        Element author = doc.createElement("author");  // Autor
        author.appendChild(doc.createTextNode(auth));
        book.appendChild(author);
        
        Element pubdate = doc.createElement("publdate");  // Fecha publicación
        pubdate.appendChild(doc.createTextNode(String.valueOf(pd)));
        book.appendChild(pubdate);
        
        // Objeto Book que se añade al array
        Book abook = new Book(code, titl, auth, pd);
        arrbooks.add(abook);
        //System.out.println(arrbooks.size());

    }
    
    public void insertPorTeclado (){
        Scanner leer = new Scanner(System.in);
        System.out.print("Cuántos libros quieres introducir? ");
        int num;
        num = leer.nextInt();
        
        for (int i = 0; i < num; i++){
            System.out.println("Libro nº " + (i + 1));;
            System.out.print("Código: ");
            String codigo = leer.next();
            System.out.print("Titulo: ");
            String titulo = leer.next();
            System.out.print("Autor: ");
            String autor = leer.next();
            System.out.print("Fecha publicación: ");
            int fecha = leer.nextInt();
            insertBook(codigo, titulo, autor, fecha);
        }
    }
    
    public void save(String filename){
        // Guardar archivo XML
        TransformerFactory factoXML = TransformerFactory.newInstance();
        try {
            trans = factoXML.newTransformer();        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        String ruta = "C:\\Users\\Alumno.ALUMNO20\\Documents\\AMM" + 
            "\\AMM - POO - UF1\\" + filename + ".xml";
        // Objeto fuente DOM que se transformará en un fichero
        Source source = new DOMSource(doc);

        try {
            File file = new File(ruta);
            Result result = new StreamResult(file);
            // Transforma la fuente (XML DOM) en resultado (file)
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.transform(source, result);
            System.out.println("Archivo XML guardado en " + ruta);
        }
        catch(Exception e){
            e.printStackTrace();
        } 
        
        // Guardar array serializado
        String rutaser = "C:\\Users\\Alumno.ALUMNO20\\Documents\\AMM" + 
                "\\AMM - POO - UF1\\serial_" + filename + ".ser";
        try {
            // Stream bytes de salida
            FileOutputStream fos = new FileOutputStream(rutaser);
            // Convertir objeto java en bytes
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Escribir objeto
            oos.writeObject(arrbooks);
            oos.close();
            fos.close();
            System.out.println("Array de objetos serializado guardado en " +
                    rutaser);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
