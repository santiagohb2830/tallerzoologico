package taller;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoologico {
    private List<Animal> animales;
    private Map<String, Integer> conteoPorTipo;

    public Zoologico() {
        animales = new ArrayList<>();
        conteoPorTipo = new HashMap<>();
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
        // Incrementar el conteo por tipo
        String tipo = animal.getClass().getSimpleName(); // Obtiene el nombre de la clase
        conteoPorTipo.put(tipo, conteoPorTipo.getOrDefault(tipo, 0) + 1);
    }

    public void mostrarSonidos() {
        for (Animal animal : animales) {
            System.out.println(animal.getNombre() + ": " + animal.hacerSonido());
        }
    }

    public void mostrarConteoPorTipo() {
        System.out.println("Conteo por tipo de animal:");
        for (Map.Entry<String, Integer> entry : conteoPorTipo.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Método para guardar la lista de animales en un archivo binario
    public void guardarAnimales(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(animales);
            System.out.println("Lista de animales guardada en " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la lista de animales desde un archivo binario
    @SuppressWarnings("unchecked")
    public void cargarAnimales(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            animales = (List<Animal>) in.readObject();
            System.out.println("Lista de animales cargada desde " + filename);
            // Actualizar el conteo por tipo
            conteoPorTipo.clear();
            for (Animal animal : animales) {
                String tipo = animal.getClass().getSimpleName();
                conteoPorTipo.put(tipo, conteoPorTipo.getOrDefault(tipo, 0) + 1);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la lista de animales
    public List<Animal> getAnimales() {
        return animales;
    }
}
