package model;

public class Node<E> {
    private E data;
    private Node<E> nextNode;
    private Node<E> previousNode;

    public Node(E data) {
        this.data = data;

    }

    public E getData() {
        return data;
    }


    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<E> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node<E> previousNode) {
        this.previousNode = previousNode;
    }
}
