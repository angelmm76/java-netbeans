package java05figuras;

public class Triangulo extends Figura{
    
    public Triangulo() {
        nlados = 3;
    }
    
    // Atributos
    public String tipo;
    public boolean esregular;
    
    // Métodos
    public void hablar() {
        System.out.println("Soy un triangulo");
    }
    
}
