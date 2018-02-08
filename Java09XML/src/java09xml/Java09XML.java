package java09xml;

public class Java09XML {

    public static void main(String[] args) {
        // Crea XML
        CreaXML mixml = new CreaXML();
        // Insertar libros con método
        //myxml.insertBook("2971", "Iliada", "Homero", 2005);
        //myxml.insertBook("4588", "El camino", "M Delibes", 1971);
        // Insertar libros por teclado
        mixml.insertPorTeclado();
        // Guardar
        mixml.save("mislibros");
        // Objeto que lee XML y lo muestra en pantalla
        LeerXML leexml = new LeerXML();
        leexml.leer("mislibros");
    } 
}
