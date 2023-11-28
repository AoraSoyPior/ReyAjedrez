package org.iesalandalus.programacion.reyajedrez;
import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;
import org.iesalandalus.programacion.utilidades.Entrada;
import java.util.InputMismatchException;
import javax.naming.OperationNotSupportedException;
public class MainApp {
    private static Rey rey; // Atributo de clase Rey

    // Método para ejecutar la opción del menú
    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearReyDefecto();
                break;
            case 2:
                crearReyColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                mostrarRey();
                break;
            case 5:
                despedirse();
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
        }
    }

    // Método para crear un rey por defecto
    public static void crearReyDefecto() {
        rey = new Rey();
        System.out.println("Se ha creado un rey por defecto.");
    }

    // Método para crear un rey con color
    public static void crearReyColor() {
        Color colorElegido = elegirColor();
        rey = new Rey(colorElegido);
        System.out.println("Se ha creado un rey de color " + colorElegido + ".");
    }

    // Método para mover el rey
    public static void mover() {
        if (rey != null) {
            System.out.println("Menú de Direcciones:");
            mostrarMenuDirecciones();
            Direccion direccion = elegirDireccion();

            try {
                rey.mover(direccion);
                System.out.println("El rey se ha movido a la nueva posición: " + rey.getPosicion());
            } catch (OperationNotSupportedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Error: Debes crear un rey antes de intentar moverlo.");
        }
    }

    // Método para mostrar la información del rey
    public static void mostrarRey() {
        if (rey != null) {
            System.out.println("Información del Rey:");
            System.out.println("Color: " + rey.getColor());
            System.out.println("Posición: " + rey.getPosicion());
            System.out.println("Total de Movimientos: " + rey.getTotalMovimientos());
        } else {
            System.out.println("No hay un rey creado.");
        }
    }

    // Método principal (main) de la aplicación
    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = elegirOpcionMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 5);
    }

    // Métodos adicionales...

    private static int elegirOpcionMenu() {
        int opcion = 0;
        boolean opcionValida = false;

        do {
            try {
                System.out.print("Elige una opción: ");
                opcion = Entrada.entero();
                opcionValida = opcion >= 1 && opcion <= 5;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero.");
            }

            if (!opcionValida) {
                System.out.println("Error: Opción no válida. Inténtalo de nuevo.");
            }

        } while (!opcionValida);

        return opcion;
    }

    private static Color elegirColor() {
        System.out.println("Elige un color:");
        System.out.println("1. Blanco");
        System.out.println("2. Negro");

        int opcion = elegirOpcionMenu();

        return (opcion == 1) ? Color.BLANCO : Color.NEGRO;
    }

    private static void mostrarMenuDirecciones() {
        System.out.println("Menú de Direcciones:");
        for (Direccion direccion : Direccion.values()) {
            System.out.println((direccion.ordinal() + 1) + ". " + direccion);
        }
    }

    private static Direccion elegirDireccion() {
        System.out.println("Elige una dirección:");
        mostrarMenuDirecciones();

        int opcion = elegirOpcionMenu();

        return Direccion.values()[opcion - 1];
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Crear rey por defecto");
        System.out.println("2. Crear rey eligiendo el color");
        System.out.println("3. Mover");
        System.out.println("4. Mostrar Rey");
        System.out.println("5. Salir");
    }

    private static void despedirse() {
        System.out.println("Gracias por utilizar nuestra aplicación. ¡Hasta luego!");
    }
}
