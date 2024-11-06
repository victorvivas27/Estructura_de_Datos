# Implementación de LinkedListListaEnlazada en Java

Este proyecto implementa una lista enlazada en Java utilizando la clase `LinkedListListaEnlazada<E>`, que ofrece operaciones básicas como agregar, eliminar, obtener y verificar elementos.

## Clases y Estructura

### 1. Clase `Node<E>`

La clase `Node` representa cada nodo en la lista enlazada, almacenando el valor del nodo y la referencia al siguiente nodo.

```java
public class Node<E> {
    private E data;                    // Valor almacenado en el nodo 
    private Node<E> nextNode;          // Referencia al siguiente nodo

    public Node(E data) {              // Constructor que inicializa el dato
        this.data = data;
    }

    public E getData() {               // Método para obtener el dato
        return data;
    }

    public Node<E> getNextNode() {     // Método para obtener el siguiente nodo
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) { // Método para establecer el siguiente nodo
        this.nextNode = nextNode;
    }
}
2. Clase LinkedListListaEnlazada<E>
Esta clase implementa las operaciones principales de una lista enlazada y maneja internamente la referencia al primer nodo (head) y el tamaño de la lista.


public class LinkedListListaEnlazada<E> implements InterfaceLinkedList<E> {
    private Node<E> head;             // Referencia al primer nodo de la lista
    private int size = 0;              // Contador de elementos en la lista

    public LinkedListListaEnlazada() { // Constructor que inicializa la lista vacía
    }

    @Override
    public int size() {                // Devuelve el tamaño de la lista
        return size;
    }

    @Override
    public boolean isEmpty() {         // Verifica si la lista está vacía
        return size == 0;
    }

    @Override
    public boolean contains(Object o) { // Verifica si un elemento está en la lista
        Node<E> actualNode = head;
        while (actualNode != null) {
            if (actualNode.getData().equals(o)) {
                return true;
            }
            actualNode = actualNode.getNextNode();
        }
        return false;
    }

    @Override
    public boolean add(E e) {          // Agrega un nuevo elemento a la lista
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;            // Si la lista está vacía, establece el nuevo nodo como cabeza
        } else {
            Node<E> actualNode = head;
            while (actualNode.getNextNode() != null) {
                actualNode = actualNode.getNextNode(); // Busca el último nodo
            }
            actualNode.setNextNode(newNode); // Enlaza el nuevo nodo al final de la lista
        }
        size++;
        return true;
    }

    @Override
    public void clear() {              // Limpia la lista
        head = null;                   // Elimina la referencia al primer nodo
        size = 0;                      // Restablece el tamaño a 0
        System.out.println("Lista ELIMINADA");
    }

    @Override
    public E get(int index) {          // Obtiene un elemento en un índice específico
        verificationIndex(index);      // Verifica si el índice es válido
        Node<E> actualNode = head;
        for (int i = 0; i < index; i++) {
            actualNode = actualNode.getNextNode();
        }
        return actualNode.getData();
    }

    @Override
    public E remove(int index) {       // Elimina un elemento en un índice específico
        verificationIndex(index);      // Verifica si el índice es válido
        E removeData;
        if (index == 0) {
            removeData = head.getData();
            head = head.getNextNode(); // Mueve la cabeza al siguiente nodo
        } else {
            Node<E> actualNode = head;
            for (int i = 0; i < index - 1; i++) {
                actualNode = actualNode.getNextNode();
            }
            removeData = actualNode.getNextNode().getData();
            actualNode.setNextNode(actualNode.getNextNode().getNextNode());
        }
        size--;
        return removeData;
    }

    @Override
    public void printList() {          // Imprime todos los elementos de la lista
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNextNode();
        }
        System.out.println("null");
    }

    private void verificationIndex(int index) { // Verifica si el índice es válido
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }
}






