package aod.lab3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Testklass för SortableLinkedList.
 *
 * @author Abdisalan Mahad Omar
 * @date 2026-04-27
 */
public class SortableLinkedListTest {

    private SortableLinkedList<Integer> createUnsortedList() {
        SortableLinkedList<Integer> list = new SortableLinkedList<>();
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(1);
        list.add(3);
        return list;
    }

    private void assertSorted(SortableList<Integer> sorted) {
        assertEquals(1, sorted.get(0));
        assertEquals(2, sorted.get(1));
        assertEquals(3, sorted.get(2));
        assertEquals(5, sorted.get(3));
        assertEquals(9, sorted.get(4));
    }

    @Test
    public void testBubbelSort() {
        SortableLinkedList<Integer> list = createUnsortedList();

        SortableList<Integer> sorted = list.bubbelSort();

        assertSorted(sorted);
    }

    @Test
    public void testInsertionSort() {
        SortableLinkedList<Integer> list = createUnsortedList();

        SortableList<Integer> sorted = list.insertionSort();

        assertSorted(sorted);
    }

    @Test
    public void testMergeSort() {
        SortableLinkedList<Integer> list = createUnsortedList();

        SortableList<Integer> sorted = list.mergeSort();

        assertSorted(sorted);
    }

    @Test
    public void testQuickSort() {
        SortableLinkedList<Integer> list = createUnsortedList();

        SortableList<Integer> sorted = list.quickSort();

        assertSorted(sorted);
    }

    @Test
    public void testOriginalListIsNotChangedAfterBubbelSort() {
        SortableLinkedList<Integer> list = createUnsortedList();

        list.bubbelSort();

        assertEquals(5, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(9, list.get(2));
        assertEquals(1, list.get(3));
        assertEquals(3, list.get(4));
    }

    @Test
    public void testOriginalListIsNotChangedAfterInsertionSort() {
        SortableLinkedList<Integer> list = createUnsortedList();

        list.insertionSort();

        assertEquals(5, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(9, list.get(2));
        assertEquals(1, list.get(3));
        assertEquals(3, list.get(4));
    }

    @Test
    public void testSortEmptyList() {
        SortableLinkedList<Integer> list = new SortableLinkedList<>();

        SortableList<Integer> sorted = list.mergeSort();

        assertEquals(0, sorted.size());
    }

    @Test
    public void testSortOneElement() {
        SortableLinkedList<Integer> list = new SortableLinkedList<>();
        list.add(10);

        SortableList<Integer> sorted = list.quickSort();

        assertEquals(1, sorted.size());
        assertEquals(10, sorted.get(0));
    }

    @Test
    public void testSortWithDuplicates() {
        SortableLinkedList<Integer> list = new SortableLinkedList<>();
        list.add(4);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(2);

        SortableList<Integer> sorted = list.mergeSort();

        assertEquals(1, sorted.get(0));
        assertEquals(2, sorted.get(1));
        assertEquals(2, sorted.get(2));
        assertEquals(4, sorted.get(3));
        assertEquals(4, sorted.get(4));
    }

    @Test
    public void testSortStrings() {
        SortableLinkedList<String> list = new SortableLinkedList<>();
        list.add("C");
        list.add("A");
        list.add("B");

        SortableList<String> sorted = list.quickSort();

        assertEquals("A", sorted.get(0));
        assertEquals("B", sorted.get(1));
        assertEquals("C", sorted.get(2));
    }
}
