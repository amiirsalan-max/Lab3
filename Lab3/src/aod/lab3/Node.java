package aod.lab3;

/**
 * Representerar en nod i en enkel-länkad lista.
 *
 * @param <T> typen av element i noden
 * @author Abdisalan Mahad Omar
 * @version 2026-04-27
 */
class Node<T> {

    /** Elementet som lagras i noden. */
    private T element;

    /** Referens till nästa nod. */
    private Node<T> next;

    /**
     * Skapar en ny nod.
     *
     * @param data elementet som noden ska innehålla
     */
    Node(final T data) {
        this.element = data;
        this.next = null;
    }

    /**
     * Hämtar elementet.
     *
     * @return elementet i noden
     */
    T getElement() {
        return element;
    }

    /**
     * Ändrar elementet.
     *
     * @param data nytt element
     */
    void setElement(final T data) {
        this.element = data;
    }

    /**
     * Hämtar nästa nod.
     *
     * @return nästa nod
     */
    Node<T> getNext() {
        return next;
    }

    /**
     * Ändrar nästa nod.
     *
     * @param nextNode ny nästa nod
     */
    void setNext(final Node<T> nextNode) {
        this.next = nextNode;
    }
}