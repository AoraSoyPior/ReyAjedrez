package org.iesalandalus.programacion.reyajedrez.modelo;

public enum Color {
    BLANCO("Blanco"),
    NEGRO("Negro");

    private String cadenaAMostrar;

    // Constructor del enum con parámetro
    private Color(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    // Método toString para devolver la representación en cadena del literal
    @Override
    public String toString() {
        return cadenaAMostrar;
    }

    public static void main(String[] args) {
        // Ejemplo de uso del enum Color
        Color miColor = Color.BLANCO;
        System.out.println(miColor);  // Salida: Blanco
    }
}
