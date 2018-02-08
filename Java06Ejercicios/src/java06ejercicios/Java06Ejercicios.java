package java06ejercicios;

import java.util.Scanner;
import java.lang.Math;

public class Java06Ejercicios {
    private static Scanner leer;

    public static void main(String[] args) {
        leer = new Scanner(System.in);
        
        //leernumsumar();
        //factorial();
        //invertircadena();
        //numeropalabra();
        //elementoscomunes();
        //buscarminimo();
        //resolvereq2();
        //trasponermatriz();
        //cambiacolmatriz();
        //calculocomplejo();
        //adivina();
        //verAscii();
        valorref();
        //metodosdematriz();
    }
    
    private static void leernumsumar(){
        // Sumar dígitos de números de tres cifras
        System.out.print("Introducir un número de tres dígitos: ");
        int num;
        num = leer.nextInt();
        int suma;
        suma = num/100 + (num/10)%10 + num%10;
        System.out.println("La suma de los dígitos es " + suma);
    }
    
    private static void factorial(){
        // Calcular factorial
        System.out.print("Introducir un número entero: ");
        int num;
        num = leer.nextInt();
        int fact = 1;
        int cont = 1;
        while (cont <= num){
            fact *= cont;
            cont += 1;
        }
        System.out.println("Su factorial es " + fact);
    }
    
    private static void invertircadena(){
        // Invertir cadena
        System.out.print("Introducir una palabra: ");
        String word;
        word = leer.next();
        int len = word.length();
        char[] wordarray = new char[len];
        
        for (int i = 0; i < len; i++) {
            wordarray[i] = word.charAt(len - i - 1);

        }
        
        String rword = new String(wordarray);
        System.out.println("Al revés es " + rword);
    }
    
    private static void espalindromo(){
        // Saber si es palindromo
        System.out.print("Introducir una palabra: ");
        String word;
        word = leer.next();
        int len = word.length();
        char[] wordarray = new char[len];
        
        for (int i = 0; i < len; i++) {
            wordarray[i] = word.charAt(len - i - 1);

        }
        
        String rword = new String(wordarray);
        System.out.println("Al revés es " + rword);
    }
    
    private static void numeropalabra(){
        // De nº a palabra
        System.out.print("Te diré qué nº es. Introduce un nº: ");
        int num;
        num = leer.nextInt();
        String res;
        
        switch(num) {
            case 1: 
                res = "Es el uno";
                break;
            case 2:
                res = "Es el dos";
                break;
            case 3:
                res = "Es el tres";
                break;
            case 4:
                res = "Es el cuatro";
                break;
            case 5:
                res = "Es el cinco";
                break;
            default:
                res = "Es un nº desconocido para mí";
                break;
        }
       
        System.out.println(res);
    }
    
    private static void elementoscomunes() {
        // Elementos comunes de arrays
        int[] arr1 = new int[4];
        int[] arr2 = new int[4];
        String comun = "";
        
        for (int i = 0; i < arr1.length; i++){
            System.out.print("Introducir elemento " + i + " de array 1: ");
            arr1[i]= leer.nextInt();
        }
        
        for (int i = 0; i < arr2.length; i++){
            System.out.print("Introducir elemento " + i + " de array 2: ");
            arr2[i]= leer.nextInt();
        }
        
        for (int i = 0; i < arr1.length; i++){
            if(arr1[i]==arr2[i]) comun += " " + i + ", ";
        }
        
        System.out.println("Posiciones comunes: " + comun);
        
    }
    
    private static void buscarminimo (){
        // Buscar mínimo en array
        int[] arr1 = new int[5];
        int minimo;
        
        for (int i = 0; i < arr1.length; i++){
            System.out.print("Introducir elemento " + i + " de array: ");
            arr1[i]= leer.nextInt();
        }
        
        minimo = arr1[0];
        for (int i = 1; i < arr1.length; i++){
            if (arr1[i] < minimo) minimo = arr1[i];
        }
        
        System.out.println("El mínimo es: " + minimo);
    }
    
    private static void resolvereq2 () {
        // Resolver ecuación de 2º grado
        double a, b, c, discr;
        double raiz1, raiz2;
        System.out.print("Introducir coef x2 (a): ");
        a = leer.nextFloat();
        System.out.print("Introducir coef x (b): ");
        b = leer.nextFloat();
        System.out.print("Introducir término indpte (c): ");
        c = leer.nextFloat();
        discr = b*b - 4*a*c;
        
        if(discr < 0){
            System.out.println("No existen raices reales");
        }
        else{
            raiz1 = (-b + Math.sqrt(discr))/(2*a);
            raiz2 = (-b - Math.sqrt(discr))/(2*a);
            System.out.println("Raices: " + raiz1 + " y " + raiz2);
        }
    }
       
    private static void trasponermatriz(){
        // Trasponer matriz
        int nfil, ncol;
        System.out.print("Introducir nº de filas de la matriz: ");
        nfil = leer.nextInt();
        System.out.print("Introducir nº de columnas de la matriz: ");
        ncol = leer.nextInt();
        int[][] mat = new int[nfil][ncol];
        
        // Introducir datos
        for (int i = 0; i < nfil; i++) {
            for (int j = 0; j < ncol; j++){
                System.out.print("Introducir elemento fila " + i + 
                    ", columna " + j + ": ");
                mat[i][j] = leer.nextInt();
            }
        }
        
        // Trasponer
        int[][] tras = new int[ncol][nfil];
        for (int i = 0; i < ncol; i++) {
            for (int j = 0; j < nfil; j++){
                tras[i][j] = mat[j][i];
            }
        }
        
        // Mostrar matriz inicial
        System.out.println("Matriz inicial:");
        for (int i = 0; i < nfil; i++) {
            String fila = "";
            for (int j = 0; j < ncol; j++){
                fila += mat[i][j] + ", ";
            }
            System.out.println(fila);
        }
        
        // Mostrar matriz traspuesta
        System.out.println("Matriz traspuesta:");
        for (int i = 0; i < ncol; i++) {
            String fila = "";
            for (int j = 0; j < nfil; j++){
                fila += tras[i][j] + ", ";
            }
            System.out.println(fila);
        }
        
    }
    
     private static void metodosdematriz(){
        // Crear matriz
        Matriz mat = new Matriz();
        // Mostrarla
        mat.mostrar();
        //Suma de filas
        mat.sumafila();
        // Traspuesta
        //mat.traspuesta().mostrar();
        // Traspuesta de traspuesta
        //mat.traspuesta().traspuesta().mostrar();
        // Sumar
        Matriz mat2 = new Matriz();
        mat2.mostrar();
        mat.suma(mat2).mostrar();
        // 
        
    }
    
    private static void cambiacolmatriz(){
        // Cambia primera columna de una matriz por la última
        int nfil, ncol;
        System.out.print("Introducir nº de filas de la matriz: ");
        nfil = leer.nextInt();
        System.out.print("Introducir nº de columnas de la matriz: ");
        ncol = leer.nextInt();
        int[][] mat = new int[nfil][ncol];
        
        // Introducir datos
        for (int i = 0; i < nfil; i++) {
            for (int j = 0; j < ncol; j++){
                System.out.print("Introducir elemento fila " + i + 
                        ", columna " + j + ": ");
                mat[i][j] = leer.nextInt();
            }
        }
        
        // Cambiar
        int[][] cambi = new int[nfil][ncol];
        for (int i = 0; i < nfil; i++) {
            for (int j = 0; j < ncol; j++){
                if (j==0){ // primera columna
                     cambi[i][j] = mat[i][ncol-1];
                }
                else if (j==ncol-1){ // ultima columna
                     cambi[i][j] = mat[i][0];
                }
                else {
                     cambi[i][j] = mat[i][j];
                }
            }
        }
        
        // Mostrar matriz inicial
        System.out.println("Matriz inicial:");
        for (int i = 0; i < nfil; i++) {
            String fila = "";
            for (int j = 0; j < ncol; j++){
                fila += mat[i][j] + ", ";
            }
            System.out.println(fila);
        }
        
        // Mostrar matriz cambiada
        System.out.println("Matriz cambiada:");
        for (int i = 0; i < nfil; i++) {
            String fila = "";
            for (int j = 0; j < ncol; j++) {
                fila += cambi[i][j] + ", ";
            }
            System.out.println(fila);
        }
        
    }
    
    private static void calculocomplejo(){
        // Cálculos con números complejos
        double a, b, c, d;
        System.out.print("Introducir parte real: ");
        a = leer.nextFloat();
        System.out.print("Introducir parte imaginaria: ");
        b = leer.nextFloat();
        Comple comp1 = new Comple(a, b);
        comp1.hablar();
        System.out.println("Primer nº: " + comp1.toString());
        
        System.out.println("Segundo número");
        System.out.print("Introducir parte real: ");
        c = leer.nextFloat();
        System.out.print("Introducir parte imaginaria: ");
        d = leer.nextFloat();
        Comple comp2 = new Comple();
        comp2.setReal(c);
        comp2.setImag(d);
        System.out.println("Segundo nº: " + comp2.toString());
        
        Comple suma = comp1.suma(comp2);
        System.out.println("\nSuma: " + suma.toString());
        Comple resta = comp1.resta(comp2);
        System.out.println("Resta: " + resta.toString());
        Comple mul = comp1.multi(comp2);
        System.out.println("Multi: " + mul.toString());
        Comple div = comp1.divi(comp2);
        System.out.println("Divi: " + div.toString());
        Comple cheqdiv = div.multi(comp2);
        System.out.println("Check -> div*comp2: " + cheqdiv.toString() + 
                ", comp1: " + comp1.toString());
    
    }
    
    private static void adivina(){
        // Adivina nº
        System.out.println("Piensa en un nº entre 0 y 100: ");
        
        int guess = 50;
        int ampli= 50;
        int resp = 9;
        while(resp != 0){
            System.out.println("Quizá sea el " + guess+ "?");
            System.out.print("Si tu nº es mayor pulsa 2, si es menor pulsa 1 " +
                    "y si es el correcto pulsa 0: ");
            resp = leer.nextInt();
            //preguess = guess;
            if (resp == 2){
                guess = guess + ampli/2;
            }
            else if (resp == 1){
                guess = guess - ampli/2;
                //guess = ;
            }
            ampli = ampli/2;
        }
        
        System.out.println("El número en el que pensaste es " + guess);
    }
    
    private static void verAscii(){
        // Ver ASCII de caracteres introducidos
        final char eof = (char)-1;  // caracter fin de fichero
        char car = 0;  // caracter nulo (\0)
        
        try {
            System.out.println("Introducir cadena de texto");
            System.out.println("(para terminar pulse Ctrl+Z):");
            while((car = (char)System.in.read()) != eof){
                if (car != '\r' && car != '\n')
                System.out.println("Código ASCII de " + car + 
                        " es " + (int)car);
                
                if(car == ' ') break;
            }
        }
        catch(Exception e){
            System.out.println("Ocurrió una excepción " + e.toString());
            e.printStackTrace();
        }
    }
    
    private static void valorref(){
        float[] af = new float[1];
        af[0] = 3;
        float pf = 5;
        System.out.println("Valores antes de llamada: array " + af[0] + 
                ", primitivo " + pf);
        llamada(af, pf);
        System.out.println("Valores despues de llamada: array " + af[0] + 
                ", primitivo " + pf);
    }
    
    private static void llamada(float n1[], float n2){
        n1[0] = n1[0] + 20;
        n2 = n2 + 20;
    }
    
}
