

package clases;

import java.util.Scanner;


public class Tirar_Dados {

    public int n_aleatorio() {

        int numero = (int) (Math.random() * 5) + 1;

        return numero;
    }

    public void tirar() {
        boolean salir = false;
        int j1_tiro1, j1_tiro2, j1_tiro3, j1_suma, j2_tiro1, j2_tiro2, j2_tiro3, j2_suma; // sintaxis de las variables jugador 1 tiro 1 , jugador 2 tiro 3 etc
        String jugador1, jugador2, aux;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido a Tirar los dados no es para cualquiera..");

        do {
            /* bucle ppal se ejecuta al menos una vez y vuelve a hacerlo siempre que-
             la variable salir sea igual a false*/

            System.out.println("Ingrese el nombre del jugador N° 1");                                   //en las siguentes lineas se "tiran" los dados se le asigna un num aleatorio entre 1 y 6
            jugador1 = entrada.nextLine().trim();

            if (jugador1.equals("")) {
                jugador1 = "Jugador 1";
            }

            j1_tiro1 = n_aleatorio();
            System.out.println("\n" + "Valor del dado en el tiro 1 de '" + jugador1 + "' = " + j1_tiro1);
            j1_tiro2 = n_aleatorio();
            System.out.println("Valor del dado en el tiro 2 de '" + jugador1 + "' = " + j1_tiro2);
            j1_tiro3 = n_aleatorio();
            System.out.println("Valor del dado en el tiro 3 de '" + jugador1 + "' = " + j1_tiro3);

            j1_suma = j1_tiro1 + j1_tiro2 + j1_tiro3;

            System.out.println("\n'" + jugador1 + "' suma " + j1_suma + " puntos.");

            System.out.println("Ingrese el nombre del jugador N° 2");
            jugador2 = entrada.nextLine().trim();

            if (jugador2.equals("")) {
                jugador2 = "Jugador 2";
            }
            while (jugador1.equalsIgnoreCase(jugador2)) {                //aca le asigno un numero extra en caso de que los nombres sean iguales para evitar eqivocaciones
                jugador1 = jugador1.concat("(1)");
                jugador2 = jugador2.concat("(2)");
            }

            j2_tiro1 = n_aleatorio();
            System.out.println("\n" + "Valor del dado en el tiro 1 de '" + jugador2 + "' = " + j2_tiro1);
            j2_tiro2 = n_aleatorio();
            System.out.println("Valor del dado en el tiro 2 de '" + jugador2 + "' = " + j2_tiro2);
            j2_tiro3 = n_aleatorio();
            System.out.println("Valor del dado en el tiro 3 de '" + jugador2 + "' = " + j2_tiro3);

            j2_suma = j2_tiro1 + j2_tiro2 + j2_tiro3;

            System.out.println("\n'" + jugador2 + "' suma " + j2_suma + " puntos.");

            if (j1_suma > j2_suma) {

                System.out.println("\nEl jugador '" + jugador1 + "' es el ganador! ");

            } else if (j1_suma < j2_suma) {

                System.out.println("\nEl jugador '" + jugador2 + "' es el ganador! ");

            } else if (j1_suma == j2_suma) {

                System.out.println("\nEmpate!!!.  Vuelve a jugar para desempatar!!!  ");
            }

            do {

                System.out.println("\n¿Desea voler a jugar 'tirar los dados no es para cualquera'? (SI/NO) "); // doy la opcion de volver a jugar y acoto las respuestas para evitar errores

                Reinicio repetir = new Reinicio();
                aux = entrada.nextLine().toUpperCase().trim();

                aux = repetir.repetir_juego(aux);
                salir = repetir.getSalir();

            } while (aux.equals("repetir"));

        } while (salir == false);

    }

}
