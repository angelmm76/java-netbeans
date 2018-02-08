package java09xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CreaXMLBORRAR {
    // Atributos
    private Document doc;  // DOM Document W3C
    private Element root;
    private Transformer trans;
    private ArrayList<Book> arrbooks;
    
    // Constructor
    public CreaXMLBORRAR (){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            // Construir documento DOM
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.newDocument();
        } 
        catch (ParserConfigurationException e){
            System.out.println("Excepcion: " + e.toString());
        }
        catch(Exception e){
            System.out.println("Excepcion: " + e.toString());
            e.printStackTrace();
        }
        //arrbooks = new ArrayList<Book>();
    }
    
    // Métodos
    public void createDoc(){
        // Crear raiz
        root = doc.createElement("library");
        doc.appendChild(root);
                
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
        
        // Objeto book que se añade al array
        Book abook = new Book(code, titl, auth, pd);
        arrbooks.add(abook);
        System.out.println(arrbooks.size());

    }
    
    public void insertTeclado (){
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
        Source source = new DOMSource(doc);
        String ruta = "C:\\Users\\Alumno.ALUMNO20\\Documents\\AMM" + 
                "\\AMM - POO - UF1\\" + filename + ".xml";
        try {
            File file = new File(ruta);
            //FileWriter fw = new FileWriter(file);
            //PrintWriter pw = new PrintWriter(fw);
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
                "\\AMM - POO - UF1\\serial_" + filename ;
        try{
            FileOutputStream fos= new FileOutputStream(rutaser);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arrbooks);
            oos.close();
            fos.close();
            System.out.println("Array de objetos serializado guardado en " +
                    rutaser);
       }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    public void show(String filename){
        String ruta = "C:\\Users\\Alumno.ALUMNO20\\Documents\\AMM" + 
                "\\AMM - POO - UF1\\" + filename + ".xml";
        File inputFile = new File(ruta);
        try {
            DocumentBuilderFactory sfact = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = sfact.newDocumentBuilder();
            // Documento DOM
            Document sdoc = builder.parse(inputFile);
            sdoc.getDocumentElement().normalize();
            System.out.println("Root element: " + 
                    doc.getDocumentElement().getNodeName());
            // Lista de hijos con tag book
            NodeList nList = doc.getElementsByTagName("book");
            System.out.println("Nº de books: " + nList.getLength());
            
            // Bucle sobre books
            for (int i = 0; i < nList.getLength(); i++){
                Node nNode = nList.item(i);
                //System.out.print(nNode.getNodeName());
                Element eElement = (Element) nNode;
                System.out.println("Book nº " + (i + 1));
                //System.out.println(eElement.getTextContent());
                // Código del book
                System.out.println("\tCódigo: " + 
                        eElement.getAttribute("code"));
                // Tags de cada book
                NodeList tList = eElement.getElementsByTagName("title");
                //System.out.println(tList.getLength());
                System.out.println("\tTitle: " + 
                        tList.item(0).getTextContent());
                NodeList aList = eElement.getElementsByTagName("author");
                System.out.println("\tAuthor: " + 
                        aList.item(0).getTextContent());
                NodeList pList = eElement.getElementsByTagName("publdate");
                System.out.println("\tPub Date: " + 
                        pList.item(0).getTextContent());
            }
            System.out.println("Datos leidos de archivo XML guardado en " + 
                    ruta);
        }
        catch (Exception e){
            e.printStackTrace();
        } 
    }
}
