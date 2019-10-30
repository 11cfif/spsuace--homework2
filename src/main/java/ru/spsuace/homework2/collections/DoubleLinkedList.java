package ru.spsuace.homework2.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.UnaryOperator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private ListElement first;
    private ListElement last;
    private int counter;

    public int size() {
        return counter;
    }

    public boolean contains(Object o) {
        ListElement<T> desired = last;
        for (int i = 0; i < size(); i++){
            if (desired.data.equals(o)) return true;
            desired = desired.prev;
        }
        return false;
    }

    public void clear() {
        first = null;
        last = null;
        counter = 0;
    }

    public void add(int index, T element) {
        if (index > counter || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == counter && index!=0) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            ListElement<T> newElement = new ListElement<>(element);
            ListElement<T> currentElement = findElement(index);
            currentElement.prev.next = newElement;
            newElement.prev = currentElement.prev;
            currentElement.prev = newElement;
            newElement.next = currentElement;
            counter++;
        }

    }

    public void addLast(T element) {
        ListElement<T> newElement = new ListElement<T>(element);
        if (last == null){
            first = newElement;
            last = newElement;
        } else {
            last.next = newElement;
            newElement.prev = last;
            last = newElement;
        }
        counter++;
    }


    public void addFirst(T element) {
        ListElement<T> newElement = new ListElement<T>(element);
        if (last == null){
            first = newElement;
            last = newElement;
        } else {
            first.prev = newElement;
            newElement.next = first;
            first = newElement;
        }
        counter++;
    }


    public T set(int index, T element) {
        if (index >= counter || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ListElement<T> currentElement = findElement(index);
        T currentData = currentElement.data;
        currentElement.data = element;
        return  currentData;
    }

    public T get(int index) {
        if (index >= counter || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ListElement<T> currentElement = findElement(index);
        return currentElement.data;
    }

    public int indexOf(T o) {
        ListElement<T> currentElement = first;
        for (int i = 0; i < counter; i++) {
            if (currentElement.data == o) return i;
            currentElement = currentElement.next;
        }
        return -1;
    }

    public T remove(int index) {
        if (index >= counter || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ListElement<T> currentElement = findElement(index);
        T currentData = currentElement.data;
        if (index == counter - 1) {
            currentElement.prev.next = null;
            last = currentElement.prev;
        } else if (index == 0) {
            currentElement.next.prev = null;
            first = currentElement.next;
        } else {
            currentElement.prev.next = currentElement.next;
            currentElement.next.prev = currentElement.prev;
        }
        counter--;
        return currentData;
    }

    public ListElement<T> findElement(int index){
        ListElement<T> desired;
        if (index < counter / 2) {
            desired = first;
            for (int i = 0; i < index; i++) {
                desired = desired.next;
            }
        } else {
            desired = last;
            for (int i = 0; i < index; i++) {
                desired = desired.prev;
            }
        }
        return desired;
    }

    private class ListElement<T> {
        private ListElement prev;
        private ListElement next;
        private T data;
        ListElement(T listElement){
            this.data = listElement;
        }
    }
    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
