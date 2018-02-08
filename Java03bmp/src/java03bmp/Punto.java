package java03bmp;

// Clase pixel de BMP con tres colores
public class Punto {
    // Atributos, los valores de pixel de cada color
    public byte red, green, blue;
    
    // Constructor con parámetros
    public Punto(byte r, byte g, byte b){
        red = r;
        green = g;
        blue = b;
    }
    
    // Constructor sin parámetros (valor por defecto)
    public Punto(){
        red = 0;
        green = 0;
        blue = 0;
    }
    
}
