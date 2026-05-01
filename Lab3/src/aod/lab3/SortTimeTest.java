package aod.lab3;

import java.util.Random;

/**
 * Tidstest för sorteringsalgoritmer.
 *
 * @author Abdisalan Mahad Omar
 * @version 2026-04-27
 */
public final class SortTimeTest {

    /** Storlek 100. */
    private static final int SIZE_100 = 100;

    /** Storlek 500. */
    private static final int SIZE_500 = 500;

    /** Storlek 1000. */
    private static final int SIZE_1000 = 1000;

    /** Storlek 2000. */
    private static final int SIZE_2000 = 2000;

    /** Storlek 4000. */
    private static final int SIZE_4000 = 4000;

    /** Storlek 8000. */
    private static final int SIZE_8000 = 8000;

    /** Gräns för slumpade tal. */
    private static final int RANDOM_BOUND = 100000;

    /**
     * Privat konstruktor eftersom klassen bara har statiska metoder.
     */
    private SortTimeTest() {
    }

    /**
     * Kör alla tidstester.
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

        runTest("SLUMPAD DATA", sizes, "random");
        runTest("SORTERAD STIGANDE", sizes, "ascending");
        runTest("SORTERAD FALLANDE", sizes, "descending");
    }

    /**
     * Kör ett test för en viss typ av data.
     *
     * @param title rubrik för testet
     * @param sizes liststorlekar
     * @param type typ av lista
     */
    private static void runTest(
            final String title,
            final int[] sizes,
            final String type) {

        System.out.println("\n" + title);
        System.out.println("n | bubble | insertion | merge | quick");
        System.out.println("--------------------------------------");

        for (int n : sizes) {
            final SortableLinkedList<Integer> list =
                    createList(n, type);

            final long bubble = measureBubble(list);
            final long insertion = measureInsertion(list);
            final long merge = measureMerge(list);
            final long quick = measureQuick(list);

            System.out.println(
                    n + " | "
                            + bubble + " | "
                            + insertion + " | "
                            + merge + " | "
                            + quick);
        }
    }

    /**
     * Skapar en lista med vald typ av data.
     *
     * @param size listans storlek
     * @param type typ av data
     * @return en fylld SortableLinkedList
     */
    private static SortableLinkedList<Integer> createList(
            final int size,
            final String type) {

        final SortableLinkedList<Integer> list =
                new SortableLinkedList<>();
        final Random rand = new Random();

        for (int i = 0; i < size; i++) {
            if ("ascending".equals(type)) {
                list.add(i);
            } else if ("descending".equals(type)) {
                list.add(size - i);
            } else {
                list.add(rand.nextInt(RANDOM_BOUND));
            }
        }

        return list;
    }

    /**
     * Mäter bubbel sort.
     *
     * @param list listan som ska sorteras
     * @return tid i nanosekunder
     */
    private static long measureBubble(
            final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.bubbelSort();
        final long end = System.nanoTime();
        return end - start;
    }

    /**
     * Mäter insertion sort.
     *
     * @param list listan som ska sorteras
     * @return tid i nanosekunder
     */
    private static long measureInsertion(
            final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.insertionSort();
        final long end = System.nanoTime();
        return end - start;
    }

    /**
     * Mäter merge sort.
     *
     * @param list listan som ska sorteras
     * @return tid i nanosekunder
     */
    private static long measureMerge(
            final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.mergeSort();
        final long end = System.nanoTime();
        return end - start;
    }

    /**
     * Mäter quick sort.
     *
     * @param list listan som ska sorteras
     * @return tid i nanosekunder
     */
    private static long measureQuick(
            final SortableLinkedList<Integer> list) {
        final long start = System.nanoTime();
        list.quickSort();
        final long end = System.nanoTime();
        return end - start;
    }
}