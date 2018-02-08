package java01hola;

public class Java01Hola {
    // Variables enum
    enum semana {lunes, martes, miercoles, jueves,
            viernes, sabado, domingo}

    public static void main(String[] args) {
        // Imprimir en pantalla
        System.out.println("Hola mundo");
        // Variables locales
        int prueba1 = 3;  
        System.out.println(prueba1);
        String name = "Chus";
        System.out.println(name + " es el nº " + prueba1);
        System.out.println(name.toLowerCase());
        System.out.println(name.indexOf("s"));
        System.out.println(name.charAt(1));
        int prueh = 0x4A3;  // Entero hexadecimal
        System.out.println(prueh + " hex> " + Integer.toHexString(prueh) +
                " bin> " + Integer.toBinaryString(prueh));
        boolean resp = true;
        System.out.println(resp);
        semana diaSemana = semana.lunes;
        System.out.println(diaSemana);
        // Operadores entre bits
        int prueba2 = 1337777991;
        System.out.println("prueba2 bin> " + Integer.toBinaryString(prueba2));
        int resul;
        resul = prueba2 << 3;  // Desplazar tres bits sin acarreo
        System.out.println("resul bin> " + Integer.toBinaryString(resul));
        System.out.println(prueba2 + " acarreo> " + resul);
        resul = ~prueba2;  // Invertir bits
        System.out.println(Integer.toBinaryString(resul));
        System.out.println(prueba2 + " invertido> " + resul);
        resul = prueba1 & prueba2;
        System.out.println("AND bit a bit> " + Integer.toBinaryString(resul));
        resul = prueba1 | prueba2;
        System.out.println("OR bit a bit> " + Integer.toBinaryString(resul));
        resul = prueba1 ^ prueba2;
        System.out.println("XOR bit a bit> " + Integer.toBinaryString(resul));
        // Short if
        resul = (prueba1 < prueba2)? prueba1 : prueba2;
        System.out.println(resul);
        // Incremento
        resul++;
        System.out.println(resul);
        resul = ++prueba2;
        System.out.println(resul);
    }   
}
