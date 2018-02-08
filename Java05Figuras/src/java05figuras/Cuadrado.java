package java05figuras;

public class Cuadrado extends Cuadrilatero{
    private int lado;
    
    // Constructor
    public Cuadrado(int lado, String color){
        this.lado = lado;
        this.color = color;
        ladosiguales = true;
        familia= "CUAD";
        area = lado*lado;
    }
    
    // Método
    @Override
    public void perimetro() {
        System.out.println("Perimetro de cuadrado " + 4*lado);
    }
    public void area(){
        System.out.println("Area de cuadrado " + area);
    }
    public void color(){
        System.out.println("Cuadrado de color " + color);
    }
    public void hablar() {
        System.out.println("Soy un cuadrado (familia " + familia  + 
                ") ¿lados iguales? " + ladosiguales + 
                ", de bonito color " + color + " y lado " + lado);
    }
    public int getArea(){
        return area;
    }
}
