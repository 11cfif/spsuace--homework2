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
    private int size;
    private LinkedItem<T> firstItem;
    private LinkedItem<T> lastItem;

    // ----------- 1 балл -----------

    public int size() {
        return size;
    }

    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    public void clear() {
        for (LinkedItem<T> currentLinkedItem = firstItem; currentLinkedItem != null; currentLinkedItem = currentLinkedItem.next) {
            currentLinkedItem.item = null;
            if (currentLinkedItem.prev != null) {
                currentLinkedItem.prev.next = null;
                currentLinkedItem.prev = null;
            }
        }
        size = 0;
        firstItem = null;
        lastItem = null;
    }

    public int indexOf(T o) {
        if (size == 0) {
            return -1;
        }

        int i = 0;

        for (LinkedItem<T> currentLinkedItem = firstItem; currentLinkedItem != null; currentLinkedItem = currentLinkedItem.next, i++) {
            if (Objects.equals(currentLinkedItem.item, o)) {
                return i;
            }
        }
        return -1;
    }

    // ----------- 1 балл -----------

    public void add(int index, T element) {
        if (size < index) {
            throw new IndexOutOfBoundsException();
        }

        if (size == index) {
            addLast(element);
        } else {
            LinkedItem<T> currentLinkedItem = firstItem;

            for (int i = 0; i < index; i++) {
                currentLinkedItem = currentLinkedItem.next;
            }
            LinkedItem<T> newLinkedItem = new LinkedItem<T>(element, currentLinkedItem.prev, currentLinkedItem);

            currentLinkedItem.prev = newLinkedItem;

            if (newLinkedItem.prev == null) {
                firstItem = newLinkedItem;
            } else {
                newLinkedItem.prev.next = newLinkedItem;
            }

            if (newLinkedItem.next == null) {
                lastItem = newLinkedItem;
            }

            size++;
        }
    }

    public void addLast(T element) {
        if (lastItem == null) {
            lastItem = new LinkedItem<T>(element, null, null);
            firstItem = lastItem;
        } else {
            LinkedItem<T> newLinkedItem = new LinkedItem<T>(element, lastItem, null);
            lastItem.next = newLinkedItem;
            lastItem = newLinkedItem;
        }

        size++;
    }


    public void addFirst(T element) {
        if (firstItem == null) {
            firstItem = new LinkedItem<T>(element, null, null);
            lastItem = firstItem;
        } else {
            LinkedItem<T> newLinkedItem = new LinkedItem<T>(element, null, firstItem);
            firstItem.prev = newLinkedItem;
            firstItem = newLinkedItem;
        }

        size++;
    }

    // ----------- 1 балл -----------

    public T set(int index, T element) {
        if (size < index) {
            throw new IndexOutOfBoundsException();
        }

        if (size == index) {
            addLast(element);
            return  null;
        } else {

            LinkedItem<T> currentLinkedItem = firstItem;

            for (int i = 0; i < index; i++) {
                currentLinkedItem = currentLinkedItem.next;
            }

            LinkedItem<T> newLinkedItem = new LinkedItem<T>(element, currentLinkedItem.prev, currentLinkedItem.next);
            T oldElement = currentLinkedItem.item;
            currentLinkedItem.item = null;
            currentLinkedItem.prev = null;
            currentLinkedItem.next = null;

            if (newLinkedItem.prev == null) {
                firstItem = newLinkedItem;
            } else {
                newLinkedItem.prev.next = newLinkedItem;
            }

            if (newLinkedItem.next == null) {
                lastItem = newLinkedItem;
            } else {
                newLinkedItem.next.prev = newLinkedItem;
            }

            return oldElement;
        }
    }

    public T get(int index) {
        if (size - 1 < index) {
            throw new IndexOutOfBoundsException();
        }

        LinkedItem<T> currentLinkedItem = firstItem;

        for (int i = 0; i < index; i++) {
            currentLinkedItem = currentLinkedItem.next;
        }

        return currentLinkedItem.item;
    }

    public T remove(int index) {
        if (size - 1 < index) {
            throw new IndexOutOfBoundsException();
        }

        LinkedItem<T> currentLinkedItem = firstItem;

        for (int i = 0; i < index; i++) {
            currentLinkedItem = currentLinkedItem.next;
        }

        return remove(currentLinkedItem);
    }

    private T remove(LinkedItem<T> linkedItem) {
        if (linkedItem.prev == null) {
            firstItem = linkedItem.next;
        } else {
            linkedItem.prev.next = linkedItem.next;
        }

        if (linkedItem.next == null) {
            lastItem = linkedItem.prev;
        } else {
            linkedItem.next.prev = linkedItem.prev;
        }

        T oldElement = linkedItem.item;
        linkedItem.item = null;
        linkedItem.prev = null;
        linkedItem.next = null;

        size--;

        return oldElement;
    }


    /**
     * Надо реализовать свой итератор, который будет последовательно идти с первого по последний элемент
     * 3 балла
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator<T>(this);
    }

    private static class DoubleLinkedListIterator<T> implements Iterator<T> {
        private LinkedItem<T> currentLinkedItem;
        private DoubleLinkedList<T> doubleLinkedList;

        public DoubleLinkedListIterator(DoubleLinkedList<T> doubleLinkedItem) {
            this.currentLinkedItem = new LinkedItem<T>(null, null, doubleLinkedItem.firstItem);
            this.doubleLinkedList = doubleLinkedItem;
        }

        @Override
        public boolean hasNext() {
            return currentLinkedItem.next != null;
        }

        @Override
        public T next() {
            currentLinkedItem = currentLinkedItem.next;

            if (currentLinkedItem == null) {
                throw new NoSuchElementException();
            }

            return currentLinkedItem.item;
        }

        @Override
        public void remove() {
            doubleLinkedList.remove(currentLinkedItem);
        }
    }

    private static class LinkedItem<T> {
        private T item;
        private LinkedItem<T> prev;
        private LinkedItem<T> next;

        public LinkedItem (T item, LinkedItem<T> prev, LinkedItem<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
