package ru.spsuace.homework2.collections.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public DoubleLinkedList(){
        first = null;
        last = null;
        size = 0;
    }

    private class Node<T> {
        Node<T> previous;
        Node<T> next;
        T element;

        Node(T element, Node<T> previous, Node<T> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public void add(int index, T element) {

        if (index == 0) {
            addFirst(element);
            return;
        }

        if (index == size) {
            addLast(element);
            return;
        }

        Node<T> after = neededNode(index);
        Node<T> before = after.previous;
        Node<T> middleNode = new Node<>(element, before, after);
        before.next = middleNode;
        after.previous = middleNode;

        size++;
    }

    public void addLast(T element) {
        Node<T> current = last;
        Node<T> newNode = new Node<T>(element, current, null);
        last = newNode;

        if (isEmpty()) {
            first = newNode;
        } else {
            current.next = newNode;
        }

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T element) {
        Node<T> current = first;
        Node<T> newNode = new Node<T>(element, null, current);
        first = newNode;

        if (isEmpty()) {
            last = newNode;
        } else {
            current.previous = newNode;
        }

        size++;
    }

    public T set(int index, T element) {
        Node<T> current = neededNode(index);
        T temp = current.element;

        current.element = element;

        return temp;
    }

    public T get(int index) {
        return neededNode(index).element;
    }

    public int indexOf(Object o) {
        Node<T> current = first;
        int index = 0;

        if (o != null) {

            while(current != null) {

                if (o.equals(current.element)) {
                    return index;
                }

                current = current.next;
                index++;
            }
        } else {

            while(current != null) {

                if (current.element == null) {
                    return index;
                }

                current = current.next;
                index++;
            }
        }
        return -1;
    }

    public T remove(int index) {

        Node<T> current = neededNode(index);

        T element = current.element;
        Node<T> before = current.previous;
        Node<T> after = current.next;

        if (before == null) {
            first = after;
        } else {
            before.next = after;
        }

        if (after == null) {
            last = before;
        } else {
            after.previous = before;
        }

        size--;
        return element;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    private Node<T> neededNode(int index) {

        indexIsCorrect(index);

        Node<T> current;

        if (index < (size / 2)) {
            current = first;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            checkIfNull(current);

            return current;
        } else {
            current = last;

            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }

            checkIfNull(current);

            return current;
        }
    }

    private void indexIsCorrect(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Size: " + size + " Index: " + index);
        }
    }

    private void checkIfNull(Node<T> node) {
        if (node == null) {
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Дополнительное задание
     */

    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;
        private Node<T> lastReturned;
        private int nextIndex;

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastReturned = current;
            current = current.next;
            nextIndex++;
            return lastReturned.element;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }

            DoubleLinkedList.this.remove(nextIndex - 1);
            nextIndex--;

        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

}
