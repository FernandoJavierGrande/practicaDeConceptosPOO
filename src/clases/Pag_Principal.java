package clases;

import java.util.Scanner;

public class Pag_Principal {

    public static void main(String[] args) {

        boolean cerrar = false;
        String seleccion = "";

        Scanner entrada = new Scanner(System.in);
        Adivinar_Numero ad_num = new Adivinar_Numero();
        Tirar_Dados tir_dados = new Tirar_Dados();

        System.out.println("¡Bienvenido al juego 2 x 1!");

        do {

            System.out.println("***********************************************");
            System.out.println("Presione -1- para jugar 'Adivinar numero'. ");
            System.out.println("Presione -2- para jugar 'Tirar dados'. ");
            System.out.println("Presione -0- para salir. ");
            System.out.println("***********************************************");

            seleccion = entrada.nextLine().trim();

            switch (seleccion) {
                case "0":
                    cerrar = true;
                    System.out.println("Cerrando. Hasta luego.");
                    break;
                case "1":
                    ad_num.adivinar();
                    System.out.println("\n¡Gracias por jugar!");
                    break;
                case "2":
                    tir_dados.tirar();
                    System.out.println("\n¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("\nComando incorrecto\n");
            }

        } while (cerrar == false);

    }

}
