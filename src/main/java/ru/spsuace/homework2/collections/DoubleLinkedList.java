package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Element<T> header;
    private Element<T> tail;

    DoubleLinkedList() {
        header = null;
        tail = null;
    }

    private class Element<E> {
        Element(E element) {
            this.element = element;
        }

        private E element;
        Element<E> next;
        Element<E> prev;
    }


    public int size() {
        Element<T> current = header;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    public boolean contains(Object o) {
        return indexOf((T) o) != -1;
    }

    public void clear() {
        size = 0;
        header = null;
        tail = null;
    }

    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            addLast(element);
        } else {
            if (index == 0) {
                addFirst(element);
            } else {
                Element<T> current = getElement(index - 1);
                Element<T> newElement = new Element<>(element);
                newElement.next = current.next;
                newElement.next.prev = newElement;
                current.next = newElement;
                newElement.prev = current;
                size++;
            }
        }
    }

    public void addLast(T element) {
        Element<T> current = header;
        if (current == null) {
            header = new Element<>(element);
            tail = header;
        } else {
            tail.next = new Element<>(element);
            tail.next.prev = tail;
            tail = tail.next;
        }
        size++;
    }


    public void addFirst(T element) {
        Element<T> newHeader = new Element<>(element);
        if (header == null) {
            header = newHeader;
            tail = header;
        } else {
            header.prev = newHeader;
            newHeader.next = header;
            header = newHeader;
        }
        size++;
    }


    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Element<T> current = getElement(index);
        T value = current.element;
        current.element = element;
        return value;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Element<T> current = header;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public int indexOf(T o) {
        Element<T> current = header;
        if (current != null) {
            for (int i = 0; i < size; i++) {
                if (current.element.equals(o)) {
                    return i;
                }
                current = current.next;
            }
        }
        return -1;
    }

    private Element<T> getElement(int index) {
        Element<T> current;
        if (index <= size / 2) {
            current = header;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            header = header.next;
            header.prev = null;
        }
        Element<T> current = getElement(index);

        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        size--;
        return current.element;
    }


    /**
     * Дополнительное задание
     */
    private class MyIterator implements Iterator<T> {
        private Element<T> current = header;
        private Element<T> last = null;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            last = current;
            T result = current.element;
            current = current.next;
            return result;
        }

        @Override
        public void remove() {
            if (last != null) {
                if (last.next != null) {
                    last.next.prev = last.prev;
                }
                if (last.prev != null) {
                    last.prev.next = last.next;
                }
                size--;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
}
