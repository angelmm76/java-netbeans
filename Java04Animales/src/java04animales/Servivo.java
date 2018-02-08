package java04animales;

// Clase abstracta, sólo para ser heredada (no instanciable)
public abstract class Servivo {
    // Constructor
    public Servivo() { }
    
    // Atributos
    public byte cites;
    public int longevidad;
    public String habitat;
    
    // Métodos "vacíos" para comprobar el polimorfismo de las clases hijos
    public void respirar () {
    }
    public void nacer() {
    }
    public void comer() {
    }
    public void desplazar() {
    }
    
}
