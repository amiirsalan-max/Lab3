package aod.lab3;

import java.util.ArrayList;

/**
 * Implementation av en sorterbar enkel-länkad lista.
 *
 * Sorteringsmetoderna är icke-destruktiva, vilket betyder att
 * original-listan inte ändras utan en ny sorterad lista returneras.
 *
 * @param <T> typen av element i listan
 * @author Abdisalan Mahad Omar
 * @version 2026-04-27
 */
public class SortableLinkedList<T extends Comparable<? super T>>
        extends LinkedList<T>
        implements SortableList<T> {

    @Override
    public final SortableList<T> bubbelSort() {
        final ArrayList<T> array = toArrayList();

        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j).compareTo(array.get(j + 1)) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }

        return fromArrayList(array);
    }

    @Override
    public final SortableList<T> insertionSort() {
        final ArrayList<T> array = toArrayList();

        for (int i = 1; i < array.size(); i++) {
            final T key = array.get(i);
            int j = i - 1;

            while (j >= 0 && array.get(j).compareTo(key) > 0) {
                array.set(j + 1, array.get(j));
                j--;
            }

            array.set(j + 1, key);
        }

        return fromArrayList(array);
    }

    @Override
    public final SortableList<T> mergeSort() {
        final ArrayList<T> array = toArrayList();
        mergeSort(array, 0, array.size() - 1);
        return fromArrayList(array);
    }

    @Override
    public final SortableList<T> quickSort() {
        final ArrayList<T> array = toArrayList();
        quickSort(array, 0, array.size() - 1);
        return fromArrayList(array);
    }

    /**
     * Kopierar listan till en ArrayList.
     *
     * @return en ArrayList med listans element
     */
    private ArrayList<T> toArrayList() {
        final ArrayList<T> array = new ArrayList<>();

        for (T item : this) {
            array.add(item);
        }

        return array;
    }

    /**
     * Skapar en ny SortableLinkedList från en ArrayList.
     *
     * @param array arrayen som ska kopieras
     * @return en ny SortableLinkedList
     */
    private SortableLinkedList<T> fromArrayList(final ArrayList<T> array) {
        final SortableLinkedList<T> result = new SortableLinkedList<>();

        for (T item : array) {
            result.add(item);
        }

        return result;
    }

    /**
     * Byter plats på två element.
     *
     * @param array listan där elementen finns
     * @param first första indexet
     * @param second andra indexet
     */
    private void swap(
            final ArrayList<T> array,
            final int first,
            final int second) {
        final T temp = array.get(first);
        array.set(first, array.get(second));
        array.set(second, temp);
    }

    /**
     * Sorterar en del av arrayen med merge sort.
     *
     * @param array arrayen som ska sorteras
     * @param left vänster gräns
     * @param right höger gräns
     */
    private void mergeSort(
            final ArrayList<T> array,
            final int left,
            final int right) {
        if (left < right) {
            final int middle = left + (right - left) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    /**
     * Slår ihop två sorterade delar av arrayen.
     *
     * @param array arrayen som innehåller delarna
     * @param left vänster gräns
     * @param middle mittenindex
     * @param right höger gräns
     */
    private void merge(
            final ArrayList<T> array,
            final int left,
            final int middle,
            final int right) {
        final ArrayList<T> temp = new ArrayList<>();

        int i = left;
        int j = middle + 1;

        while (i <= middle && j <= right) {
            if (array.get(i).compareTo(array.get(j)) <= 0) {
                temp.add(array.get(i));
                i++;
            } else {
                temp.add(array.get(j));
                j++;
            }
        }

        while (i <= middle) {
            temp.add(array.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(array.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            array.set(left + k, temp.get(k));
        }
    }

    /**
     * Sorterar en del av arrayen med quick sort.
     *
     * @param array arrayen som ska sorteras
     * @param low vänster gräns
     * @param high höger gräns
     */
    private void quickSort(
            final ArrayList<T> array,
            final int low,
            final int high) {
        if (low < high) {
            final int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * Partitionerar arrayen runt ett pivot-element.
     *
     * @param array arrayen som ska partitioneras
     * @param low vänster gräns
     * @param high höger gräns
     * @return pivot-elementets slutliga position
     */
    private int partition(
            final ArrayList<T> array,
            final int low,
            final int high) {
        final T pivot = array.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }
}