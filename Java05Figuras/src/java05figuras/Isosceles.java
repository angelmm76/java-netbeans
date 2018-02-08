package java05figuras;

public class Isosceles extends Triangulo{
    public int base;
    public int lado;
    
    // Constructor
    public Isosceles(int base, int lado, String color){
        this.base = base;
        this.lado = lado;
        this.color = color;
        esregular = false;
        tipo = "ISOS";
    }
    
    // Método
    public void perimetro() {
        System.out.println("Perimetro de isosceles " + (base + 2*lado));
    }
    public void area(){
        System.out.println("Area aproximada de isosceles " + (base*lado/2));
    }
    public void color(){
        System.out.println("Triangulo isosceles de color " + color);
    }
    public void hablar() {
        System.out.println("Soy un isosceles (tipo " + tipo + "), ¿regular? " 
                + esregular +  ", de bonito color " + color +
                " y base " + base);
    }
    
}
