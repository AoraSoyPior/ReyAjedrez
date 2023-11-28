package org.iesalandalus.programacion.reyajedrez;
import org.iesalandalus.programacion.utilidades.Entrada;
import java.util.InputMismatchException;

public class Consola {

    // Constructor privado para evitar instancias de la clase de utilidades
    private Consola() {
        // No se permite la creación de instancias
    }

    // Método para mostrar el menú principal
    public static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Crear rey por defecto");
        System.out.println("2. Crear rey eligiendo el color");
        System.out.println("3. Mover");
        System.out.println("4. Salir");
    }

    // Método para elegir una opción del menú
    public static int elegirOpcionMenu() {
        int opcion = 0;
        boolean opcionValida = false;

        do {
            try {
                System.out.print("Elige una opción: ");
                opcion = Entrada.entero();
                opcionValida = opcion >= 1 && opcion <= 4;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero.");
            }

            if (!opcionValida) {
                System.out.println("Error: Opción no válida. Inténtalo de nuevo.");
            }

        } while (!opcionValida);

        return opcion;
    }

    // Método para elegir un color
    public static Color elegirColor() {
        System.out.println("Elige un color:");
        System.out.println("1. Blanco");
        System.out.println("2. Negro");

        int opcion = elegirOpcionMenu();

        return (opcion == 1) ? Color.BLANCO : Color.NEGRO;
    }

    // Método para mostrar el menú de direcciones
    public static void mostrarMenuDirecciones() {
        System.out.println("Menú de Direcciones:");
        for (Direccion direccion : Direccion.values()) {
            System.out.println((direccion.ordinal() + 1) + ". " + direccion);
        }
    }

    // Método para elegir una dirección
    public static Direccion elegirDireccion() {
        System.out.println("Elige una dirección:");
        mostrarMenuDirecciones();

        int opcion = elegirOpcionMenu();

        return Direccion.values()[opcion - 1];
    }

    // Método para mostrar un mensaje de despedida
    public static void despedirse() {
        System.out.println("Gracias por jugar");
    }
}
