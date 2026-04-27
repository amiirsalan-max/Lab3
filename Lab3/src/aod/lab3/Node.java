package aod.lab3;

/**
 * Representerar en nod i en länkad lista.
 *
 * @param <T> typen av element i noden
 * @author Abdisalan Mahad Omar
 * @date 2026-04-27
 */
class Node<T> {

    T element;
    Node<T> next;

    Node(T element) {
        this.element = element;
        this.next = null;
    }
}