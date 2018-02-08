package java02arrays;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Java02Arrays {
    static Random ran;

    public static void main(String[] args) {
        int nElementos = 21;
        System.out.println("Array 1D: " + nElementos + " elementos");
        // Declaración, y reserva de memoria, de array de enteros
        int[] myarray = new int[nElementos];
        int i; // contador
        ran = new Random(59);
        
        // Asignar valores
        System.out.println("Asignar valores:");
        for(i=0; i<nElementos; i++){
            System.out.print("m[" + i + "] ");
            myarray[i]= 3*i + 11;
            //myarray[i]= ran.nextInt(100);
        }
        
        // Ver valores
        System.out.println("\nVer valores:");
        for(i=0; i<nElementos; i++)
            System.out.print(myarray[i] + " ");
        
        // Array 2D
        int nfilas = 3, ncols = 4;
        System.out.println("\nArray 2 dimensiones: " + nfilas + "x" + ncols);
        float[][] arr2d= new float[nfilas][ncols]; // Declarar array 2d
        int k, l; // contadores
        
        // Asignar valores
        System.out.println("Asignar valores:");
        for(k=0; k<nfilas; k++)
            for(l=0; l<ncols; l++){
                System.out.print("m[" + k + "][" + l + "] ");
                arr2d[k][l]= 50*ran.nextFloat();
            }
        
        // Ver valores
        float sumafila;
        System.out.println("\nVer valores:");
        for(k=0; k<nfilas; k++){
            sumafila = 0;
            for(l=0; l<ncols; l++){
                sumafila += arr2d[k][l];
                System.out.print(arr2d[k][l] + "\t");
            }
            System.out.println("-> Suma fila " + k + ": " + sumafila);
         }
        //System.out.println("\nlengths " + myarray.length + " " + arr2d.length);
        
        Scanner leer = new Scanner(System.in);
        int num;
        System.out.print("Introducir nº: ");
        //num = leer.nextInt();
        //System.out.println("El doble de tu nº es " + 2*num);
        
        // Array lists
        System.out.println("\nEsto es un arraylist de floats:");
        Arrlis al = new Arrlis();
        al.relle(8);
        
        colasypilas();
        
    }
    
    private static void colasypilas () {
        // "La cola se lee por el final FIFO" 
        // (pero los elementos de esta clase siguen el orden natural)
        Queue<Integer> enterosq = new PriorityQueue<Integer>();
        // La pila se lee por el ppio LIFO
        Stack<Integer> enterost = new Stack<Integer>(); 
        
        for (int i = 0; i < 5; i++){
            int num = ran.nextInt(100);
            //System.out.print(" " + num);
            enterosq.add(num);
            enterost.add(num);
        }
        
        //System.out.println("Cola " + enterosq.toString());
        //System.out.println("Pila " + enterost.toString());
        
        for (int i = 0; i < 5; i++){
//            System.out.print("Tamaños de cola y pila: " + enterosq.size() +
//                    " " + enterost.size());
            System.out.println("De cola " + enterosq.poll() + 
                    " y de pila " + enterost. pop());
        }
    }

}
