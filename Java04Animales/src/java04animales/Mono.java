package java04animales;

public class Mono extends Mamiferos{
    // Constructor
    public Mono() {
        npatas = 2;
        naletas = 0;
        cites = 5;
        longevidad = 30;
    }
    
    // Método
    public void respirar() {
        System.out.println("Yo, mono, respiro por pulmones como Tarzán");
    }
    public void nacer(){
        System.out.println("Yo, mono, nazco de la madre mona");
    }
    public void comer(){
        System.out.println("Yo, mono, como frutas");
    }
    public void desplazar(){
        System.out.println("Yo, mono, voy por los árboles con mis " + 
                npatas + " extremidades");
    }
    
}
