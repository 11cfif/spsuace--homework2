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
    private LinkedItem firstItem;
    private LinkedItem lastItem;

    // ----------- 1 балл -----------

    public int size() {
        return size;
    }

    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    public void clear() {
        size = 0;
        firstItem = null;
        lastItem = null;
    }

    public int indexOf(T o) {
        if (size == 0) {
            return -1;
        }

        int i = 0;

        for (LinkedItem currentLinkedItem = firstItem; currentLinkedItem != null; currentLinkedItem = currentLinkedItem.next, i++) {
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

            LinkedItem currentLinkedItem = getLinkedItemByIndex(index);

            LinkedItem newLinkedItem = new LinkedItem(element, currentLinkedItem.prev, currentLinkedItem);

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
            lastItem = new LinkedItem(element, null, null);
            firstItem = lastItem;
        } else {
            LinkedItem newLinkedItem = new LinkedItem(element, lastItem, null);
            lastItem.next = newLinkedItem;
            lastItem = newLinkedItem;
        }

        size++;
    }


    public void addFirst(T element) {
        if (firstItem == null) {
            firstItem = new LinkedItem(element, null, null);
            lastItem = firstItem;
        } else {
            LinkedItem newLinkedItem = new LinkedItem(element, null, firstItem);
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
            return null;
        } else {
            LinkedItem currentLinkedItem = getLinkedItemByIndex(index);

            T oldElement = currentLinkedItem.item;

            currentLinkedItem.item = element;

            return oldElement;
        }
    }

    public T get(int index) {
        return getLinkedItemByIndex(index).item;
    }

   private LinkedItem getLinkedItemByIndex(int index) {
        if (size - 1 < index) {
            throw new IndexOutOfBoundsException();
        }

        LinkedItem currentLinkedItem = firstItem;

       for (int i = 0; i < index; i++) {
           currentLinkedItem = currentLinkedItem.next;
       }

        return currentLinkedItem;
    }

    public T remove(int index) {
        if (size - 1 < index) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return remove(firstItem);
        } else if (size - 1 == index) {
            return remove(lastItem);
        }

        return remove(getLinkedItemByIndex(index));
    }

    private T remove(LinkedItem linkedItem) {
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
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator implements Iterator<T> {
        private LinkedItem currentLinkedItem;
        private LinkedItem nextLinkedItem = DoubleLinkedList.this.firstItem;

        @Override
        public boolean hasNext() {
            return nextLinkedItem != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            currentLinkedItem = nextLinkedItem;
            nextLinkedItem = currentLinkedItem.next;

            return currentLinkedItem.item;
        }

        @Override
        public void remove() {
            if (currentLinkedItem == null) {
                throw new NoSuchElementException();
            }

            DoubleLinkedList.this.remove(currentLinkedItem);
        }
    }

    private class LinkedItem {
        private T item;
        private LinkedItem prev;
        private LinkedItem next;

        LinkedItem (T item, LinkedItem prev, LinkedItem next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}