package ru.spsuace.homework2.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ru.spsuace.homework2.TestObject;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

    LinkedList<TestObject> expectedList;
    DoubleLinkedList<TestObject> actualList;

    @Before
    public void setUp() {
        expectedList = new LinkedList<>();
        actualList = new DoubleLinkedList<>();
    }

    @Test
    public void size() {
        assertList(expectedList, actualList);
    }

    @Test
    public void contains() {
        actualList.addLast(new TestObject("str0"));
        actualList.addLast(new TestObject("str1"));
        actualList.addLast(new TestObject("str2"));

        expectedList.addLast(new TestObject("str0"));
        expectedList.addLast(new TestObject("str1"));
        expectedList.addLast(new TestObject("str2"));
        assertEquals(expectedList.contains(new TestObject("str")), actualList.contains(new TestObject("str")));
        assertEquals(expectedList.contains(new TestObject("str1")), actualList.contains(new TestObject("str1")));
    }

    @Test
    public void clear() {
        actualList.add(0, new TestObject("str"));
        actualList.add(1, new TestObject("str2"));
        actualList.add(1, new TestObject("str1"));
        actualList.clear();

        expectedList.add(0, new TestObject("str"));
        expectedList.add(1, new TestObject("str2"));
        expectedList.add(1, new TestObject("str1"));
        expectedList.clear();
        assertList(expectedList, actualList);
    }

    @Test
    public void add() {
        actualList.add(0, new TestObject("str"));
        actualList.add(1, new TestObject("str1"));
        actualList.add(2, new TestObject("str2"));

        expectedList.add(0, new TestObject("str"));
        expectedList.add(1, new TestObject("str1"));
        expectedList.add(2, new TestObject("str2"));
        assertList(expectedList, actualList);
    }

    @Test
    public void addInMiddle() {
        actualList.add(0, new TestObject("str"));
        actualList.add(1, new TestObject("str2"));
        actualList.add(1, new TestObject("str1"));
        actualList.add(0, new TestObject("str1"));
        actualList.add(2, new TestObject("str1"));

        expectedList.add(0, new TestObject("str"));
        expectedList.add(1, new TestObject("str2"));
        expectedList.add(1, new TestObject("str1"));
        expectedList.add(0, new TestObject("str1"));
        expectedList.add(2, new TestObject("str1"));
        assertList(expectedList, actualList);
    }

    @Test
    public void addLast() {

        actualList.addLast(new TestObject("str0"));
        actualList.addLast(new TestObject("str1"));
        actualList.addLast(new TestObject("str2"));

        expectedList.addLast(new TestObject("str0"));
        expectedList.addLast(new TestObject("str1"));
        expectedList.addLast(new TestObject("str2"));
        assertList(expectedList, actualList);
    }

    @Test
    public void addFirst() {

        actualList.addFirst(new TestObject("str0"));
        actualList.addFirst(new TestObject("str1"));
        actualList.addFirst(new TestObject("str2"));

        expectedList.addFirst(new TestObject("str0"));
        expectedList.addFirst(new TestObject("str1"));
        expectedList.addFirst(new TestObject("str2"));

        assertList(expectedList, actualList);
    }

    @Test
    public void set() {

        actualList.addFirst(new TestObject("str0"));
        actualList.addFirst(new TestObject("str1"));
        actualList.addFirst(new TestObject("str2"));
        actualList.addFirst(new TestObject("str3"));
        actualList.addFirst(new TestObject("str4"));

        expectedList.addFirst(new TestObject("str0"));
        expectedList.addFirst(new TestObject("str1"));
        expectedList.addFirst(new TestObject("str2"));
        expectedList.addFirst(new TestObject("str3"));
        expectedList.addFirst(new TestObject("str4"));

        assertEquals(expectedList.set(0, new TestObject("str5")), actualList.set(0, new TestObject("str5")));
        assertEquals(expectedList.set(4, new TestObject("str6")), actualList.set(4, new TestObject("str6")));

        assertList(expectedList, actualList);
        try {
            actualList.set(10, new TestObject(""));
        } catch (IndexOutOfBoundsException e) {
            return;
        } catch (Exception other) {
            fail();
        }
    }


    @Test
    public void indexOf() {
        actualList.addFirst(new TestObject("str0"));
        actualList.addFirst(new TestObject("str1"));
        actualList.addFirst(new TestObject("str2"));
        actualList.addFirst(new TestObject("str3"));
        actualList.addFirst(new TestObject("str4"));
        actualList.set(0, new TestObject("str2"));
        actualList.set(4, new TestObject("str6"));

        expectedList.addFirst(new TestObject("str0"));
        expectedList.addFirst(new TestObject("str1"));
        expectedList.addFirst(new TestObject("str2"));
        expectedList.addFirst(new TestObject("str3"));
        expectedList.addFirst(new TestObject("str4"));
        expectedList.set(0, new TestObject("str2"));
        expectedList.set(4, new TestObject("str6"));

        assertEquals(actualList.indexOf(new TestObject("str1")), expectedList.indexOf(new TestObject("str1")));
        assertEquals(actualList.indexOf(new TestObject("str0")), expectedList.indexOf(new TestObject("str0")));
        assertEquals(actualList.indexOf(new TestObject("str2")), expectedList.indexOf(new TestObject("str2")));
        assertEquals(actualList.indexOf(new TestObject("str3")), expectedList.indexOf(new TestObject("str3")));
        assertEquals(actualList.indexOf(new TestObject("str4")), expectedList.indexOf(new TestObject("str4")));
        assertEquals(actualList.indexOf(new TestObject("str5")), expectedList.indexOf(new TestObject("str5")));
        assertEquals(actualList.indexOf(new TestObject("str6")), expectedList.indexOf(new TestObject("str6")));
        assertEquals(actualList.indexOf(new TestObject("str7")), expectedList.indexOf(new TestObject("str7")));

    }

    @Test
    public void remove() {
        actualList.addFirst(new TestObject("str0"));
        actualList.addFirst(new TestObject("str1"));
        actualList.addFirst(new TestObject("str2"));
        actualList.addFirst(new TestObject("str3"));
        actualList.addFirst(new TestObject("str4"));
        actualList.set(0, new TestObject("str2"));
        actualList.set(4, new TestObject("str6"));

        expectedList.addFirst(new TestObject("str0"));
        expectedList.addFirst(new TestObject("str1"));
        expectedList.addFirst(new TestObject("str2"));
        expectedList.addFirst(new TestObject("str3"));
        expectedList.addFirst(new TestObject("str4"));
        expectedList.set(0, new TestObject("str2"));
        expectedList.set(4, new TestObject("str6"));
        assertEquals(expectedList.remove(4), actualList.remove(4));

        assertList(expectedList, actualList);

        actualList.remove(0);
        expectedList.remove(0);
        assertList(expectedList, actualList);

    }

    /**
     * Дополнительный тест
     */
    @Test
    public void iterator() {
        actualList.addFirst(new TestObject("str0"));
        actualList.addFirst(new TestObject("str1"));
        actualList.addFirst(new TestObject("str2"));
        actualList.addFirst(new TestObject("str3"));
        actualList.addFirst(new TestObject("str4"));
        actualList.set(0, new TestObject("str2"));
        actualList.set(4, new TestObject("str6"));
        actualList.remove(4);

        expectedList.addFirst(new TestObject("str0"));
        expectedList.addFirst(new TestObject("str1"));
        expectedList.addFirst(new TestObject("str2"));
        expectedList.addFirst(new TestObject("str3"));
        expectedList.addFirst(new TestObject("str4"));
        expectedList.set(0, new TestObject("str2"));
        expectedList.set(4, new TestObject("str6"));
        expectedList.remove(4);
        int i = 0;
        TestObject[] expected = new TestObject[expectedList.size()];
        for (TestObject s : expectedList) {
            expected[i++] = s;
        }

        i = 0;
        TestObject[] actual = new TestObject[actualList.size()];
        for (TestObject s : actualList) {
            actual[i++] = s;
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void iteratorRemove() {
        actualList.addFirst(new TestObject("str0"));
        actualList.addFirst(new TestObject("str1"));
        actualList.addFirst(new TestObject("str2"));
        actualList.addFirst(new TestObject("str3"));
        actualList.addFirst(new TestObject("str4"));
        actualList.set(0, new TestObject("str2"));
        actualList.set(4, new TestObject("str6"));

        expectedList.addFirst(new TestObject("str0"));
        expectedList.addFirst(new TestObject("str1"));
        expectedList.addFirst(new TestObject("str2"));
        expectedList.addFirst(new TestObject("str3"));
        expectedList.addFirst(new TestObject("str4"));
        expectedList.set(0, new TestObject("str2"));
        expectedList.set(4, new TestObject("str6"));


        int i = 0;
        for (Iterator<TestObject> it = expectedList.iterator(); it.hasNext(); ) {
            TestObject s = it.next();
            if (i++ == 4) {
                it.remove();
            }
        }

        i = 0;
        for (Iterator<TestObject> it = actualList.iterator(); it.hasNext(); ) {
            TestObject s = it.next();
            if (i++ == 4) {
                it.remove();
            }
        }
        assertList(expectedList, actualList);
    }

    @Test
    public void testIndexException() {
        checkIndexExcepion(() -> actualList.add(2, new TestObject("")));
        checkIndexExcepion(() -> actualList.set(2, new TestObject("")));
        checkIndexExcepion(() -> actualList.get(2));
        checkIndexExcepion(() -> actualList.remove(2));
        checkIndexExcepion(() -> actualList.add(0, new TestObject("")));

        checkIndexExcepion(() -> actualList.add(2, new TestObject("")));
        checkIndexExcepion(() -> actualList.set(2, new TestObject("")));
        checkIndexExcepion(() -> actualList.get(2));
        checkIndexExcepion(() -> actualList.remove(2));
    }

    private <T> void assertList(List<T> expected, DoubleLinkedList<T> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
        try {
            actual.get(expected.size());
        } catch (IndexOutOfBoundsException e) {
            return;
        } catch (Exception other) {
            fail();
        }
    }

    private void checkIndexExcepion(Runnable runnable) {
        try {
            runnable.run();
        } catch (IndexOutOfBoundsException e) {
            return;
        } catch (Exception other) {
            fail();
        }
    }

}