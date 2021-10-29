
package clases;


public class validacion {

    public static boolean validar_Numero(String contenido) {

        try {
            if (contenido != null) {
                Double.parseDouble(contenido);
            }
        } catch (NumberFormatException e) {

            return false;

        }
        return true;
    }

    public boolean validar_Entero(String contenido) {

        try {
            if (contenido != null) {
                Integer.parseInt(contenido);
            }
        } catch (NumberFormatException e) {
            return false;

        }
        return true;
    }

    public boolean salirDelJuego(String ingreso ) {
        
        boolean salida = false;
            if(ingreso.equalsIgnoreCase("salir")){
                salida= true;
            }
        return salida;
    }
}
