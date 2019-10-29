package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private Data first;
    private Data last;
    private int count;

    public int size() {
        return count;
    }

    public boolean contains(Object o) {
        return (indexOf((T) o) != -1);
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
        if (index == count) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            Data<T> newElement = new Data(element);
            Data<T> currentElement = findElement(index);
            currentElement.previous.next = newElement;
            newElement.previous = currentElement.previous;
            currentElement.previous = newElement;
            newElement.next = currentElement;
            count++;
        }
    }

    public void addLast(T element) {
        Data<T> newElement = new Data(element);
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
        Data<T> newElement = new Data(element);
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
        Data<T> currentElement = findElement(index);
        T currentData = currentElement.data;
        currentElement.data = element;

        return currentData;
    }

    public T get(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Data<T> currentElement = findElement(index);
        return currentElement.data;
    }

    public int indexOf(T o) {
        Data<T> currentElement = first;
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
        Data<T> currentElement = findElement(index);
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

    private Data<T> findElement(int index) {
        Data<T> currentElement;
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

    private class Data<T> {
        private Data<T> previous;
        private T data;
        private Data<T> next;

        Data(T data) {
            this.data = data;
        }
    }

    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
