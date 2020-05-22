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
    private Node firstNode;
    private Node lastNode;

    private class Node<T> {
        private T currentElement;
        private Node<T> prevElement;
        private Node<T> nextElement;

        private Node(T current, Node<T> prev, Node<T> next) {
            this.currentElement = current;
            this.prevElement = prev;
            this.nextElement = next;
        }
    }

    private Node<T> getElementByIndex(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index > size) throw new IndexOutOfBoundsException();
        Node<T> getElement;
        if (index < size / 2) {
            getElement = firstNode;
            for (int i = 0; i < index; i++) {
                getElement = getElement.nextElement;
            }
        } else {
            getElement = lastNode;
            for (int i = size - 1; i > index; i--) {
                getElement = getElement.prevElement;
            }
        }
        return getElement;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(o)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        size = 0;
        firstNode = null;
        lastNode = null;
    }

    public void add(int index, T element) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index > size) throw new IndexOutOfBoundsException();
        if (index == size) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index != size) {
            if (index != 0) {
                Node<T> oldNode = getElementByIndex(index);
                Node<T> newNode = new Node<T>(element, oldNode.prevElement, oldNode);
                oldNode.prevElement = newNode;
                size++;
            }
        }
    }


    public void addLast(T element) {

        Node<T> newNode = new Node<T>(element, null, null);
        if (size != 0) {
            newNode.prevElement = lastNode;
            lastNode.nextElement = newNode;
            lastNode = newNode;
        } else {
            firstNode = newNode;
            lastNode = newNode;
        }
        size++;
    }


    public void addFirst(T element) {
        Node<T> newNode = new Node<T>(element, null, null);
        if (size != 0) {
            newNode.nextElement = firstNode;
            firstNode.prevElement = newNode;
            firstNode = newNode;
        } else {
            firstNode = newNode;
            lastNode = newNode;
        }
        size++;
    }


    public T set(int index, T element) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index > size) throw new IndexOutOfBoundsException();
        Node<T> newNode = getElementByIndex(index);
        T set = newNode.currentElement;
        newNode.currentElement = element;
        return set;
    }

    public T get(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index >= size) throw new IndexOutOfBoundsException();
        return getElementByIndex(index).currentElement;
    }

    public int indexOf(T o) {
        int i = 0;
        for (Node<T> current = firstNode; current != null; current = current.nextElement, i++) {
            if (Objects.equals(current.currentElement, o)) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = getElementByIndex(index);
        if (index == 0) {
            firstNode = current.nextElement;
        }
        if (index == size - 1) {
            lastNode = current.prevElement;
        }
        if (index > 0) {
            if (index < size - 1) {
                current.prevElement.nextElement = current.nextElement;
                current.nextElement.prevElement = current.prevElement;
            }
        }

        size--;
        return current.currentElement;
    }

    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public T next() {
                return get(counter++);
            }
        };
    }
}
