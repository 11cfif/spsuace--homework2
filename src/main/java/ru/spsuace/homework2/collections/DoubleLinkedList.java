package ru.spsuace.homework2.collections;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    private static class ListElement<T> {
        T data;
        ListElement<T> next, prev;
    }

    private ListElement<T> head, tail;
    private int count;

    public DoubleLinkedList() {
        count = 0;
        head = null;
        tail = null;
    }

    public int size() {
        return count;
    }

    public boolean contains(Object o) {
        if (o == null) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < size(); i++) {
            if (o.equals(get(i))) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        if (index == 0) {
            addFirst(element);
        } else {
            ListElement<T> additionalList = new ListElement<T>();
            additionalList = transitionToElement( index - 1);
            ListElement<T> listElement = new ListElement<T>();
            listElement.next = additionalList.next;
            listElement.data = element;
            listElement.prev = additionalList;
            additionalList.next = listElement;
            if (index  == size()) {
                tail = listElement;
            }
            count++;
        }
    }

    public void addLast(T element) {
        ListElement<T> listElement = new ListElement<T>();
        listElement.data = element;
        listElement.prev = tail;
        if (size() == 0) {
            head = listElement;
            tail = listElement;
        }
        if (size() != 0) {
            tail.next = listElement;
        }
        tail = listElement;
        count++;
    }

    public void addFirst(T element) {
        ListElement<T> listElement = new ListElement<T>();
        listElement.data = element;
        if (size() == 0) {
            tail = listElement;
        }
        if (size() != 0) {
            head.prev = listElement;
        }
        listElement.next = head;

        head = listElement;
        count++;
    }

    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        ListElement<T> listElement = head;
        listElement = transitionToElement(index);
        T replaceableElement = listElement.data;
        listElement.data = element;
        return replaceableElement;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        ListElement<T> listElement = head;
        for (int i = 0; i < index; i++) {
            listElement = listElement.next;
        }
        return listElement.data;
    }

    public int indexOf(T o) {
        int index = -1;
        ListElement<T> listElement = head;
        for (int i = 0; i < size(); i++) {
            if (listElement.data.equals(o)) {
                return i;
            }
            listElement = listElement.next;
        }
        return index;
    }

    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        ListElement<T> listElement = head;
        listElement =transitionToElement(index - 1);
        T removableElement = listElement.next.data;
        if (index == 0) {
            removableElement = listElement.data;
            head = listElement.next;
        } else if (index == size() - 1) {
            listElement.next.data = null;
            listElement.next = null;
        } else {
            listElement.next = listElement.next.next;
            listElement.next.prev = listElement;
        }
        count--;
        return removableElement;
    }

    public ListElement<T> transitionToElement(int index) {
        ListElement<T> listElement = new ListElement<>();
        if (index < size()/2 + 1) {
            listElement = head;
            int i = 0;
            while (i < index) {
                listElement = listElement.next;
                i++;
            }
        } else {
            listElement = tail;
            int i = 0;
            while (i < size() - index - 1) {
                listElement = listElement.prev;
                i++;
            }
        }
        return listElement;
    }

    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
