package java05figuras;

public class Java05Figuras {

    public static void main(String[] args) {
        Isosceles luis = new Isosceles(14, 20, "verde");
        luis.hablar();
        luis.perimetro();
        luis.area();
        
        Equilatero antonio = new Equilatero(25, "gris");
        antonio.hablar();
        antonio.perimetro();
        antonio.area();
        
        Cuadrado chus = new Cuadrado(10, "amarillo");
        chus.hablar();
        chus.perimetro();
        System.out.println(chus.getArea());
        
        Rombo ramon = new Rombo(13, "fucsia");
        ramon.hablar();
        System.out.println(ramon.getRomboArea());
        
        //System.out.println(chus.lado); // Error pq lado es private en Cuadrado
        System.out.println(ramon.lado); // OK pq lado es public en Rombo
        
        // Array de figuras
        Figura[] panda = new Figura[4]; 
        panda[0] = new Cuadrado(66, "rosa");
        panda[1] = new Equilatero(32, "cyan");
        panda[2] = new Isosceles(24, 44, "blanco");
        panda[3] = new Equilatero(18, "rojo");
        
        for (int i = 0; i < 4; i++){
            // System.out.println("Figura nº " + i +  " de la panda");
            panda[i].color();
            panda[i].perimetro();
        }
        
        // Array de triangulos
        Triangulo[] tris = new Triangulo[5]; 
        tris[0] = new Isosceles(23, 45, "verde encina");
        tris[1] = new Equilatero(14, "azure");
        tris[2] = new Isosceles(29, 34, "naranja");
        tris[3] = new Equilatero(19, "marron");
        tris[4] = new Equilatero(41, "verde lechuga");
        
        System.out.println("\nArray de triangulos...");
        for (int i = 0; i < 5; i++){
            //System.out.println("Triangulo nº " + i + " de la tris");
            tris[i].hablar();
        }
    }
}
