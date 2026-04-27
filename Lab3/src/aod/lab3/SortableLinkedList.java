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
    public SortableList<T> bubbelSort() {
        ArrayList<T> array = toArrayList();

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
    public SortableList<T> insertionSort() {
        ArrayList<T> array = toArrayList();

        for (int i = 1; i < array.size(); i++) {
            T key = array.get(i);
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
    public SortableList<T> mergeSort() {
        ArrayList<T> array = toArrayList();
        mergeSort(array, 0, array.size() - 1);
        return fromArrayList(array);
    }

    @Override
    public SortableList<T> quickSort() {
        ArrayList<T> array = toArrayList();
        quickSort(array, 0, array.size() - 1);
        return fromArrayList(array);
    }

    /**
     * Kopierar listan till en ArrayList.
     */
    private ArrayList<T> toArrayList() {
        ArrayList<T> array = new ArrayList<>();

        for (T item : this) {
            array.add(item);
        }

        return array;
    }

    /**
     * Skapar en ny SortableLinkedList från en ArrayList.
     */
    private SortableLinkedList<T> fromArrayList(ArrayList<T> array) {
        SortableLinkedList<T> result = new SortableLinkedList<>();

        for (T item : array) {
            result.add(item);
        }

        return result;
    }

    /**
     * Byter plats på två element.
     */
    private void swap(ArrayList<T> array, int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    /**
     * Merge sort.
     */
    private void mergeSort(ArrayList<T> array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    /**
     * Merge-funktion.
     */
    private void merge(ArrayList<T> array, int left, int mid, int right) {
        ArrayList<T> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (array.get(i).compareTo(array.get(j)) <= 0) {
                temp.add(array.get(i++));
            } else {
                temp.add(array.get(j++));
            }
        }

        while (i <= mid) {
            temp.add(array.get(i++));
        }

        while (j <= right) {
            temp.add(array.get(j++));
        }

        for (int k = 0; k < temp.size(); k++) {
            array.set(left + k, temp.get(k));
        }
    }

    /**
     * Quick sort.
     */
    private void quickSort(ArrayList<T> array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * Partition.
     */
    private int partition(ArrayList<T> array, int low, int high) {
        T pivot = array.get(high);
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