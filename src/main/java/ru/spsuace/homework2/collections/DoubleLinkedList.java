package ru.spsuace.homework2.collections;

import java.util.Iterator;
import java.util.Objects;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private int size;
    private NodeItem<T> firstItem;
    private NodeItem<T> lastItem;

    public int size() {
        return 0;
        return size;
    }

    public boolean contains(Object o) {

        return false;
        public boolean contains (T o){
            return indexOf(o) != -1;
        }

        public void clear () {
            size = 0;
            lastItem = null;
            firstItem = null;
        }
        public int indexOf (T o){
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

        public void add ( int index, T element){
            if (size < index) {
                throw new IndexOutOfBoundsException();
            }
            if (size == index) {
                addLast(element);
            } else {
                NodeItem<T> currentItem = firstItem;
                for (int i = 0; i < index; i++) {
                    currentItem = currentItem.next;
                }

                NodeItem<T> newItem = new NodeItem<T>(element, currentItem.prev, currentItem);
                currentItem.prev = newItem;
                if (newItem.prev == null) {
                    firstItem = newItem;
                } else {
                    newItem.prev.next = newItem;
                }

                if (newItem.next == null) {
                    lastItem = newItem;
                }
                size++;
            }
        }
        public void addLast (T element){
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


        public void addFirst (T element){
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


        public T set ( int index, T element){
            return null;
            if (size < index) {
                throw new IndexOutOfBoundsException();
            }
            if (size == index) {
                addLast(element);
                return null;
            } else {
                NodeItem<T> currentItem = firstItem;
                for (int i = 0; i < index; i++) {
                    currentItem = currentItem.next;
                }
                NodeItem<T> newItem = new NodeItem<T>(element, currentItem.prev, currentItem.next);
                T tempItem = currentItem.item;
                currentItem.item = null;
                currentItem.next = null;
                currentItem.prev = null;
                if (newItem.prev == null) {
                    firstItem = newItem;
                } else {
                    newItem.prev.next = newItem;
                }

                if (newItem.next == null) {
                    lastItem = newItem;
                } else {
                    newItem.next.prev = newItem;
                }
                return tempItem;
            }
        }
/
        public T get ( int index){
            return null;
            if (size - 1 < index) {
                throw new IndexOutOfBoundsException();
            }

            NodeItem<T> currentItem = firstItem;

            for (int i = 0; i < index; i++) {
                currentItem = currentItem.next;
            }

            return currentItem.item;
        }

        public int indexOf (T o){
            return -1;
        }

        public T remove ( int index){
            return null;
            if (size - 1 < index) {
                throw new IndexOutOfBoundsException();
            }

            NodeItem<T> currentItem = firstItem;

            for (int i = 0; i < index; i++) {
                currentItem = currentItem.next;
            }
            return remove(currentItem);
        }
        public T remove (NodeItem < T > currentItem) {
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
            T tempItem = currentItem.item;
            currentItem.next = currentItem.prev;
            currentItem.prev = currentItem.next;
            currentItem.item = null;
            currentItem.next = null;
            currentItem.prev = null;
            size--;
            return tempItem;
        }
    }

    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
        return new DoubleLinkedListIterator<T>(this);
    }

private static class DoubleLinkedListIterator<T> implements Iterator {
    private NodeItem<T> currentItem;
    private DoubleLinkedList<T> doubleList;

    public DoubleLinkedListIterator(DoubleLinkedList<T> doubleItem) {
        this.currentItem = new NodeItem<T>(null, null, doubleItem.firstItem);
        this.doubleList = doubleItem;
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
        doubleList.remove(currentItem);
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
            }