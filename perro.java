package taller;

import java.io.Serializable;

public class Perro extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String hacerSonido() {
        return "El perro ladra.";
    }
}
