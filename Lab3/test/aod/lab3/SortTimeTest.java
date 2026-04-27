package aod.lab3;

import java.util.Random;

/**
 * Tidstest för sorteringsalgoritmerna i SortableLinkedList.
 * 
 * @author Abdisalan Mahad Omar
 * @date 2026-04-27
 */
public class SortTimeTest {

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 2000, 4000, 8000};
        Random rand = new Random();

        System.out.println("n,bubbelSort,insertionSort,mergeSort,quickSort");

        for (int n : sizes) {
            SortableLinkedList<Integer> list = new SortableLinkedList<>();

            for (int i = 0; i < n; i++) {
                list.add(rand.nextInt(100000));
            }

            long bubbleTime = measureBubble(list);
            long insertionTime = measureInsertion(list);
            long mergeTime = measureMerge(list);
            long quickTime = measureQuick(list);

            System.out.println(n + "," + bubbleTime + "," + insertionTime + ","
                    + mergeTime + "," + quickTime);
        }
    }

    private static long measureBubble(SortableLinkedList<Integer> list) {
        long start = System.nanoTime();
        list.bubbelSort();
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureInsertion(SortableLinkedList<Integer> list) {
        long start = System.nanoTime();
        list.insertionSort();
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureMerge(SortableLinkedList<Integer> list) {
        long start = System.nanoTime();
        list.mergeSort();
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureQuick(SortableLinkedList<Integer> list) {
        long start = System.nanoTime();
        list.quickSort();
        long end = System.nanoTime();
        return end - start;
    }
}