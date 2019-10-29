package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private int counter;
    private Node<T> firstElement;
    private Node<T> lastElement;

    public DoubleLinkedList() {
        counter = 0;
        firstElement = null;
        lastElement = null;
    }

    private static class Node<E> {
        E element;
        Node<E> previousElement;
        Node<E> nextElement;

        Node(E element, Node<E> previousElement, Node<E> nextElement) {
            this.element = element;
            this.previousElement = previousElement;
            this.nextElement = nextElement;
        }

        public Node<E> getPreviousElement() {
            return previousElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public E getElement() {
            return element;
        }

        public void setPreviousElement(Node<E> previousElement) {
            this.previousElement = previousElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }

    public int size() {
        return counter;
    }

    public boolean contains(Object o) {

        return indexOf((T) o) != -1;
    }

    public void clear() {
        counter = 0;
        firstElement = null;
        lastElement = null;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Your index: " + index + ". " + "Size of list: " + size());
        } else if (index == 0) {
            addFirst(element);
            return;
        } else if (index == size()) {
            addLast(element);
            return;
        } else {
            Node<T> oldListElement = elementByIndex(index);
            Node<T> newListElement = new Node<T>(element, oldListElement.previousElement, oldListElement);
            oldListElement.previousElement.nextElement = newListElement;
            oldListElement.previousElement = newListElement;
        }
        counter++;
    }

    public void addLast(T element) {
        if (size() == 0) {
            firstElement = new Node<T>(element, null, null);
            lastElement = firstElement;
        } else {
            Node<T> listElement = lastElement;
            lastElement = new Node<T>(element, listElement, null);
            listElement.nextElement = lastElement;
        }
        counter++;
    }


    public void addFirst(T element) {
        if (size() == 0) {
            firstElement = lastElement = new Node<T>(element, null, null);
        } else {
            Node<T> listElement = firstElement;
            firstElement = new Node<T>(element, null, listElement);
            listElement.previousElement = firstElement;
        }
        counter++;
    }

    private Node<T> elementByIndex(int index) {
        Node<T> indexElement;
        if (index < size()/2) {
            indexElement = firstElement;
            for (int i = 0; i < index; i++) {
                indexElement = indexElement.nextElement;
            }
        } else {
            indexElement = lastElement;
            for (int i = size() - 1; i > index; i--) {
                indexElement = indexElement.previousElement;
            }
        }
        return indexElement;
    }

    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Your index: " + index + ". " + "Size of list: " + size());
        }

        Node<T> listElement = elementByIndex(index);
        T oldVal = listElement.element;
        listElement.element = element;
        return oldVal;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Your index: " + index + ". " + "Size of list: " + size());
        }
        return elementByIndex(index).element;
    }

    public int indexOf(T o) {
        int index = -1;
        Node<T> listElement = firstElement;
        for (int i = 0; i < size(); i++) {
            if (listElement.element.equals(o)) {
                return i;
            }
            listElement = listElement.nextElement;
        }
        return index;
    }

    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Your index: " + index + ". " + "Size of list: " + size());
        }

        Node<T> nodeToRemove = elementByIndex(index);
        if (index == 0) {
            firstElement = firstElement.nextElement;
            firstElement.previousElement = null;
        } else if (index == size() - 1) {
            lastElement = lastElement.previousElement;
            lastElement.nextElement = null;
        } else {
            Node<T> beforeRemoveElement = nodeToRemove.previousElement;
            Node<T> afterRemoveElement = nodeToRemove.nextElement;
            beforeRemoveElement.nextElement = afterRemoveElement;
            afterRemoveElement.previousElement = beforeRemoveElement;
        }
        counter--;
        return nodeToRemove.element;
    }


    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
