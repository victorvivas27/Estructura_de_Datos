package linkedListdoblementeenlazada;

import Interface.InterfaceLinkedList;
import model.Node;

public class LinkedListDoubleEnlasada<E> implements InterfaceLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public LinkedListDoubleEnlasada() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
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
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextNode(newNode);
            newNode.setPreviousNode(tail);
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null; // Reiniciamos tail
        size = 0;
        System.out.println("Lista ELIMINADA");
    }

    @Override
    public E get(int index) {
        verificationIndex(index);
        Node<E> actualNode = head;
        for (int i = 0; i < index; i++) {
            actualNode = actualNode.getNextNode();
        }
        return actualNode.getData();
    }

    @Override
    public E remove(int index) {
        verificationIndex(index);
        E removeData;
        if (index == 0) {
            removeData = head.getData();
            head = head.getNextNode();
            if (head != null) {
                head.setPreviousNode(null);
            } else {
                tail = null;
            }
        } else {
            Node<E> actualNode = head;
            for (int i = 0; i < index - 1; i++) {
                actualNode = actualNode.getNextNode();
            }
            removeData = actualNode.getNextNode().getData();
            Node<E> nodeToRemove = actualNode.getNextNode();

            actualNode.setNextNode(nodeToRemove.getNextNode());

            if (nodeToRemove.getNextNode() != null) {
                nodeToRemove.getNextNode().setPreviousNode(actualNode);
            } else {
                tail = actualNode;
            }
        }
        size--;
        return removeData;
    }

    @Override
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getData() + " <-> ");
            current = current.getNextNode();
        }
        System.out.println("null");
    }

    private void verificationIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }
}
