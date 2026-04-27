package aod.lab3;

/**
 * Interface för en lista som kan sorteras med olika sorteringsalgoritmer.
 *
 * Sorteringsmetoderna ska inte ändra original-listan.
 *
 * @param <T> typen av element i listan
 * @author Abdisalan Mahad Omar
 * @date 2026-04-27
 */
public interface SortableList<T extends Comparable<? super T>> extends List<T> {

    /**
     * Sorterar listan med bubbel sort.
     *
     * @return en sorterad kopia av listan
     */
    SortableList<T> bubbelSort();

    /**
     * Sorterar listan med insertion sort.
     *
     * @return en sorterad kopia av listan
     */
    SortableList<T> insertionSort();

    /**
     * Sorterar listan med merge sort.
     *
     * @return en sorterad kopia av listan
     */
    SortableList<T> mergeSort();

    /**
     * Sorterar listan med quick sort.
     *
     * @return en sorterad kopia av listan
     */
    SortableList<T> quickSort();
}