package ru.spsuace.homework2.collections;

import java.util.Iterator;
import java.util.List;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    private class Node<T> {
        private Node next;
        private Node prev;
        private T value;

        Node(T value) {
            next = null;
            prev = null;
            this.value = value;
        }
    }

    private Node last;   //  top of stack
    private Node first;     // bottom of stack
    private int counter;

    public DoubleLinkedList() {
    }

    public DoubleLinkedList(T element) {
        first.value = element;
        last.value = element;
        counter = 1;
    }

    public int size() {
        return counter;
    }

    public boolean contains(Object o) {

        if (indexOf((T) o) != -1) {
            return true;
        }
        return false;
    }

    public void clear() {
        last = null;
        first = null;
        counter = 0;
    }

    public void add(int index, T element) {

        if ((index < 0 || index > size())) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == counter) {
            addLast(element);
            return;
        }else {
            Node<T> node = new Node<>(element);
            Node temp = search(index);

            node.next = temp;
            node.prev = temp.prev;
            temp.prev.next = node;
            temp.prev = node;

            counter++;
        }
    }

    public void addLast(T element) {
        Node<T> node = new Node<>(element);

        if (counter == 0) {
            first = node;
            last = node;
        } else {
            node.prev = last;
            last.next = node;
            last = node;
        }
        counter++;
    }

    public void addFirst(T element) {
        Node<T> node = new Node<>(element);

        if (counter == 0) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
        counter++;
    }

    public Node search(int index) {
        if ((index < 0 || index >= size())) {
            throw new IndexOutOfBoundsException();
        }

        if (index < size() / 2) {
            Node temp = first;
            for (int i = 0; i < size() / 2; i++) {
                if (i == index) {

                    return temp;
                }
                temp = temp.next;
            }
        } else {
            Node temp = last;
            for (int i = size() - 1; i >= size() / 2; i--) {
                if (i == index) {

                    return temp;
                }
                temp = temp.prev;
            }
        }
        return null;
    }

    public T set(int index, T element) {
        Node temp = search(index);
        T result = (T) temp.value;
        temp.value = element;
        return result;
    }

    public T get(int index) {
        Node result = search(index);
        return (T) result.value;
    }

    public int indexOf(T o) {
        Node temp = first;

        if (o == null){ return -1;}

        for (int i = 0; i < size(); i++) {
            if (o.equals(temp.value)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public T remove(int index) {
        Node temp = search(index);

        if (index == 0) {
            first = temp.next;
            first.prev = null;

            counter--;
            return (T) temp.value;
        }
        if (index == size() - 1) {
            last = temp.prev;
            last.next = null;

            counter--;
            return (T) temp.value;
        }

        Node previous = temp.prev;
        Node next = temp.next;

        previous.next = next;
        next.prev = previous;

        counter--;
        return (T) temp.value;
    }


    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
