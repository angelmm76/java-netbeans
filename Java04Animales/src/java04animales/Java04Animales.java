package java04animales;

public class Java04Animales {

    public static void main(String[] args) {
        // Array de seres vivos
        Servivo[] natura = new Servivo[7]; 
        natura[0] = new Atun();
        natura[1] = new Salmon();
        natura[2] = new Mono();
        natura[3] = new Perro();
        natura[4] = new Gallo();
        natura[5] = new Halcon();
        natura[6] = new Aves();
        
        for (int i = 0; i < 7; i++){
            System.out.println("Ser vivo nº " + i + 
                    ", cites " + natura[i].cites + 
                    ", longevidad " + natura[i].longevidad);
            natura[i].comer();
            natura[i].desplazar();
            natura[i].nacer(); 
            natura[i].respirar();
        }
        
        Halcon chus = new Halcon();
        chus.desplazar();
        chus.hablar();
        
    }
    
}
