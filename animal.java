package taller;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    abstract String hacerSonido();

    // Método que devuelve el nombre en mayúsculas
    public String getNombreEnMayusculas() {
        return nombre.toUpperCase();
    }
}
