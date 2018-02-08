package java04animales;

public class Salmon extends Peces {
    // Constructor
    public Salmon(){
        naletas = 8;
        dulceacuicola = true;
        longevidad = 2;
        cites = 4;
    }
    
    // Método
    public void respirar() {
        System.out.println("Yo, salmón, respiro por branquias");
    }
    public void nacer(){
        System.out.println("Yo, salmón, nazco en piscifactorías");
    }
    public void comer(){
        System.out.println("Yo, salmón, como pienso");
    }
    public void desplazar(){
        System.out.println("Yo, salmón, nado a contracorriente con mis " +
                naletas + " aletas");
    }
}
