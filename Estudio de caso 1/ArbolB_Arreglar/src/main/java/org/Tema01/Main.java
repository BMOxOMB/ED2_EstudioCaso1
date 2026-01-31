package org.Tema01;

public class Main {
    public static void main(String[] args) {

        // Se crea un árbol binario de búsqueda de Personas
        BinarySearchTree<Persona> bst = new BinarySearchTree<>();

        // Inserción de elementos en el árbol
        bst.insert(new Persona("Ana", 30));
        bst.insert(new Persona("Luis", 25));
        bst.insert(new Persona("Carlos", 35));
        bst.insert(new Persona("Bea", 28));

        System.out.println("Recorrido inorden:");
        bst.inOrderTraversal();

        // Verificación de existencia
        System.out.println("\n¿Contiene a Luis (25)? " + bst.contains(new Persona("Luis", 25)));

        // Eliminación de un nodo
        System.out.println("\nEliminando a Ana (30)...");
        bst.delete(new Persona("Ana", 30));

        System.out.println("\nRecorrido inorden después de eliminar:");
        bst.inOrderTraversal();

        // Tamaño del árbol
        System.out.println("\nTamaño del árbol: " + bst.size());
    }
}
