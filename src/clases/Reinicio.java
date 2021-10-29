
package clases;


public class Reinicio extends Tirar_Dados {

    private boolean salir;
    private int cont;

    public String repetir_juego(String respuesta) {
        String salida;

        switch (respuesta) {
            case "SI":
                salida = "SI";
                salir = false;
                cont = 10;
                break;
            case "NO":
                salida = "";
                salir = true;
                break;
            default:
                salida = "repetir";
                System.out.println("Ingrese 'si' o 'no'");
        }

        return salida;
    }

    public boolean getSalir() {
        return salir;
    }
    public int getContador(){
        return cont;
    }

}
