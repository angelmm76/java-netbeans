package java04animales;

public class Gallo extends Aves{
    
    // Constructor
    public Gallo(){
        vuela = false;
        cites = 8;
        tipoPico = "corto";
        tipoPata = "espolonada";
        longevidad = 4;
    }
    
    // Método
    public void respirar() {
        System.out.println("Yo, gallo, respiro por pulmones");
    }
    public void nacer(){
        System.out.println("Yo, gallo, nazco en un nido");
    }
    public void comer(){
        System.out.println("Yo, gallo, como pienso con mi " + tipoPico +
                " pico");
    }
    public void desplazar(){
        System.out.println("Yo, gallo, ando con mis patas " + tipoPata);
    }
    public void hablar() {
        System.out.println("Soy un gallo y canto cada mañana");
    }
    
}
