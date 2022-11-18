package lab6p1_víctorromero;

import java.util.Scanner;
import java.util.Random;

public class Lab6P1_VíctorRomero {

    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();

    public static void main(String[] args) {
        System.out.println("Victor Romero - 12211079");

        int opcion;

        do {
            System.out.println("_____________________________________________________________ ");
            System.out.println(" ");
            System.out.println(">> MENU <<");
            System.out.println("----------------------- ");

            System.out.println("1 -> EJERCICIO 1 - TURING");
            System.out.println("2 -> EJERCICIO 2 - ");

            System.out.println("3 -> SALIDA");
            System.out.println(" ");
            System.out.println(" ");

            System.out.print("Ingrese su Opcion: ");
            opcion = leer.nextInt();
            System.out.println("=> La Opcion escojida es: " + opcion);
            System.out.println(" ");

            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese el tamano del Arreglo: ");
                    int tam = leer.nextInt();
                    // int[] numeros = new int[tam];
                    int[] numeros = lectura(tam);

                    imprimir(numeros);
                    System.out.println(" ");

                    System.out.print(">> Ingrese la cadena de instrucciones: ");
                    String cadena = leer.next();
                    String cadena2 = cadena.toUpperCase();

                    boolean repetir = true;

                    for (int i = 0; i < cadena2.length(); i++) {
                        char letra = cadena2.charAt(i);
                        if (letra == 'R' || letra == 'L' || letra == 'X') {
                            repetir = true;
                        } else {
                            repetir = false;
                            break;
                        }
                    }

                    if (repetir) {
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println(">> LA CADENA RESULTANTE ES: " + chain(cadena2, tam, numeros));

                    } else {
                        System.out.print(">> Ingrese la cadena de instrucciones: ");
                        cadena = leer.next();
                        cadena2 = cadena.toUpperCase();
                    }
                }
                break;

                case 2: {
                    System.out.print(">> Ingrese el primer numero: ");
                    int numero = leer.nextInt();

                    System.out.println("Arreglo: ");
                    imprimir(Arreglo1(numero));
                    System.out.println(" ");
                    System.out.println(">> El Arreglo Ordenando Ascendente: ");
                    imprimir(Orden(numero));
                    System.out.println(" ");
                    System.out.println(">> El Arreglo Ordenando Descendente: ");
                    imprimir(Orden2(Orden(numero)));
                    System.out.println(" ");
                }
            }

        } while (opcion != 6);
    }

    public static int[] lectura(int tam) {
        int[] temporal = new int[tam];

        // LENGTH ARREGLO NO LLEVA PARENTESIS
        for (int i = 0; i < temporal.length; i++) {
            temporal[i] = aleatorio.nextInt(10);
        }
        return temporal;
    }

    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]" + " ");
        }
    }

    public static String chain(String cadena, int tam, int[] temporal) {

        String arreglo = "";
        int cont = 0;
        imprimir(temporal);

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == 'R') {
                cont++;
            } else if (cadena.charAt(i) == 'L') {
                cont--;
            } else if (cadena.charAt(i) == 'X') {
                arreglo += temporal[cont];
                // System.out.println(arreglo );
            }

        }

        return arreglo;
    }

    public static int[] Arreglo1(int numero) {
        String numeros2 = Integer.toString(numero);
        int[] temporal = new int[numeros2.length()];
        for (int i = 0; i < temporal.length; i++) {
            char tempo = numeros2.charAt(i);
            temporal[i] = (int) tempo - 48;
        }
        return temporal;
    }

    public static int[] Orden(int numero) {

        String numeros2 = Integer.toString(numero);
        int[] temporal = new int[numeros2.length()];
        for (int i = 0; i < temporal.length; i++) {
            char tempo = numeros2.charAt(i);
            temporal[i] = (int) tempo - 48;
        }
        int auxiliar = 0;

        for (int v = 0; v < temporal.length; v++) {
            for (int j = 0; j < temporal.length; j++) {
                if (temporal[v] < temporal[j]) {
                    auxiliar = temporal[v];
                    temporal[v] = temporal[j];
                    temporal[j] = auxiliar;
                }
            }
        }

        return temporal;
    }

    public static int[] Orden2(int[] orden) {

        System.out.println("hola");
        int[] temporal = new int[orden.length];

        int auxiliar = 0;

        /*
        Basicamente tomamos el valor que ya esta ordenado numericamente
        de manera ascendente, que esta ordenado en el metodo anterior
        (tomamos un for que vaya recorriendo digit-by-digit) de este modo
        solamente invertimos los valores con el orden de length restandole 1 y el
        valor cambiante de i... 
        Ahora el cambio solamente se invierte los valores ya ordenados
         */
        for (int i = 0; i < orden.length; i++) {
            temporal[i] = orden[orden.length - 1 - i];
        }
        return temporal;
    }

    public static int kaprekar(int[] orden) {
        String arreglo1="";
        
        for (int i = 0; i < orden.length; i++) {
            arreglo1+=orden;
        }
        
        int numeros=0;
        numeros=Integer.parseInt(arreglo1);
        
    return numeros;
    }
}
