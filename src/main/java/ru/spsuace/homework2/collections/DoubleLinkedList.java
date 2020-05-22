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
    private LinkedItem<T> TheFirstElement;
    private LinkedItem<T> TheLastElement;
    private int size;
    // ----------- 1 балл -----------

    public int size() {
        return size;
    }

    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    public void clear() {
    size=0;
        TheFirstElement=null;
        TheLastElement=null;

    }

    public int indexOf(T o) {
        if (size == 0) {
        return -1;
    }

        int i = 0;

        for (LinkedItem<T> currentLinkedItem = TheFirstElement; currentLinkedItem != null; currentLinkedItem = currentLinkedItem.next, i++) {
            if (Objects.equals(currentLinkedItem.item, o)) {
                return i;
            }
        }
        return -1;
    }

    // ----------- 1 балл -----------

    public void add(int index, T element) {
        if (index == 0) {
            addFirst(element);
    }
        if (size < index) {
            throw new IndexOutOfBoundsException();
        }

        if (size == index) {
            addLast(element);
        } else {
            LinkedItem<T> currentLinkedItem = TheFirstElement;


            for (int i = 0; i < index; i++) {
                currentLinkedItem = currentLinkedItem.next;
            }
            LinkedItem<T> newLinkedItem = new LinkedItem<T>(element, currentLinkedItem.previous, currentLinkedItem);

            currentLinkedItem.previous = newLinkedItem;

            if (newLinkedItem.previous == null) {
                TheFirstElement = newLinkedItem;
            } else {
                newLinkedItem.previous.next = newLinkedItem;
            }

            if (newLinkedItem.next == null) {
                TheLastElement = newLinkedItem;
            }

            size++;
        }
        }


    public void addLast(T element) {
        if (TheLastElement == null) {
            TheLastElement = new LinkedItem<T>(element, null, null);
            TheFirstElement = TheLastElement;
        } else {
            LinkedItem<T> newLinkedItem = new LinkedItem<T>(element, TheLastElement, null);
            TheLastElement.next = newLinkedItem;
            TheLastElement = newLinkedItem;
        }
        size++;

    }


    public void addFirst(T element) {
        if (TheFirstElement == null) {
            TheFirstElement = new LinkedItem<T>(element, null, null);
            TheLastElement = TheFirstElement;
        } else {
            LinkedItem<T> newLinkedItem = new LinkedItem<T>(element, null, TheFirstElement);
            TheFirstElement.previous = newLinkedItem;
            TheFirstElement = newLinkedItem;
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

            LinkedItem<T> currentLinkedItem = TheFirstElement;

            for (int i = 0; i < index; i++) {
                currentLinkedItem = currentLinkedItem.next;
            }

            LinkedItem<T> newLinkedItem = new LinkedItem<T>(element, currentLinkedItem.previous, currentLinkedItem.next);
            T oldElement = currentLinkedItem.item;
            currentLinkedItem.item = null;
            currentLinkedItem.previous = null;
            currentLinkedItem.next = null;

            if (newLinkedItem.previous == null) {
                TheFirstElement = newLinkedItem;
            } else {
                newLinkedItem.previous.next = newLinkedItem;
            }

            if (newLinkedItem.next == null) {
                TheLastElement = newLinkedItem;
            } else {
                newLinkedItem.next.previous = newLinkedItem;
            }

            return oldElement;
        }

    }

    public T get(int index) {
        if (size - 1 < index) {
            throw new IndexOutOfBoundsException();
        }

        LinkedItem<T> currentLinkedItem = TheFirstElement;

        for (int i = 0; i < index; i++) {
            currentLinkedItem = currentLinkedItem.next;
        }

        return currentLinkedItem.item;
    }

    public T remove(int index) {
        if (size - 1 < index) {
            throw new IndexOutOfBoundsException();
        }

        LinkedItem<T> currentLinkedItem = TheFirstElement;

        for (int i = 0; i < index; i++) {
            currentLinkedItem = currentLinkedItem.next;
        }

        return remove(currentLinkedItem);
    }

    private T remove(LinkedItem<T> linkedItem) {
        if (linkedItem.previous == null) {
            TheFirstElement = linkedItem.next;
        } else {
            linkedItem.previous.next = linkedItem.next;
        }

        if (linkedItem.next == null) {
            TheLastElement = linkedItem.previous;
        } else {
            linkedItem.next.previous = linkedItem.previous;
        }

        T oldElement = linkedItem.item;
        linkedItem.item = null;
        linkedItem.previous = null;
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

    private class DoubleLinkedListIterator<T> implements Iterator<T> {
        private LinkedItem<T> currentLinkedItem;
        private DoubleLinkedList<T> doubleLinkedList;

        public DoubleLinkedListIterator(DoubleLinkedList<T> doubleLinkedItem) {
            this.currentLinkedItem = new LinkedItem<T>(null, null, doubleLinkedItem.TheFirstElement);
            this.doubleLinkedList = doubleLinkedItem;
        }


        public boolean hasNext() {
            return currentLinkedItem.next != null;
        }


        public T next() {
            currentLinkedItem = currentLinkedItem.next;

            if (currentLinkedItem == null) {
                throw new NoSuchElementException();
            }

            return currentLinkedItem.item;
        }


        public void remove() {
            doubleLinkedList.remove(currentLinkedItem);
        }
    }

    private static class LinkedItem<T> {
        private T item;
        private LinkedItem<T> previous;
        private LinkedItem<T> next;

        public LinkedItem(T item, LinkedItem<T> previous, LinkedItem<T> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }
}
