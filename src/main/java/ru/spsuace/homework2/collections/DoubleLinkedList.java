package ru.spsuace.homework2.collections;

import java.util.Iterator;
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
    private NodeItem<T> firstItem;
    private NodeItem<T> lastItem;
    // ----------- 1 балл -----------

    public int size() {
        return size;
    }

    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    public NodeItem<T> thisItem(int index) {
        NodeItem<T> currentItem = firstItem;
        for (int i = 0; i < index; i++) {
            currentItem = currentItem.next;
        }
        return currentItem;
    }

    public void clear() {
        size = 0;
        lastItem = null;
        firstItem = null;
    }

    public int indexOf(T o) {
        if (size == 0) {
            return -1;
        }

        int i = 0;

        for (NodeItem<T> currentItem = firstItem; currentItem != null; currentItem = currentItem.next, i++) {
            if (Objects.equals(currentItem.item, o)) {
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
        if (0 == index) {
            addFirst(element);
        } else if (size == index) {
            addLast(element);
        } else {
            NodeItem<T> currentItem = thisItem(index);
            NodeItem<T> newItem = new NodeItem<T>(element, currentItem.prev, currentItem);
            currentItem.prev.next = newItem;
            newItem.prev = currentItem.prev;
            currentItem.prev = newItem;
            newItem.next = currentItem;
            size++;
        }
    }

    public void addLast(T element) {
        if (lastItem == null) {
            lastItem = new NodeItem<T>(element, null, null);
            firstItem = lastItem;
        } else {
            NodeItem<T> newItem = new NodeItem<T>(element, lastItem, null);
            lastItem.next = newItem;
            lastItem = newItem;
        }
        size++;
    }


    public void addFirst(T element) {
        if (firstItem == null) {
            firstItem = new NodeItem<T>(element, null, null);
            lastItem = firstItem;
        } else {
            NodeItem<T> newItem = new NodeItem<T>(element, null, firstItem);
            firstItem.prev = newItem;
            firstItem = newItem;
        }
        size++;
    }


    // ----------- 1 балл -----------

    public T set(int index, T element) {
        if (size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 1) {
            addFirst(element);
        } else if (size == index) {
            addLast(element);
        } else {
            NodeItem<T> currentItem = thisItem(index);
            T tempItem = currentItem.item;
            currentItem.item = element;
            return tempItem;
        }
        return null;
    }

    public T get(int index) {
        if (size - 1 < index) {
            throw new IndexOutOfBoundsException();
        }
        NodeItem<T> currentItem = thisItem(index);
        return currentItem.item;
    }

    public T remove(int index) {

        if (size - 1 < index) {
            throw new IndexOutOfBoundsException();
        }
        // if (index==size){
        //  remove(lastItem);
        //}
        //if (index==1){
        // remove(firstItem);
        //}
        NodeItem<T> currentItem = thisItem(index);
        return remove(currentItem);

    }

    public T remove(NodeItem<T> currentItem) {
        T tempItem = currentItem.item;
        if (currentItem.prev == null) {
            firstItem = currentItem.next;
        } else {
            currentItem.prev.next = currentItem.next;
        }
        if (currentItem.next == null) {
            lastItem = currentItem.prev;
        } else {
            currentItem.next.prev = currentItem.prev;
        }

        currentItem.next = currentItem.prev;
        currentItem.prev = currentItem.next;
        size--;
        return tempItem;
    }


    /**
     * Надо реализовать свой итератор, который будет последовательно идти с первого по последний элемент
     * 3 балла
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator<T>(this);
    }

    private class DoubleLinkedListIterator<T> implements Iterator<T> {
        private NodeItem<T> currentItem;
        private DoubleLinkedList<T> doubleItem;

        public DoubleLinkedListIterator(DoubleLinkedList<T> doubleItem) {
            this.currentItem = new NodeItem<T>(null, null, doubleItem.firstItem);
            this.doubleItem = doubleItem;
        }

        @Override
        public boolean hasNext() {
            return currentItem.next != null;
        }

        @Override
        public T next() {
            currentItem = currentItem.next;
            if (currentItem == null) {
                return null;
            }
            return currentItem.item;
        }

        @Override
        public void remove() {
            doubleItem.remove(currentItem);
        }
    }

    public static class NodeItem<T> {
        public T item;
        public NodeItem<T> prev;
        public NodeItem<T> next;

        public NodeItem(T item, NodeItem<T> prev, NodeItem<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}