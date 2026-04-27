package aod.lab3;

import java.util.Random;

/**
 * Tidstest för sorteringsalgoritmerna i SortableLinkedList.
 *
 * @author Abdisalan Mahad Omar
 * @version 2026-04-27
 */
public final class SortTimeTest {

    private static final int SIZE_100 = 100;
    private static final int SIZE_500 = 500;
    private static final int SIZE_1000 = 1000;
    private static final int SIZE_2000 = 2000;
    private static final int SIZE_4000 = 4000;
    private static final int SIZE_8000 = 8000;
    private static final int RANDOM_BOUND = 100000;

    private SortTimeTest() {
    }

    public static void main(final String[] args) {
        final int[] sizes = {
            SIZE_100,
            SIZE_500,
            SIZE_1000,
            SIZE_2000,
            SIZE_4000,
            SIZE_8000
        };

        final Random rand = new Random();

        System.out.println(
                "n,bubbelSort,insertionSort,mergeSort,quickSort");

        for (int n : sizes) {
            final SortableLinkedList<Integer> list =
                    new SortableLinkedList<>();

            for (int i = 0; i < n; i++) {
                list.add(rand.nextInt(RANDOM_BOUND));
            }

            final long bubbleTime = measureBubble(list);
            final long insertionTime = measureInsertion(list);
            final long mergeTime = measureMerge(list);
            final long quickTime = measureQuick(list);

            System.out.println(
                    n + "," + bubbleTime + "," + insertionTime + ","
                            + mergeTime + "," + quickTime);
        }
    }

    private static long measureBubble(
            final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.bubbelSort();
        final long end = System.nanoTime();
        return end - start;
    }

    private static long measureInsertion(
            final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.insertionSort();
        final long end = System.nanoTime();
        return end - start;
    }

    private static long measureMerge(
            final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.mergeSort();
        final long end = System.nanoTime();
        return end - start;
    }

    private static long measureQuick(
            final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.quickSort();
        final long end = System.nanoTime();
        return end - start;
    }
}