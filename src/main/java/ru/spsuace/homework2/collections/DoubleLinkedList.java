package ru.spsuace.homework2.collections;


import javax.swing.plaf.IconUIResource;
import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private class Data<T> {
        private Data<T> previous;
        private T data;
        private Data<T> next;

        Data(T data) {
            this.data = data;
        }
    }
    private Data firstData;
    private Data lastData;
    private int sizeValue;

    public int size() {
        return sizeValue;
    }

    public boolean contains(Object o) {
        return (indexOf((T) o) != -1);
    }

    public void clear() {
        firstData = null;
        lastData = null;
        sizeValue = 0;
    }

    public void add(int index, T element) {
        if (index > sizeValue || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == sizeValue) {
            addLast(element);
        }
        if (index == 0) {
            addFirst(element);
        } else {
            Data<T> currenData = findElement(index);
            Data<T> newElement = new Data<>(element);
            currenData.data = newElement.data;
            newElement.next = currenData.next;
            newElement.previous = currenData.previous;
            sizeValue++;
        }
    }

    public void addLast(T element) {
        Data<T> newElement = new Data(element);
        if (lastData == null) {
            firstData = newElement;
            lastData = newElement;
        } else {
            lastData.next = newElement;
            newElement.previous = lastData;
            lastData = newElement;
        }
        sizeValue++;
    }

    public void addFirst(T element) {
        Data<T> newElement = new Data(element);
        if (firstData == null) {
            firstData = newElement;
            lastData = newElement;
        } else {
            firstData.previous = newElement;
            newElement.next = firstData;
            firstData = newElement;
        }
        sizeValue++;
    }


    public T set(int index, T element) {
        return null;
    }

    public T get(int index) {
        return null;
    }

    public int indexOf(T o) {
        return -1;
    }

    public T remove(int index) {
        return null;
    }

    private Data<T> findElement(int index) {
        Data<T> currentElement;
        if (index < (sizeValue / 2)) {
            currentElement = firstData;
            for (int i = 0; i < index; i++) {
                currentElement = currentElement.next;
            }
        } else {
            currentElement = lastData;
            for (int i = sizeValue - 1; i > index; i--) {
                currentElement = currentElement.previous;
            }
        }
        return currentElement;
    }
    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
