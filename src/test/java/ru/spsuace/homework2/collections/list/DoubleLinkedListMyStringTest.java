package ru.spsuace.homework2.collections.list;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListMyStringTest {

    LinkedList<MyString> expectedList;
    DoubleLinkedList<MyString> actualList;

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
        actualList.addLast(new MyString("str0"));
        actualList.addLast(new MyString("str1"));
        actualList.addLast(new MyString("str2"));

        expectedList.addLast( new MyString("str0"));
        expectedList.addLast( new MyString("str1"));
        expectedList.addLast(new MyString("str2"));
        assertEquals(expectedList.contains(new MyString("str")), actualList.contains(new MyString("str")));
        assertEquals(expectedList.contains(new MyString("str1")), actualList.contains(new MyString("str1")));
    }

    @Test
    public void clear() {
        actualList.add(0, new MyString("str"));
        actualList.add(1, new MyString("str2"));
        actualList.add(1, new MyString("str1"));
        actualList.clear();

        expectedList.add(0, new MyString("str"));
        expectedList.add(1, new MyString("str2"));
        expectedList.add(1, new MyString("str1"));
        expectedList.clear();
        assertList(expectedList, actualList);
    }

    @Test
    public void add() {
        actualList.add(0, new MyString("str"));
        actualList.add(1, new MyString("str1"));
        actualList.add(2, new MyString("str2"));

        expectedList.add(0, new MyString("str"));
        expectedList.add(1, new MyString("str1"));
        expectedList.add(2, new MyString("str2"));
        assertList(expectedList, actualList);
    }

    @Test
    public void addInMiddle() {
        actualList.add(0, new MyString("str"));
        actualList.add(1, new MyString("str2"));
        actualList.add(1, new MyString("str1"));
        actualList.add(0, new MyString("str1"));
        actualList.add(2, new MyString("str1"));

        expectedList.add(0, new MyString("str"));
        expectedList.add(1, new MyString("str2"));
        expectedList.add(1, new MyString("str1"));
        expectedList.add(0, new MyString("str1"));
        expectedList.add(2, new MyString("str1"));
        assertList(expectedList, actualList);
    }

    @Test
    public void addLast() {

        actualList.addLast(new MyString("str0"));
        actualList.addLast(new MyString("str1"));
        actualList.addLast(new MyString("str2"));

        expectedList.addLast( new MyString("str0"));
        expectedList.addLast( new MyString("str1"));
        expectedList.addLast(new MyString("str2"));

        assertList(expectedList, actualList);
    }

    @Test
    public void addFirst() {

        actualList.addFirst(new MyString("str0"));
        actualList.addFirst(new MyString("str1"));
        actualList.addFirst(new MyString("str2"));

        expectedList.addFirst( new MyString("str0"));
        expectedList.addFirst( new MyString("str1"));
        expectedList.addFirst(new MyString("str2"));

        assertList(expectedList, actualList);
    }

    @Test
    public void set() {

        actualList.addFirst(new MyString("str0"));
        actualList.addFirst(new MyString("str1"));
        actualList.addFirst(new MyString("str2"));
        actualList.addFirst(new MyString("str3"));
        actualList.addFirst(new MyString("str4"));
        actualList.set(0, new MyString("str5"));
        actualList.set(4, new MyString("str6"));

        expectedList.addFirst( new MyString("str0"));
        expectedList.addFirst( new MyString("str1"));
        expectedList.addFirst(new MyString("str2"));
        expectedList.addFirst(new MyString("str3"));
        expectedList.addFirst(new MyString("str4"));
        expectedList.set(0, new MyString("str5"));
        expectedList.set(4, new MyString("str6"));

        assertList(expectedList, actualList);
        try {
            actualList.set(10, new MyString(""));
        } catch (IndexOutOfBoundsException e) {
            return;
        } catch (Exception other) {
            fail();
        }
    }


    @Test
    public void indexOf() {
        actualList.addFirst(new MyString("str0"));
        actualList.addFirst(new MyString("str1"));
        actualList.addFirst(new MyString("str2"));
        actualList.addFirst(new MyString("str3"));
        actualList.addFirst(new MyString("str4"));
        actualList.set(0,new MyString( "str2"));
        actualList.set(4,new MyString( "str6"));

        expectedList.addFirst( new MyString("str0"));
        expectedList.addFirst( new MyString("str1"));
        expectedList.addFirst(new MyString("str2"));
        expectedList.addFirst(new MyString("str3"));
        expectedList.addFirst(new MyString("str4"));
        expectedList.set(0,new MyString( "str2"));
        expectedList.set(4,new MyString( "str6"));

        assertEquals(actualList.indexOf(new MyString("str1")), expectedList.indexOf(new MyString("str1")));
        assertEquals(actualList.indexOf(new MyString("str0")), expectedList.indexOf(new MyString("str0")));
        assertEquals(actualList.indexOf(new MyString("str2")), expectedList.indexOf(new MyString("str2")));
        assertEquals(actualList.indexOf(new MyString("str3")), expectedList.indexOf(new MyString("str3")));
        assertEquals(actualList.indexOf(new MyString("str4")), expectedList.indexOf(new MyString("str4")));
        assertEquals(actualList.indexOf(new MyString("str5")), expectedList.indexOf(new MyString("str5")));
        assertEquals(actualList.indexOf(new MyString("str6")), expectedList.indexOf(new MyString("str6")));
        assertEquals(actualList.indexOf(new MyString("str7")), expectedList.indexOf(new MyString("str7")));

    }

    @Test
    public void remove() {
        actualList.addFirst(new MyString("str0"));
        actualList.addFirst(new MyString("str1"));
        actualList.addFirst(new MyString("str2"));
        actualList.addFirst(new MyString("str3"));
        actualList.addFirst(new MyString("str4"));
        actualList.set(0, new MyString("str2"));
        actualList.set(4, new MyString("str6"));
        actualList.remove(4);

        expectedList.addFirst( new MyString("str0"));
        expectedList.addFirst( new MyString("str1"));
        expectedList.addFirst(new MyString("str2"));
        expectedList.addFirst(new MyString("str3"));
        expectedList.addFirst(new MyString("str4"));
        expectedList.set(0,new MyString( "str2"));
        expectedList.set(4, new MyString("str6"));
        expectedList.remove(4);
        assertList(expectedList, actualList);

        actualList.remove(0);
        expectedList.remove(0);
        assertList(expectedList, actualList);

    }

    /**
     * Дополнительный тест
     */
//    @Test
//    public void iterator() {
//        actualList.addFirst(new MyString("str0"));
//        actualList.addFirst(new MyString("str1"));
//        actualList.addFirst(new MyString("str2"));
//        actualList.addFirst(new MyString("str3"));
//        actualList.addFirst(new MyString("str4"));
//        actualList.set(0, new MyString("str2"));
//        actualList.set(4,new MyString( "str6"));
//        actualList.remove(4);
//
//        expectedList.addFirst( new MyString("str0"));
//        expectedList.addFirst( new MyString("str1"));
//        expectedList.addFirst(new MyString("str2"));
//        expectedList.addFirst(new MyString("str3"));
//        expectedList.addFirst(new MyString("str4"));
//        expectedList.set(0, new MyString("str2"));
//        expectedList.set(4, new MyString("str6"));
//        int i = 0;
//        MyString[] expected = new MyString[expectedList.size()];
//        for (MyString s : expectedList) {
//            expected[i++] = s;
//        }
//
//        i = 0;
//        MyString[] actual = new MyString[actualList.size()];
//        for (MyString s : actualList) {
//            actual[i++] = s;
//        }
//        assertArrayEquals(expected, actual);
//    }

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
    
    class MyString {
        private final String str;

        MyString(String str) {
            this.str = str;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == this) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (!getClass().equals(obj.getClass())) {
                return false;
            }

            MyString temp = (MyString)obj;
            if (temp.str == this.str) {
                return true;
            }

            return false;

        }

    }
}