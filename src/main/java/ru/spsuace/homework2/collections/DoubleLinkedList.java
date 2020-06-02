package ru.spsuace.homework2.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 * Полный балл - 6
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    private LinkedItem first;
    private LinkedItem last;
    private int size;

    private class LinkedItem<T> {
        private LinkedItem<T> previous;
        private LinkedItem<T> next;
        private T data;

        LinkedItem(T data) {
            this.data = data;
        }
    }


    // ----------- 1 балл -----------

    public int size() {
        return size;
    }

    public boolean contains(T o) {
        return indexOf(o) != -1;

    }

    public void clear() {

        size = 0;
        first = null;
        last = null;
    }

    public int indexOf(T o) {
        LinkedItem<T> currentElement = first;
        int index = 0;
        while (currentElement != null) {
            if (currentElement.data.equals(o)) {
                return index;
            }
            currentElement = currentElement.next;
            index++;
        }
        return -1;
    }

    // ----------- 1 балл -----------

    public void add(int index, T data) {
        if (index == size) {
            addLast(data);
            return;
        }

        indexBoundsCheck(index);

        if (index == 0) {
            addFirst(data);
        } else {
            LinkedItem<T> newLinkedItem = new LinkedItem(data);
            LinkedItem<T> oldLinkedItem = getLinkedItem(index);
            newLinkedItem.previous = oldLinkedItem.previous;
            newLinkedItem.next = oldLinkedItem;
            oldLinkedItem.previous.next = newLinkedItem;
            oldLinkedItem.previous = newLinkedItem;
            size++;
        }
    }


    public void addLast(T data) {
        LinkedItem<T> newLinkedItem = new LinkedItem(data);
        if (size == 0) {
            first = newLinkedItem;
            last = newLinkedItem;
        } else {
            newLinkedItem.previous = last;
            last.next = newLinkedItem;
            last = newLinkedItem;
        }
        size++;
    }

    public void addFirst(T data) {
        LinkedItem<T> newLinkedItem = new LinkedItem(data);
        if (size == 0) {
            first = newLinkedItem;
            last = newLinkedItem;
        } else {
            newLinkedItem.next = first;
            first.previous = newLinkedItem;
            first = newLinkedItem;
        }
        size++;
    }


    // ----------- 1 балл -----------

    public T set(int index, T data) {
        indexBoundsCheck(index);
        LinkedItem<T> element = getLinkedItem(index);
        T oldData = element.data;
        element.data = data;
        return oldData;
    }


    public T get(int index) {
        indexBoundsCheck(index);
        LinkedItem<T> element = getLinkedItem(index);
        return element.data;
    }


    public T remove(int index) {
        indexBoundsCheck(index);
        LinkedItem<T> element = getLinkedItem(index);

        if (index == 0) {
            element.next.previous = null;
            first = element.next;
        } else if (index == size - 1) {
            element.previous.next = null;
            last = element.previous;
        } else {
            element.previous.next = element.next;
            element.next.previous = element.previous;
        }

        size--;
        return element.data;
    }

    private void indexBoundsCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private LinkedItem<T> getLinkedItem(int index) {
        indexBoundsCheck(index);
        LinkedItem<T> currentElement;

        if (index > size / 2) {
            currentElement = last;
            for (int i = size - 1; i > index; i--) {
                currentElement = currentElement.previous;
            }
        } else {
            currentElement = first;
            for (int i = 0; i < index; i++) {
                currentElement = currentElement.next;
            }
        }

        return currentElement;
    }

    /**
     * Надо реализовать свой итератор, который будет последовательно идти с первого по последний элемент
     * 3 балла
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator<T> implements Iterator<T> {

        LinkedItem<T> currentElement;
        int currentIndex;

        public DoubleLinkedListIterator() {
            currentElement = first;
            currentIndex = -1;
        }

        @Override
        public boolean hasNext() {
            return currentElement != null;
        }

        @Override
        public T next() {
            T currentData = currentElement.data;
            currentElement = currentElement.next;
            currentIndex++;
            return currentData;
        }

        @Override
        public void remove() {
            DoubleLinkedList.this.remove(currentIndex);
        }
    }
}