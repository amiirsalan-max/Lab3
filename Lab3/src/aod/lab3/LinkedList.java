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
    public final void add(final T data) {
        add(data, size);
    }

    @Override
    public final void add(final T data, final int index) {
        checkAddIndex(index);

        final Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            final Node<T> current = getNode(index - 1);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

        size++;
    }

    @Override
    public final T get(final int index) {
        checkElementIndex(index);
        return getNode(index).getElement();
    }

    @Override
    public final void set(final T data, final int index) {
        checkElementIndex(index);
        getNode(index).setElement(data);
    }

    @Override
    public final void remove() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Listan är tom");
        }

        remove(size - 1);
    }

    @Override
    public final void remove(final int index) {
        checkElementIndex(index);

        if (index == 0) {
            head = head.getNext();
        } else {
            final Node<T> current = getNode(index - 1);
            current.setNext(current.getNext().getNext());
        }

        size--;
    }

    @Override
    public final int size() {
        return size;
    }

    @Override
    public final void clear() {
        head = null;
        size = 0;
    }

    @Override
    public final Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Iterator som går igenom listan från första nod till sista.
     */
    private final class LinkedListIterator implements Iterator<T> {

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

            final T value = current.getElement();
            current = current.getNext();
            return value;
        }
    }

    /**
     * Hämtar noden på ett visst index.
     *
     * @param index positionen i listan
     * @return noden på angivet index
     */
    private Node<T> getNode(final int index) {
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    /**
     * Kontrollerar att index är giltigt för get, set och remove.
     *
     * @param index index att kontrollera
     */
    private void checkElementIndex(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Kontrollerar att index är giltigt för add.
     *
     * @param index index att kontrollera
     */
    private void checkAddIndex(final int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}