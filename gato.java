package taller;

import java.io.Serializable;

public class Gato extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String hacerSonido() {
        return "El gato maúlla.";
    }
}
