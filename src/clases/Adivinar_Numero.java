
package clases;

import java.util.Scanner;


public class Adivinar_Numero {

    private boolean entrada_correcta;

    private String caracter_ingresado, aux = "";
    private int numero, contador, num_secreto;

   
    public void adivinar() {
        
        contador=10;

        Scanner entrada = new Scanner(System.in);
        validacion validar = new validacion();          // instancio una clase que corobora que los datos sean numeros enteros

        System.out.println("Bienvenido a Adivina el numero, si puedes...\n");
        numAleat_Nuevo();

        do {
            /*bucle ppal se ejecuta min una vez, si entrada_correcta es false se volverá a ejecutar                                                                                     
            siempre y cuando contador>0. se rompe cuando se acaban los intentos (contador=0)*/

            if (aux.equalsIgnoreCase("SI")) {
                numAleat_Nuevo();
                aux = "";
            }

            caracter_ingresado = entrada.nextLine().trim();
            if (validar.salirDelJuego(caracter_ingresado) == true) {
                break;
            }
            entrada_correcta = validar.validar_Entero(caracter_ingresado);
            if (entrada_correcta == false) {
                System.out.println("Caracter no permitido. Ingrese nuevamente. ");
                System.err.println("Quedan " + contador + " intentos.");
            }

            while (entrada_correcta == true) {   // segundo bucle lo utilizo para parsear de forma segura el caracter_ingresdo luego de validado
                numero = Integer.parseInt(caracter_ingresado);

                if (numero > num_secreto) {      // estos if anidados guian la respuesta. "contador" disminuye un intento por cada vez que pasa
                    System.out.println("Es Menor a " + numero);
                    contador--;
                    System.err.println("Quedan " + contador + " intentos.");
                    entrada_correcta = false;       // aprovecho esta variable para repetir el bucle ppal
                } else if (numero < num_secreto) {
                    System.out.println("Es Mayor a " + numero);
                    contador--;
                    System.err.println("Quedan " + contador + " intentos.");
                    entrada_correcta = false;
                } else if (numero == num_secreto) {
                    contador--;
                    int intentos = (10 - contador);        // aca cuento los intentos que utilizó
                    if (intentos == 1) {                   // aca resuelvo que  quede la palabra intntos en plural si fue en uno solo
                        System.out.println("¡GANASTE en el primer intento!. El numero secreto era: " + num_secreto);
                        aux = "repetir";

                    } else {
                        System.out.println("¡GANASTE!. Despues de " + intentos + " intentos. El numero secreto era: " + num_secreto);
                        aux = "repetir";
                    }
                    break;                                  // salgo del bucle si ganó
                }
                if (contador == 0) {
                    System.out.println("Perdiste :(");
                    System.out.println("No tienes mas intentos!, juega nuevamente para ganar");
                    aux = "repetir";
                }
            }
            while (aux.equals("repetir")) {

                System.out.println("\n¿Desea volver a jugar?");
                aux = entrada.nextLine().toUpperCase().trim();

                Reinicio repetir = new Reinicio();

                aux = repetir.repetir_juego(aux);
                entrada_correcta = repetir.getSalir();
                contador = repetir.getContador();

            }
        } while (entrada_correcta == false && contador > 0);

    }

    private void numAleat_Nuevo() {
        num_secreto = n_aleatorio();
        System.out.println("Para salir al menú escriba 'salir' \n");
        System.out.println("!El numero secreto esta listo! \n");
        System.out.println("Ingresa un numero del 1 al 100 a ver si lo adivinas");
    }

    public int n_aleatorio() {

        int aleatorio = (int) (Math.random() * 100) + 1;

        return aleatorio;
    }
}
