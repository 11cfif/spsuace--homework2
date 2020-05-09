package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 * Полный балл - 6
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    // ----------- 1 балл -----------

    private Element head;
    private Element tail;
    private int size;

    private class Element<T> {
        private Element<T> previous;
        private Element<T> next;
        private T data;

        Element(T data) {
            this.data = data;
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        return indexOf((T) o) != -1;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int indexOf(T o) {
        Element<T> currentElement = head;
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

    public void add(int index, T element) {
        if (index == size) {
            addLast(element);
            return;
        }

        indexBoundsCheck(index);

        if (index == 0) {
            addFirst(element);
        } else {
            Element<T> newElement = new Element(element);
            Element<T> oldElement = getElement(index);
            newElement.previous = oldElement.previous;
            newElement.next = oldElement;
            oldElement.previous.next = newElement;
            oldElement.previous = newElement;
            size++;
        }
    }


    public void addLast(T data) {
        Element<T> newElement = new Element(data);
        if (size == 0) {
            head = newElement;
            tail = newElement;
        } else {
            newElement.previous = tail;
            tail.next = newElement;
            tail = newElement;
        }
        size++;
    }


    public void addFirst(T data) {
        Element<T> newElement = new Element(data);
        if (size == 0) {
            head = newElement;
            tail = newElement;
        } else {
            newElement.next = head;
            head.previous = newElement;
            head = newElement;
        }
        size++;
    }

    // ----------- 1 балл -----------


    public T set(int index, T data) {
        indexBoundsCheck(index);
        Element<T> element = getElement(index);
        T oldData = element.data;
        element.data = data;
        return oldData;
    }

    public T get(int index) {
        indexBoundsCheck(index);
        Element<T> element = getElement(index);
        return element.data;
    }


    public T remove(int index) {
        indexBoundsCheck(index);
        Element<T> element = getElement(index);

        if (index == 0) {
            element.next.previous = null;
            head = element.next;
        } else if (index == size - 1) {
            element.previous.next = null;
            tail = element.previous;
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

    private Element<T> getElement(int index) {
        indexBoundsCheck(index);
        Element<T> currentElement;

        if (index > size / 2) {
            currentElement = tail;
            for (int i = size - 1; i > index; i--) {
                currentElement = currentElement.previous;
            }
        } else {
            currentElement = head;
            for (int i = 0; i < index; i++) {
                currentElement = currentElement.next;
            }
        }

        return currentElement;
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

    private class DoubleLinkedListIterator<T> implements Iterator<T> {

        Element<T> currentElement;
        int currentIndex;

        public DoubleLinkedListIterator() {
            currentElement = head;
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