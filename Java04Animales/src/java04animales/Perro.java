package java04animales;

public class Perro extends Mamiferos {
    // Constructor
    public Perro(){
        npatas = 4;
        naletas = 0;
        cites = 5;
        longevidad = 12;
        
    }
    
    // Método
    public void respirar() {
        System.out.println("Yo, perro, respiro por pulmones");
    }
    public void nacer(){
        System.out.println("Yo, perro, nazco en camadas");
    }
    public void comer(){
        System.out.println("Yo, perro, como huesos");
    }
    public void desplazar(){
        System.out.println("Yo, perro, corro a cuatro patas");
    }
    
}
