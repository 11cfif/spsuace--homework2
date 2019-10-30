package ru.spsuace.homework2.collections;

import javax.xml.crypto.Data;
import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private int count;
    private Data firstElement;
    private Data lastElement;

    public int size() {
        return count;
    }

    public boolean contains(Object o) {

        return indexOf((T) o) != -1;
    }

    public void clear() {
        count = 0;
        firstElement = null;
        lastElement = null;

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
            Data newElement = new Data<T>(element);
            Data currentElement = findElement(index);
            currentElement.previous.next = newElement;
            newElement.previous = currentElement.previous;
            currentElement.previous = newElement;
            newElement.next = currentElement;
            count++;
        }
    }

    private Data findElement(int index) {
        Data<T> currentElement;
        if (index < (count / 2)) {
            currentElement = firstElement;
            for (int i = 0; i < index; i++) {
                currentElement = currentElement.next;
            }
        } else {
            currentElement = lastElement;
            for (int i = count - 1; i > index; i--) {
                currentElement = currentElement.previous;
            }
        }
        return (Data) currentElement;
    }

    public void addLast(T element) {
        Data<T> newElement = new Data(element);
        if (lastElement == null) {
            firstElement = newElement;
            lastElement = newElement;
        } else {
            lastElement.next = newElement;
            newElement.previous = lastElement;
            lastElement = newElement;
        }
        count++;
    }


    public void addFirst(T element) {
        Data<T> newElement;
        newElement = new Data(element);
        if (firstElement == null) {
            firstElement = newElement;
            lastElement = newElement;
        } else {
            firstElement.previous = newElement;
            newElement.next = firstElement;
            firstElement = newElement;
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
        Data<T> currentElement = firstElement;
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
            lastElement = currentElement.previous;
        } else if (index == 0) {
            currentElement.next.previous = null;
            firstElement = currentElement.next;
        } else {
            currentElement.previous.next = currentElement.next;
            currentElement.next.previous = currentElement.previous;
        }
        count--;
        return currentData;


        class Data<T> {
            private Data<T> previous;
            private T data;
            private Data<T> next;

            Data(T data) {
                this.data = data;
            }
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
