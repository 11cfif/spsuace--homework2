package ru.spsuace.homework2.collections.list;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

    LinkedList<String> expectedList;
    DoubleLinkedList<String> actualList;

    @Before
    public void setUp() throws Exception {
        expectedList = new LinkedList<>();
        actualList = new DoubleLinkedList<>();
    }

    @Test
    public void size() {
        assertList(expectedList, actualList);
    }

    @Test
    public void contains() {
        actualList.addLast("str0");
        actualList.addLast("str1");
        actualList.addLast("str2");

        expectedList.addLast( "str0");
        expectedList.addLast( "str1");
        expectedList.addLast("str2");
        assertEquals(expectedList.contains("str"), actualList.contains("str"));
        assertEquals(expectedList.contains("str1"), actualList.contains("str1"));
    }

    @Test
    public void clear() {
        actualList.add(0, "str");
        actualList.add(1, "str2");
        actualList.add(1, "str1");
        actualList.clear();

        expectedList.add(0, "str");
        expectedList.add(1, "str2");
        expectedList.add(1, "str1");
        expectedList.clear();
        assertList(expectedList, actualList);
    }

    @Test
    public void add() {
        actualList.add(0, "str");
        actualList.add(1, "str1");
        actualList.add(2, "str2");

        expectedList.add(0, "str");
        expectedList.add(1, "str1");
        expectedList.add(2, "str2");
        assertList(expectedList, actualList);
    }

    @Test
    public void addInMiddle() {
        actualList.add(0, "str");
        actualList.add(1, "str2");
        actualList.add(1, "str1");
        actualList.add(0, "str1");
        actualList.add(2, "str1");

        expectedList.add(0, "str");
        expectedList.add(1, "str2");
        expectedList.add(1, "str1");
        expectedList.add(0, "str1");
        expectedList.add(2, "str1");
        assertList(expectedList, actualList);
    }

    @Test
    public void addLast() {

        actualList.addLast("str0");
        actualList.addLast("str1");
        actualList.addLast("str2");

        expectedList.addLast( "str0");
        expectedList.addLast( "str1");
        expectedList.addLast("str2");

        assertList(expectedList, actualList);
    }

    @Test
    public void addFirst() {

        actualList.addFirst("str0");
        actualList.addFirst("str1");
        actualList.addFirst("str2");

        expectedList.addFirst( "str0");
        expectedList.addFirst( "str1");
        expectedList.addFirst("str2");

        assertList(expectedList, actualList);
    }

    @Test
    public void set() {

        actualList.addFirst("str0");
        actualList.addFirst("str1");
        actualList.addFirst("str2");
        actualList.addFirst("str3");
        actualList.addFirst("str4");
        actualList.set(0, "str5");
        actualList.set(4, "str6");

        expectedList.addFirst( "str0");
        expectedList.addFirst( "str1");
        expectedList.addFirst("str2");
        expectedList.addFirst("str3");
        expectedList.addFirst("str4");
        expectedList.set(0, "str5");
        expectedList.set(4, "str6");

        assertList(expectedList, actualList);
        try {
            actualList.set(10, "");
        } catch (IndexOutOfBoundsException e) {
            return;
        } catch (Exception other) {
            fail();
        }
    }


    @Test
    public void indexOf() {
        actualList.addFirst("str0");
        actualList.addFirst("str1");
        actualList.addFirst("str2");
        actualList.addFirst("str3");
        actualList.addFirst("str4");
        actualList.set(0, "str2");
        actualList.set(4, "str6");

        expectedList.addFirst( "str0");
        expectedList.addFirst( "str1");
        expectedList.addFirst("str2");
        expectedList.addFirst("str3");
        expectedList.addFirst("str4");
        expectedList.set(0, "str2");
        expectedList.set(4, "str6");

        assertEquals(actualList.indexOf("str1"), expectedList.indexOf("str1"));
        assertEquals(actualList.indexOf("str0"), expectedList.indexOf("str0"));
        assertEquals(actualList.indexOf("str2"), expectedList.indexOf("str2"));
        assertEquals(actualList.indexOf("str3"), expectedList.indexOf("str3"));
        assertEquals(actualList.indexOf("str4"), expectedList.indexOf("str4"));
        assertEquals(actualList.indexOf("str5"), expectedList.indexOf("str5"));
        assertEquals(actualList.indexOf("str6"), expectedList.indexOf("str6"));
        assertEquals(actualList.indexOf("str7"), expectedList.indexOf("str7"));

    }

    @Test
    public void remove() {
        actualList.addFirst("str0");
        actualList.addFirst("str1");
        actualList.addFirst("str2");
        actualList.addFirst("str3");
        actualList.addFirst("str4");
        actualList.set(0, "str2");
        actualList.set(4, "str6");
        actualList.remove(4);

        expectedList.addFirst( "str0");
        expectedList.addFirst( "str1");
        expectedList.addFirst("str2");
        expectedList.addFirst("str3");
        expectedList.addFirst("str4");
        expectedList.set(0, "str2");
        expectedList.set(4, "str6");
        expectedList.remove(4);

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
        actualList.addFirst("str0");
        actualList.addFirst("str1");
        actualList.addFirst("str2");
        actualList.addFirst("str3");
        actualList.addFirst("str4");
        actualList.set(0, "str2");
        actualList.set(4, "str6");
        actualList.remove(4);

        expectedList.addFirst( "str0");
        expectedList.addFirst( "str1");
        expectedList.addFirst("str2");
        expectedList.addFirst("str3");
        expectedList.addFirst("str4");
        expectedList.set(0, "str2");
        expectedList.set(4, "str6");
        int i = 0;
        String[] expected = new String[expectedList.size()];
        for (String s : expectedList) {
            expected[i++] = s;
        }

        i = 0;
        String[] actual = new String[actualList.size()];
      /**  for (String s : actualList) {
            actual[i++] = s;
        }*/
        assertArrayEquals(expected, actual);
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
}