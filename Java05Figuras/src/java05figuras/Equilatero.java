package java05figuras;

public class Equilatero extends Triangulo {
    public int lado;
    
    // Constructor
    public Equilatero(int lado, String color){
        this.lado = lado;
        this.color = color;
        esregular = true;
        tipo = "EQUI";
    }
    
    // Método
    @Override
    public void perimetro() {
        System.out.println("Perimetro de equilatero " + 3*lado);
    }
    public void area(){
        System.out.println("Area aproximada de equilatero " + (lado*lado/2));
    }
    public void color(){
        System.out.println("Triangulo equilatero de color " + color);
    }
    public void hablar() {
        System.out.println("Soy un equilatero (tipo " + tipo + "), ¿regular? " 
                + esregular +  ", de bonito color " + color +
                " y lado " + lado);
    }
}
