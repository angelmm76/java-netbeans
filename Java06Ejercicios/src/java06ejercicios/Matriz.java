package java06ejercicios;

import java.util.Scanner;

public class Matriz {
    // Atributos
    private int nfil;
    private int ncol;
    private int[][] mat;
    private static Scanner leer;
    
    // Constructor
    public Matriz (){
        leer = new Scanner(System.in);
        
        System.out.print("Introducir nº de filas de la matriz: ");
        int f = leer.nextInt();
        System.out.print("Introducir nº de columnas de la matriz: ");
        int c = leer.nextInt();
        
        this.nfil = f;
        this.ncol = c;
        mat = new int[f][c];
        
        // Introducir datos
        for (int i = 0; i < nfil; i++) {
            for (int j = 0; j < ncol; j++){
                System.out.print("Introducir elemento fila " + i + 
                    ", columna " + j + ": ");
                mat[i][j] = leer.nextInt();
            }
        }
    }
    
    public Matriz (int[][] arr) {
        this.nfil = arr.length;
        this.ncol = arr[0].length;
        mat = arr.clone();
    }
    
    //Métodos
    public Matriz traspuesta(){
        // Trasponer
        int[][] tras = new int[this.ncol][this.nfil];
        for (int i = 0; i < this.ncol; i++) {
            for (int j = 0; j < this.nfil; j++){
                tras[i][j] = this.mat[j][i];
            }
        }
        Matriz mt = new Matriz(tras);
        return mt;
    }
    
    public Matriz suma(Matriz otram){
        // Sumar
        if ((this.nfil == otram.nfil) && (this.ncol == otram.ncol)){
            int[][] suma = new int[this.nfil][this.ncol];
            for (int i = 0; i < this.nfil; i++) {
                for (int j = 0; j < this.ncol; j++){
                    suma[i][j] = this.mat[i][j] + otram.mat[i][j];
                }
            }
            Matriz sumat = new Matriz(suma);
            return sumat;
        }
        else {
            System.out.println("No se realizó la suma, tamaños no compatibles");
            return null;
        }
    }
    
    public int[] sumafila(){
        int[] suma = new int[this.nfil];
        System.out.println("Vector suma:");
        for (int i = 0; i < this.nfil; i++) {
            for (int j = 0; j < this.ncol; j++){
                suma[i] += this.mat[i][j];
            }
            System.out.println(suma[i]);
        }
        return suma;
    }
    
    public void mostrar(){
        if(this != null) {
            System.out.println("Valores de matriz:");
            for (int i = 0; i < nfil; i++) {
            String fila = "";
                for (int j = 0; j < ncol; j++){
                    fila += this.mat[i][j] + ", ";
                }
                System.out.println(fila);
            } 
        }
        else {
           System.out.println("Matriz null"); 
        }
    }
    
    public int[][] getArray(){
        return this.mat;
    }
}
