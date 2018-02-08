package java09xml;

import java.io.Serializable;

public class Book implements Serializable{
    // Atributos
    private String code;
    private String titulo;
    private String autor;
    private int fechapub;

    // Constructor
    public Book(String co, String titu, String aut, int fecp){
        this.code = co;
        this.titulo = titu;
        this.autor = aut;
        this.fechapub = fecp;
    }
    
    // Método para mostrar contenido
    @Override
    public String toString() {
        return "Book {" + "code = " + code + ", titulo = " + titulo +
            ", autor = " + autor + ", fechapub = " + fechapub + '}';
    }   
}
