package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    private class Node<T> {
        private Node next;
        private Node prev;
        private T data;
    }

    private Node<T> last;
    private Node<T> first;
    private int counter;

    public DoubleLinkedList() {
        counter = 0;
        last = null;
        first = null;
    }

    public int size() {
        return counter;
    }

    public boolean contains(Object o) {
        return (indexOf((T) o) != -1);
    }

    public void clear() {
        last = null;
        first = null;
        counter = 0;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        } else  if (index == 0) {
            addFirst(element);
        } else if (index == size()) {
            addLast(element);
        } else {
            Node<T> additionalElement = transitionToElement( index - 1);
            Node<T> listElement = new Node<T>();
            listElement.next = additionalElement.next;
            additionalElement.next.prev = listElement;
            listElement.prev = additionalElement;
            listElement.data = element;
            additionalElement.next = listElement;
            counter++;
        }

    }

    private Node<T> transitionToElement(int index) {
        Node<T> listElement = new Node<>();
        if (index < size() / 2 + 1) {
            listElement = last;
            int i = 0;
            while (i < index) {
                listElement = listElement.next;
                i++;
            }
        } else {
            listElement = first;
            int i = 0;
            while (i < size() - index - 1) {
                listElement = listElement.prev;
                i++;
            }
        }
        return listElement;
    }

    public void addLast(T element) {
        Node<T> listElement = new Node<T>();
        listElement.data = element;
        listElement.prev = first;
        if (size() == 0) {
            last = listElement;
            first = listElement;
        } else {
            first.next = listElement;
        }
        first = listElement;
        counter++;
    }


    public void addFirst(T element) {
        Node<T> listElement = new Node<T>();
        listElement.data = element;
        if (size() == 0) {
            first = listElement;
        } else {
            last.prev = listElement;
        }
        listElement.next = last;
        last = listElement;
        counter++;
    }


    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node<T> listElement = last;
        listElement = transitionToElement(index);
        T replaceableElement = listElement.data;
        listElement.data = element;
        return replaceableElement;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node<T> listElement = last;
        listElement = transitionToElement(index);
        return listElement.data;
    }

    public int indexOf(T o) {
        int index = -1;
        Node<T> listElement = last;
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
        Node<T> listElement = last;
        listElement =transitionToElement(index - 1);
        T removableElement = (T) listElement.next.data;
        if (index == 0) {
            removableElement = listElement.data;
            last = listElement.next;
        } else if (index == size() - 1) {
            listElement.next.data = null;
            listElement.next = null;
            first = listElement;
        } else {
            listElement.next = listElement.next.next;
            listElement.next.prev = listElement;
        }
        counter--;
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
