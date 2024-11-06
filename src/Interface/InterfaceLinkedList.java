package Interface;

public interface InterfaceLinkedList<E> {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    boolean add(E e);

    void clear() throws Exception;

    E get(int index);

    E remove(int index);

    public void printList();

}
