package org.Tema01;

// Árbol Binario de Búsqueda genérico que trabaja con cualquier clase que implemente Comparable
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root; // Nodo raíz del árbol
    private int size = 0; // Contador de elementos en el árbol

    // Inserta un nuevo valor en el árbol
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    // Inserción recursiva en el árbol
    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            size++;
            return new Node<>(value); // Se crea un nuevo nodo
        }

        // Se compara el valor a insertar con el nodo actual
        int cmp = value.compareTo(current.data);
        if (cmp < 0) {
            current.left = insertRecursive(current.left, value); // Inserta en subárbol izquierdo
        } else if (cmp > 0) {
            current.right = insertRecursive(current.right, value); // Inserta en subárbol derecho
        }
        return current;
    }

    // Verifica si un valor existe en el árbol
    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    // Búsqueda recursiva
    private boolean containsRecursive(Node<T> current, T value) {
        if (current == null) return false;

        int cmp = value.compareTo(current.data);
        if (cmp == 0) return true;
        return cmp < 0
                ? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }

    // Elimina un valor del árbol
    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    // Eliminación recursiva
    private Node<T> deleteRecursive(Node<T> current, T value) {
        if (current == null) return null;

        int cmp = value.compareTo(current.data);
        if (cmp < 0) {
            current.left = deleteRecursive(current.left, value);
        } else if (cmp > 0) {
            current.right = deleteRecursive(current.right, value);
        } else {
            size--;
            // Caso 1: Nodo sin hijos
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            // Caso 2: Nodo con dos hijos
            T minValue = findMin(current.right);
            current.data = minValue;
            current.right = deleteRecursive(current.right, minValue);
        }
        return current;
    }

    // Encuentra el valor mínimo en un subárbol
    private T findMin(Node<T> node) {
        while (node.left != null) node = node.left;
        return node.data;
    }

    // Recorre el árbol en orden (izquierda - raíz - derecha)
    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<T> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println(node.data); // Imprime el valor del nodo
            inOrderRecursive(node.right);
        }
    }

    // Retorna el tamaño del árbol
    public int size() {
        return size;
    }

    // Verifica si el árbol está vacío
    public boolean isEmpty() {
        return size == 0;
    }
}
