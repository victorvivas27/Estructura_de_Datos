package linkedlistlistaenlazada;

import Interface.InterfaceLinkedList;
import model.Node;

public class LinkedListListaEnlazada<E> implements InterfaceLinkedList<E> {
    private Node<E> head;
    private int size = 0;

    public LinkedListListaEnlazada() {

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
        Node<E> newNode = new Node<E>(e);
        if (isEmpty()) {
            head = newNode;

        } else {
            Node<E> actualNode = head;
            while (actualNode.getNextNode() != null) {
                actualNode = actualNode.getNextNode();
            }
            actualNode.setNextNode(newNode);
        }
        size++;
        return true;
    }


    @Override
    public void clear() {
        head = null;
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
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
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