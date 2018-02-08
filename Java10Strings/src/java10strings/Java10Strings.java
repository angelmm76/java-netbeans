package java10strings;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java10Strings {
    private static Scanner leer; 

    public static void main(String[] args) {
        leer = new Scanner(System.in);
        metodoscadenas();
        //cadenapuntero();
        expregular();
    }
    
    private static void metodoscadenas(){
        // Métodos con cadenas  
        String[] arcad = new String[18];
        System.out.print("Introducir palabra nº 1: ");
        String palabra1 = leer.nextLine();
        System.out.print("Introducir palabra nº 2: ");
        String palabra2 = leer.nextLine();
        
        arcad[0] = palabra1.toUpperCase();
        arcad[1] = palabra1.toLowerCase();
        arcad[2] = palabra1.concat(palabra2);
        arcad[3] = palabra1.replace("a", "pico");
        arcad[4] = String.valueOf(palabra1.length());
        arcad[5] = palabra1.substring(1);
        arcad[6] = palabra1.substring(1,4);
        arcad[7] = String.valueOf(palabra1.indexOf("a"));
        arcad[8] = String.valueOf(palabra1.charAt(3));
        arcad[9] = String.valueOf(palabra1.compareTo(palabra2));
        arcad[10] = String.valueOf(palabra1.contains(palabra2));
        arcad[11] = palabra1.trim();
        arcad[12] = String.valueOf(palabra1.equals(palabra2));
        arcad[13] = String.valueOf(palabra1.startsWith(palabra2));
        arcad[14] = String.valueOf(palabra1.endsWith(palabra2));
        arcad[15] = palabra1.toCharArray().toString();
        arcad[16] = String.valueOf(palabra1.matches("^[a]*."));
        arcad[17] = new StringBuilder(palabra1).reverse().toString();
              
        for(String cad: arcad){
            System.out.println(cad);
        }
        
        System.out.println("Tokens:");
        //String[] mytokens = ArrayList<>();
        // Palabra1 es la cadena a dividir en tokens
        // Cada caracter de palabra2 es un delim, ej ",-* " serían cuatro delim
        StringTokenizer stk = new StringTokenizer(palabra1, palabra2);
        //stk = new StringTokenizer(palabra1); // delimitador espacio
        while(stk.hasMoreElements()){
            System.out.println(stk.nextToken());
        }        
    }
    
    private static void cadenapuntero(){
        String s1 = "abc";
        String s2 = s1; // mismo objeto, mismo puntero
        //s1 = "def";
        System.out.println(s1 + " " + s2);
        System.out.println(s2 == s1);  // true
        
        String s3 = "mno";
        String s4 = "mno"; // distinto objeto, distinto puntero, pero...
        System.out.println(s3 + " " + s4);
        System.out.println(s3 == s4);  // true? sí, pq se crearon con literales
        
        String s5 = new String("jkl");
        String s6 = new String("jkl"); // distinto objeto, distinto puntero
        System.out.println(s5 + " " + s6);
        System.out.println(s5 == s6);  // false, pq se crearon con constructores
    }
    
    private static void expregular(){
        Matcher mat;
        Pattern pat;
        
        System.out.print("Introducir cadena: ");
        String cadena1 = leer.nextLine();
        //System.out.print("Introducir palabra nº 2: ");
        //String palabra2 = leer.nextLine();
        
        pat = Pattern.compile("[0-9]{2,7}");  // Entre 2 y 7 nºs
        pat = Pattern.compile("[A-Z]{1,4}");  // Entre 1 y 4 letras mayus
        pat = Pattern.compile("^[A-Z]{1,2}.*");  // Inicio 1 y 2 letras mayus
        pat = Pattern.compile("^[RF].*");  // Inicio R o F
        //pat = Pattern.compile("^[0-9]{0}.*");  // No inicio con nºs??? MAL
        pat = Pattern.compile("[0-9]{5}");  // 5 nºs
        pat = Pattern.compile(".*[A-Z]$");  // Acaba en letra mayus
        pat = Pattern.compile("[0-5][0-9]{4}");  // 5 nºs, el primero hasta 5
        pat = Pattern.compile("([0-5][1-9][0-9]{3})|([1-5][0-9]{3})");  // Dos patrones
        pat = Pattern.compile("[6,9][0-9]{8}");  // nº telef inicia por 6 o 9
        pat = Pattern.compile("([6,9][0-9]{8})|([0-9]{3,5})");  // nº telef
        pat = Pattern.compile(
                "([12]{0,1}[1-9]{0,1}[1-9])|([12]{0,1}[1-9][0-9])" + 
                "\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");  // direc IP
        
        mat = pat.matcher(cadena1);
        System.out.println(mat.matches() ? "Si" : "No");
        //System.out.println(pat.matcher(palabra1).matches() ? "Si" : "No");
    }
}
