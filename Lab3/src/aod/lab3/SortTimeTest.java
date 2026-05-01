package aod.lab3;

import java.util.Random;

/**
 * Enkel tidstest för sorteringsalgoritmer.
 */
public class SortTimeTest {

    public static void main(String[] args) {

        int[] sizes = {100, 500, 1000, 2000, 4000, 8000};

        runTest("SLUMPAD DATA", sizes, "random");
        runTest("SORTERAD STIGANDE", sizes, "ascending");
        runTest("SORTERAD FALLANDE", sizes, "descending");
    }

    private static void runTest(String title, int[] sizes, String type) {

        System.out.println("\n" + title);
        System.out.println("n | bubble | insertion | merge | quick");
        System.out.println("--------------------------------------");

        for (int n : sizes) {

            SortableLinkedList<Integer> list = createList(n, type);

            long bubble = measureBubble(list);
            long insertion = measureInsertion(list);
            long merge = measureMerge(list);
            long quick = measureQuick(list);

            System.out.println(
                    n + " | "
                    + bubble + " | "
                    + insertion + " | "
                    + merge + " | "
                    + quick);
        }
    }

    private static SortableLinkedList<Integer> createList(int size, String type) {

        SortableLinkedList<Integer> list = new SortableLinkedList<>();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {

            if (type.equals("ascending")) {
                list.add(i);

            } else if (type.equals("descending")) {
                list.add(size - i);

            } else {
                list.add(rand.nextInt(100000));
            }
        }

        return list;
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