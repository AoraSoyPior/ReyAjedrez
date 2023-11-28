package org.iesalandalus.programacion.reyajedrez.modelo;
import java.util.Objects;
public class Posicion {
    private int fila;
    private char columna;

    // Constructor
    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    // Constructor copia
    public Posicion(Posicion otraPosicion) {
        this(otraPosicion.fila, otraPosicion.columna);
    }

    // Método equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Posicion otraPosicion = (Posicion) obj;
        return fila == otraPosicion.fila && columna == otraPosicion.columna;
    }

    // Método hashCode
    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    // Método toString
    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }

    // Getter para fila
    public int getFila() {
        return fila;
    }

    // Setter para fila con validación
    public void setFila(int fila) {
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("La fila debe estar entre 1 y 8, inclusive.");
        }
        this.fila = fila;
    }

    // Getter para columna
    public char getColumna() {
        return columna;
    }

    // Setter para columna con validación
    public void setColumna(char columna) {
        if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("La columna debe estar entre 'a' y 'h', inclusive.");
        }
        this.columna = columna;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        try {
            Posicion posicion = new Posicion(4, 'e');
            System.out.println(posicion);  // Salida: fila=4, columna=e
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

