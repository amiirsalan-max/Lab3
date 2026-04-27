package aod.lab3;

import java.util.Random;

/**
 * Tidstest för sorteringsalgoritmerna i SortableLinkedList.
 *
 * @author Abdisalan Mahad Omar
 * @version 2026-04-27
 */
public final class SortTimeTest {

    /** Minsta teststorleken. */
    private static final int SIZE_100 = 100;

    /** Teststorlek. */
    private static final int SIZE_500 = 500;

    /** Teststorlek. */
    private static final int SIZE_1000 = 1000;

    /** Teststorlek. */
    private static final int SIZE_2000 = 2000;

    /** Teststorlek. */
    private static final int SIZE_4000 = 4000;

    /** Största teststorleken. */
    private static final int SIZE_8000 = 8000;

    /** Övre gräns för slumpade tal. */
    private static final int RANDOM_BOUND = 100000;

    /**
     * Privat konstruktor eftersom klassen bara innehåller statiska metoder.
     */
    private SortTimeTest() {
    }

    /**
     * Kör tidstesterna.
     *
     * @param args kommandoradsargument
     */
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

        System.out.println("n,bubbelSort,insertionSort,mergeSort,quickSort");

        for (int n : sizes) {
            final SortableLinkedList<Integer> list = new SortableLinkedList<>();

            for (int i = 0; i < n; i++) {
                list.add(rand.nextInt(RANDOM_BOUND));
            }

            final long bubbleTime = measureBubble(list);
            final long insertionTime = measureInsertion(list);
            final long mergeTime = measureMerge(list);
            final long quickTime = measureQuick(list);

            System.out.println(n + "," + bubbleTime + "," + insertionTime + ","
                    + mergeTime + "," + quickTime);
        }
    }

    /**
     * Mäter tiden för bubbel sort.
     *
     * @param list listan som ska sorteras
     * @return tid i nanosekunder
     */
    private static long measureBubble(final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.bubbelSort();
        final long end = System.nanoTime();
        return end - start;
    }

    /**
     * Mäter tiden för insertion sort.
     *
     * @param list listan som ska sorteras
     * @return tid i nanosekunder
     */
    private static long measureInsertion(final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.insertionSort();
        final long end = System.nanoTime();
        return end - start;
    }

    /**
     * Mäter tiden för merge sort.
     *
     * @param list listan som ska sorteras
     * @return tid i nanosekunder
     */
    private static long measureMerge(final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.mergeSort();
        final long end = System.nanoTime();
        return end - start;
    }

    /**
     * Mäter tiden för quick sort.
     *
     * @param list listan som ska sorteras
     * @return tid i nanosekunder
     */
    private static long measureQuick(final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.quickSort();
        final long end = System.nanoTime();
        return end - start;
    }
}