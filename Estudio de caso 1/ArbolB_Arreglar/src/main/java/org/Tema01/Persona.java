package org.Tema01;

// Clase Persona que implementa Comparable para poder ser usada en el árbol
public class Persona implements Comparable<Persona> {
    String nombre; // Nombre de la persona
    int edad;      // Edad de la persona

    // Constructor que inicializa nombre y edad
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override // Se sobreescribe el método compareTo para comparar las edades
    public int compareTo(Persona otra) {
        return Integer.compare(this.edad, otra.edad); // Orden por edad
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + ")"; // Representación en texto
    }
}
