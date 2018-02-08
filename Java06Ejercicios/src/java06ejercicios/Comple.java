package java06ejercicios;

public class Comple {
    // Atributos
    private double a, b;
    //private double modulo, argumento;
    
    // Constructor
    public Comple () {
    }

    public Comple(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // Métodos
    public Comple suma(Comple y){
        Comple out = new Comple(this.a + y.a, this.b + y.b);
        return out;
    }

    public Comple resta(Comple y){
        Comple out = new Comple(this.a - y.a, this.b - y.b);
        return out;
    }
    
    public Comple multi(Comple y){
        Comple out = new Comple(this.a * y.a - this.b * y.b, 
                this.a * y.b + this.b * y.a);
        return out;
    }
    
    public Comple divi(Comple y){
        double d = y.a * y.a + y.b * y.b;
        Comple pre = this.multi(y.conjugado());
        Comple out = new Comple(pre.a / d, pre.b / d);
        return out;
    }
    
    public void setReal(double re){
        a = re;
    }
    
    public void setImag(double imag){
        b = imag;
    }

    public void hablar() {
        System.out.println("Soy un nº complejo: " + a + " + " + b + 
            "i (módulo " + modulo() + ", argum " +  argum() + "), " + 
            "conjugado " + conjugado());
    }
    
    public String toString() {
        return a + " + " + b + "i";
    }

    public Comple conjugado() {
        Comple conju = new Comple(this.a, -this.b);
        return conju;
    }
    
    public double modulo() {
        return Math.sqrt(a*a + b*b);
    }

    public double argum() {
        return 180. * Math.atan2(b, a) / Math.PI;
    }
    
}
