package ru.spsuace.homework2.collections.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 */
public class DoubleLinkedList<T> {

    private class LinkedListNode<T> {
        LinkedListNode<T> previous;
        LinkedListNode<T> next;
        T info;

        public LinkedListNode(T info) {
            this.info = info;
            this.previous = null;
            this.next = null;
        }

        public LinkedListNode(T info, LinkedListNode<T> previous, LinkedListNode<T> next) {
            this.info = info;
            this.previous = previous;
            this.next = next;
        }
    }

    private LinkedListNode<T> first, last;
    private int size = 0;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {return first == null;}

    public void addLast(T element) {
        LinkedListNode<T> current = last;
        LinkedListNode<T> newNode = new LinkedListNode<T>(element, current, null);
        last = newNode;

        //if list is empty
        if (current == null) {
            first = newNode;
        } else {
            current.next = newNode;
        }

        size++;
    }

    public void addFirst(T element) {
        LinkedListNode<T> current = first;
        LinkedListNode<T> newNode = new LinkedListNode<T>(element, null, current);
        first = newNode;

        // if list is empty
        if (current == null) {
            last = newNode;
        } else {
            current.previous = newNode;
        }

        size++;
    }

    public void add(int index, T element) {

        indexIsCorrect(index);

        if (index == 0) {
            addFirst(element);
            return;
        }

        LinkedListNode<T> before;

        before = getCurrentNode(index);

        LinkedListNode<T> after = before.next;
        LinkedListNode<T> newNode = new LinkedListNode<T>(element, before, after);
        before.next = newNode;

        if (after == null) {
            last = newNode;
        } else {
            after.previous = newNode;
        }

        size++;
    }

    public T set(int index, T element) {

        indexIsCorrect(index);

        LinkedListNode<T> current = getCurrentNode(index);
        LinkedListNode<T> temp = current;

        current.info = element;

        return temp.info;
    }

    public T get(int index) {

        indexIsCorrect(index);

        LinkedListNode<T> current = getCurrentNode(index);

        return current.info;
    }

    public T getLast() {

        LinkedListNode<T> current = last;
        if (current == null) {
            throw new NoSuchElementException();
        }

        return current.info;
    }

    public T getFirst() {

        LinkedListNode<T> current = first;
        if (current == null) {
            throw new NoSuchElementException();
        }

        return first.info;
    }

    public int indexOf(Object o) {

        LinkedListNode<T> current = first;
        int index = 0;

        if (o != null) {

            while(current != null) {

                if (o.equals(current.info)) {
                    return index;
                }

                current = current.next;
                index++;
            }
        } else {

            while(current != null) {

                if (current.info == null) {
                    return index;
                }

                current = current.next;
                index++;
            }
        }
        return -1;
    }

    public T remove(int index) {

        indexIsCorrect(index);

        LinkedListNode<T> current = getCurrentNode(index);
        T element = current.info;

        LinkedListNode<T> before = current.previous;
        LinkedListNode<T> after = current.next;

        if (before == null) {
            first = after;
        } else {
            before.next = after;
            current.previous = null;
        }

        if (after == null) {
            last = before;
        } else {
            after.previous = before;
            current.next = null;
        }

        current.info = null;
        size--;
        return element;
    }

    public void clear() {

        while(first != null) {
            LinkedListNode<T> next = first.next;
            first.info = null;
            first.previous = null;
            first.next = null;
            first = next;
        }

        size = 0;
        first = last = null;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Дополнительное задание
     */
    Iterator<T> iterator() {
        return null;
    }

    private LinkedListNode<T> getCurrentNode(int index) {

        LinkedListNode<T> temp;

        if (index <= size / 2) {
            temp = goForward(index);
        } else {
            temp = goBackward(index);
        }

        return temp;
    }

    private LinkedListNode<T> goForward(int index) {

        LinkedListNode<T> temp = first;

        for (int i = 1; i < index + 1; i++) {
            temp = temp.next;
        }

        return temp;
    }

    private LinkedListNode<T> goBackward(int index) {

        LinkedListNode<T> temp = last;

        for (int i = size; i > index; i--) {
            temp = temp.previous;
        }

        return temp;
    }

    private void indexIsCorrect(int index) {

        if (index > size | index < 0) {
            String errorMessage = String.valueOf(index);
            throw new IndexOutOfBoundsException(errorMessage);
        }
    }


    //need only for display list
    public void displayForward() {

        System.out.println("display forward:");
        LinkedListNode<T> current = first;

        while(current != null) {
            System.out.println(current.info);
            current = current.next;
        }
    }
}
