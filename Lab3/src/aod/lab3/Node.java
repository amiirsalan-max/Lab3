package aod.lab3;

/**
 * Representerar en nod i en enkel-länkad lista.
 *
 * @param <T> typen av element i noden
 * @author Abdisalan Mahad Omar
 * @version 2026-04-27
 */
class Node<T> {

    T element;
    Node<T> next;

    /**
     * Skapar en ny nod.
     *
     * @param element elementet som noden ska innehålla
     */
    Node(T element) {
        this.element = element;
        this.next = null;
    }
}