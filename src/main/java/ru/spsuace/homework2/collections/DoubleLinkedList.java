package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    private static class Element<T> {
        T data;
        Element<T> next;
        Element<T> prev;
    }

    private Element<T> head;
    private Element<T> tail;
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
        return indexOf((T) o) > -1;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        } else  if (index == 0) {
            addFirst(element);
        } else if (index == size()) {
            addLast(element);
        } else {
            Element<T> additionalElement = transitionToElement( index - 1);
            Element<T> listElement = new Element<T>();
            listElement.next = additionalElement.next;
            additionalElement.next.prev = listElement;
            listElement.prev = additionalElement;
            listElement.data = element;
            additionalElement.next = listElement;
            count++;
        }
    }

    public void addLast(T element) {
        Element<T> listElement = new Element<T>();
        listElement.data = element;
        listElement.prev = tail;
        if (size() == 0) {
            head = listElement;
            tail = listElement;
        } else {
            tail.next = listElement;
        }
        tail = listElement;
        count++;
    }

    public void addFirst(T element) {
        Element<T> listElement = new Element<T>();
        listElement.data = element;
        if (size() == 0) {
            tail = listElement;
        } else {
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
        Element<T> listElement = head;
        listElement = transitionToElement(index);
        T replaceableElement = listElement.data;
        listElement.data = element;
        return replaceableElement;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Element<T> listElement = head;
        listElement = transitionToElement(index);
        return listElement.data;
    }

    public int indexOf(T o) {
        int index = -1;
        Element<T> listElement = head;
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
        Element<T> listElement = head;
        listElement =transitionToElement(index - 1);
        T removableElement = listElement.next.data;
        if (index == 0) {
            removableElement = listElement.data;
            head = listElement.next;
        } else if (index == size() - 1) {
            listElement.next.data = null;
            listElement.next = null;
            tail = listElement;
        } else {
            listElement.next = listElement.next.next;
            listElement.next.prev = listElement;
        }
        count--;
        return removableElement;
    }

    private Element<T> transitionToElement(int index) {
        Element<T> listElement = new Element<>();
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
