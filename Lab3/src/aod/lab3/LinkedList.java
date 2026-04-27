package aod.lab3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation av en enkel-länkad lista.
 *
 * @param <T> typen av element i listan
 * @author Abdisalan Mahad Omar
 * @version 2026-04-27
 */
public class LinkedList<T> implements List<T> {

    /** Pekar på första noden i listan. */
    private Node<T> head;

    /** Antal element i listan. */
    private int size;

    /**
     * Skapar en tom lista.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T data) {
        add(data, size);
    }

    @Override
    public void add(T data, int index) {
        checkAddIndex(index);

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = getNode(index - 1);
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    @Override
    public T get(int index) {
        checkElementIndex(index);
        return getNode(index).element;
    }

    @Override
    public void set(T data, int index) {
        checkElementIndex(index);
        getNode(index).element = data;
    }

    @Override
    public void remove() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Listan är tom");
        }

        remove(size - 1);
    }

    @Override
    public void remove(int index) {
        checkElementIndex(index);

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = getNode(index - 1);
            current.next = current.next.next;
        }

        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Iterator som går igenom listan från första nod till sista.
     */
    private class LinkedListIterator implements Iterator<T> {

        /** Referens till aktuell nod. */
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T value = current.element;
            current = current.next;
            return value;
        }
    }

    /**
     * Hämtar noden på ett visst index.
     *
     * @param index positionen i listan
     * @return noden på angivet index
     */
    private Node<T> getNode(int index) {
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    /**
     * Kontrollerar att index är giltigt för get, set och remove.
     *
     * @param index index att kontrollera
     */
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Kontrollerar att index är giltigt för add.
     *
     * @param index index att kontrollera
     */
    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}