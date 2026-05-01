package aod.lab3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Testklass för LinkedList.
 *
 * @author Abdisalan Mahad Omar
 * @version 2026-04-27
 */
public class LinkedListTest {

    @Test
    public void testAddOneElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);

        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testAddSeveralElements() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(30, list.get(2));
    }

    @Test
    public void testAddWithIndexInMiddle() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(30);
        list.add(20, 1);

        assertEquals(3, list.size());
        assertEquals(20, list.get(1));
    }

    @Test
    public void testAddInvalidIndexThrowsException() {
        LinkedList<Integer> list = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, 1));
    }

    @Test
    public void testGetInvalidIndexThrowsException() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    public void testSetElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.set(99, 0);

        assertEquals(99, list.get(0));
    }

    @Test
    public void testRemoveLastElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        list.remove();

        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void testRemoveAtIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals(3, list.get(1));
    }

    @Test
    public void testClear() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    public void testIteratorWithForEachLoop() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        int sum = 0;

        for (Integer value : list) {
            sum += value;
        }

        assertEquals(60, sum);
    }

    @Test
    public void testIteratorOrder() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        String result = "";

        for (String value : list) {
            result += value;
        }

        assertEquals("ABC", result);
    }
}