package java05figuras;

public class Rombo extends Cuadrilatero{
     public int lado;
    
    // Constructor
    public Rombo(int lado, String color){
        this.lado = lado;
        this.color = color;
        ladosiguales = true;
        familia= "ROMBO";
        area = 4*lado*lado/5;
    }
    
    // Método
    @Override
    public void perimetro() {
        System.out.println("Perimetro de rombo " + 4*lado);
    }
    public void area(){
        System.out.println("Area de rombo " + area);
    }
    public void color(){
        System.out.println("Rombito de color " + color);
    }
    public void hablar() {
        System.out.println("Soy un rombo (familia " + familia  + 
                ") ¿lados iguales? " + ladosiguales + 
                ", de bonito color " + color + " y lado " + lado);
    }
    public int getRomboArea(){
        return area;
    }
}
