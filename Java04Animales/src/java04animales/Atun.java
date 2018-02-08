package java04animales;

public class Atun extends Peces {
    // Constructor
    public Atun() {
        naletas = 7;
        dulceacuicola = false;
        cites = 3;
    }
    
    // Atributo
    public String tipo;
    
    // Método
    public void respirar() {
        System.out.println("Yo, atún, respiro por branquias");
    }
    public void nacer(){
        System.out.println("Yo, atún, nazco en huevos");
    }
    public void comer(){
        System.out.println("Yo, atún, como sardinas");
    }
    public void desplazar(){
        System.out.println("Yo, atún, nado sin descanso con " + naletas +
                " aletas");
    }
}
