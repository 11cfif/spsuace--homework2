package ru.spsuace.homework2.collections;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private static class Component<T> {
        T data;
        Component<T> next, prev;
    }
    private Component head, tail;
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
            int i = 0;
            Component<T> additionalList = head;
            while (i < index - 1) {
                additionalList = additionalList.next;
                i++;
            }
            Component<T> list = new Component<T>();
            list.next = additionalList.next;
            list.data = element;
            list.prev = additionalList;
            additionalList.next = list;
            count++;
        }
    }
    public void addLast(T element) {
        Component<T> list = new Component<T>();
        list.data = element;
        list.prev = tail;
        if (count == 0) {
            head = list;
        }
        if (count != 0) {
            tail.next = list;
        }
        tail = list;
        count++;
    }
    public void addFirst(T element) {
        Component<T> list = new Component<T>();
        list.data = element;
        list.next = head;
        head = list;
        count++;
    }
    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        int i = 0;
        Component<T> list = head;
        while (i < index) {
            list = list.next;
            i++;
        }
        T replaceableElement = list.data;
        list.data = element;
        return replaceableElement;
    }
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Component<T> list = head;
        for (int i = 0; i < index; i++) {

            list = list.next;
        }
        return list.data;
    }
    public int indexOf(T o) {
        int index = -1;
        Component<T> list = head;
        for (int i = 0; i < count; i++) {
            if (list.data.equals(o)) {
                return i;
            }
            list = list.next;
        }
        return index;
    }
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        int i = 0;
        Component<T> list = head;
        while (i < index - 1) {
            list = list.next;
            i++;
        }
        T removableElement = (T) list.next.data;
        if (index == 0) {
            removableElement = list.data;
            head = list.next;
        } else if (index == count - 1) {
            list.next.data = null;
            list.next = null;
        } else {
            list.next = list.next.next;
        }
        count--;
        return removableElement;
    }


    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
