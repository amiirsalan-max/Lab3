package aod.lab3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation av en enkel-länkad lista.
 *
 * @param <T> typen av element i listan
 * @author Abdisalan Mahad Omar
 * @date 2026-04-27
 */
public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

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
     * Privat iterator-klass som går igenom listan från head till null.
     */
    private class LinkedListIterator implements Iterator<T> {

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

    private Node<T> getNode(int index) {
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}