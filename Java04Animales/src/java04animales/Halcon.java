package java04animales;

public class Halcon extends Aves{
    // Constructor
    public Halcon(){
        vuela = true;
        cites = 2;
        tipoPico = "ganchudo";
        tipoPata = "garra";
        longevidad = 15;
    }
    
    // Método
    public void respirar() {
        System.out.println("Yo, halcón, respiro por pulmones mientras vuelo");
    }
    public void nacer(){
        System.out.println("Yo, halcón, nazco en las peñas");
    }
    public void comer(){
        System.out.println("Yo, halcón, como ratones con mi " + tipoPico + 
                " pico");
    }
    public void desplazar(){
        System.out.println("Yo, halcón, vuelo por lo alto");
    }
    public void hablar() {
        System.out.println("Soy un halcón y no soy de mucho hablar");
    }
    
}
