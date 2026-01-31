// Clase genérica que representa un nodo del árbol
public class Node<T> {
    T data;          // Dato almacenado en el nodo
    Node<T> left;    // Referencia al hijo izquierdo
    Node<T> right;   // Referencia al hijo derecho

    // Constructor que recibe un dato genérico
    Node(T data) {
        this.data = data;
    }
}
