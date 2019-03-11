package ru.spsuace.homework2.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    private LinksAndData first;
    private LinksAndData last;
    private int count;

    public int size() {

        return count;
    }

    public boolean contains(Object o) {

        LinksAndData<T> currentElement = first;

        for (int i = 0; i < count; i++) {

            if (currentElement.data.equals(o)) {

                return true;
            }
            currentElement = currentElement.next;
        }

        return false;
    }

    public void clear() {

        first = null;
        last = null;
        count = 0;
    }

    public void add(int index, T element) {

        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        LinksAndData<T> newElement = new LinksAndData(element);

        if (first == null) {
            first = newElement;
            last = newElement;

            count++;
        } else {

            if (index == count) {
                addLast(element);

            } else if (index == 0) {
                addFirst(element);

            } else {

                LinksAndData<T> currentElement = findElement(index);

                currentElement.previous.next = newElement;
                newElement.previous = currentElement.previous;
                currentElement.previous = newElement;
                newElement.next = currentElement;

                count++;
            }
        }
    }

    public void addLast(T element) {

        LinksAndData<T> newElement = new LinksAndData(element);

        if (last == null) {
            first = newElement;
            last = newElement;
        } else {
            last.next = newElement;
            newElement.previous = last;
            last = newElement;
        }

        count++;
    }

    public void addFirst(T element) {

        LinksAndData<T> newElement = new LinksAndData(element);

        if (first == null) {
            first = newElement;
            last = newElement;
        } else {
            first.previous = newElement;
            newElement.next = first;
            first = newElement;
        }

        count++;
    }

    public T set(int index, T element) {

        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        LinksAndData<T> currentElement = findElement(index);
        T currentData = currentElement.data;
        currentElement.data = element;

        return currentData;
    }

    public T get(int index) {

        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        LinksAndData<T> currentElement = findElement(index);

        return currentElement.data;
    }

    public int indexOf(T o) {

        LinksAndData<T> currentElement = first;

        for (int i = 0; i < count; i++) {
            if (currentElement.data.equals(o)) {
                return i;
            }
            currentElement = currentElement.next;
        }

        return -1;
    }

    public T remove(int index) {

        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        LinksAndData<T> currentElement = findElement(index);
        T currentData = currentElement.data;

        if (index == count - 1) {
            currentElement.previous.next = null;
            last = currentElement.previous;
        } else if (index == 0) {
            currentElement.next.previous = null;
            first = currentElement.next;
        } else {
            currentElement.previous.next = currentElement.next;
            currentElement.next.previous = currentElement.previous;
        }

        count--;

        return currentData;
    }

    private LinksAndData<T> findElement(int index) {

        LinksAndData<T> currentElement;

        if (index < (count / 2)) {
            currentElement = first;

            for (int i = 0; i < index; i++) {
                currentElement = currentElement.next;
            }
        } else {
            currentElement = last;

            for (int i = count - 1; i > index; i--) {
                currentElement = currentElement.previous;
            }
        }

        return currentElement;
    }

    private class LinksAndData<T> {

        private LinksAndData<T> previous;
        private T data;
        private LinksAndData<T> next;

        LinksAndData(T data) {
            this.data = data;
        }
    }

    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {

        return new IteratorForDoubleList<T>();
    }

    public class IteratorForDoubleList<T> implements Iterator<T> {

        private LinksAndData<T> currentElement;
        private T currentData;
        private int currentIndex;

        IteratorForDoubleList() {

            currentElement = first;
            currentIndex = -1;
        }

        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            currentData = currentElement.data;
            currentElement = currentElement.next;
            currentIndex++;
            return currentData;
        }

        public boolean hasNext() {

            return (currentElement != null);
        }

        public void remove() {

            DoubleLinkedList.this.remove(currentIndex);
            currentIndex--;
        }
    }
}
