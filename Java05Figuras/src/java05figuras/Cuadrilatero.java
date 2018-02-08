package java05figuras;

public class Cuadrilatero extends Figura{
    
    public Cuadrilatero(){
        nlados = 4;
    }
    
    // Atributos
    public String familia;
    public boolean ladosiguales;
    
    // Métodos
    public void hablar() {
        System.out.println("Soy un cuadrilatero");
    }
}
