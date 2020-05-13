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

    private class Link<T> {
        private T Link;
        private Link<T> previous;
        private Link<T> next;

        private Link(T Link) {
            this.Link = Link;
        }
    }

    private Link first;
    private Link last;
    private int size;

    // ----------- 1 балл -----------

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        return indexOf((T) o) != -1;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int indexOf(T o) {
        Link<T> element = first;
        for (int i = 0; i < size; i++) {
            if (element.Link.equals(o)) {
                return i;
            }
            element = element.next;
        }
        return -1;
    }

    // ----------- 1 балл -----------

    private Link<T> findElement(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Link<T> element;
        if (index < (size / 2)) {
            element = first;
            for (int i = 0; i < index; i++) {
                element = element.next;
            }
        } else {
            element = last;
            for (int i = size - 1; i > index; i--) {
                element = element.previous;
            }
        }
        return element;
    }

    public void add(int index, T element) {
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Link<T> newElement = new Link(element);
            Link<T> currentElement = findElement(index);
            currentElement.previous.next = newElement;
            newElement.previous = currentElement.previous;
            currentElement.previous = newElement;
            newElement.next = currentElement;
            size++;
        }
    }

    public void addLast(T element) {
        Link<T> newElement = new Link(element);
        if (last == null) {
            first = newElement;
            last = newElement;
        } else {
            last.next = newElement;
            newElement.previous = last;
            last = newElement;
        }
        size++;
    }


    public void addFirst(T element) {
        Link<T> newElement = new Link(element);
        if (first == null) {
            first = newElement;
            last = newElement;
        } else {
            first.previous = newElement;
            newElement.next = first;
            first = newElement;
        }
        size++;
    }

    // ----------- 1 балл -----------

    public T set(int index, T element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Link<T> currentElement = findElement(index);
        T data = currentElement.Link;
        currentElement.Link = element;
        return data;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Link<T> element = findElement(index);
        return element.Link;
    }

    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Link<T> element = findElement(index);
        T data = element.Link;
        if (index == size - 1) {
            element.previous.next = null;
            last = element.previous;
        } else if (index == 0) {
            element.next.previous = null;
            first = element.next;
        } else {
            element.previous.next = element.next;
            element.next.previous = element.previous;
        }
        size--;
        return data;
    }


    /**
     * Надо реализовать свой итератор, который будет последовательно идти с первого по последний элемент
     * 3 балла
     *
     * @return
     */

    private class LinksIterator<T> implements Iterator<T> {
        private Link<T> element;
        private int index;

        public LinksIterator() {
            this.element = first;
            index = -1;
        }

        @Override
        public boolean hasNext() {
            return element != null;
        }

        @Override
        public T next() {
            T data = element.Link;
            element = element.next;
            index++;
            return data;
        }

        @Override
        public void remove() {
            DoubleLinkedList.this.remove(index);
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new LinksIterator();
    }
}
