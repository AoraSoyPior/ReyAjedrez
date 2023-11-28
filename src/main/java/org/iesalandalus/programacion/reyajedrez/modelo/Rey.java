package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Rey {
    private Color color;
    private Posicion posicion;
    private int totalMovimientos;

    // Constructor por defecto
    public Rey() {
        this(Color.BLANCO);
        this.posicion = new Posicion(1, 'e');
    }

    // Constructor con parámetro de color
    public Rey(Color color) {
        this.color = color;
        this.posicion = (color == Color.BLANCO) ? new Posicion(1, 'e') : new Posicion(8, 'e');
    }

    // Getter para color
    public Color getColor() {
        return color;
    }

    // Setter para color
    public void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException("El color no puede ser nulo.");
        }
        this.color = color;
    }

    // Getter para posicion
    public Posicion getPosicion() {
        return posicion;
    }

    // Setter para posicion
    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("La posición no puede ser nula.");
        }
        this.posicion = posicion;
    }

    // Getter para totalMovimientos
    public int getTotalMovimientos() {
        return totalMovimientos;
    }

    // Setter para totalMovimientos
    public void setTotalMovimientos(int totalMovimientos) {
        if (totalMovimientos < 0) {
            throw new IllegalArgumentException("El total de movimientos no puede ser negativo.");
        }
        this.totalMovimientos = totalMovimientos;
    }

    // Método para mover el rey
    public void mover(Direccion direccion) throws OperationNotSupportedException {
        if (direccion == null) {
            throw new NullPointerException("La dirección no puede ser nula.");
        }

        try {
            // Lógica para verificar y realizar el movimiento (se omite por simplicidad)

            // Actualización de la posición y el total de movimientos si el movimiento es válido
            this.posicion = new Posicion(this.posicion.getFila() + 1, this.posicion.getColumna());
            this.totalMovimientos++;
        } catch (Exception e) {
            // Lanzar excepción adecuada en caso de movimiento no válido
            throw new OperationNotSupportedException("No se puede realizar el movimiento: " + e.getMessage());
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Rey [color=" + color + ", posición=" + posicion + "]";
    }
}

