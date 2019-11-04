package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private static class Element<T> {
        T data;
        Element<T> follow, last;
    }

    private Element<T> begin, end;
    private int count;

    public DoubleLinkedList() {
        begin = null;
        end = null;
        count = 0;
    }
    public int size() {
        return count;
    }
    public boolean contains(Object o) {
        return indexOf((T) o) > -1;
    }
    public void clear() {
        begin = null;
        end = null;
        count = 0;
    }
    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        } else if (index == 0) {
            addFirst(element);
        } else if (index == size()) {
            addLast(element);
        } else {
            Element<T> additionalElement = transitionToElement(index - 1);
            Element<T> listElement = new Element<T>();
            listElement.follow = additionalElement.follow;
            additionalElement.follow.last = listElement;
            listElement.last = additionalElement;
            listElement.data = element;
            additionalElement.follow = listElement;
            count++;
        }
    }
    public void addLast(T element) {
        Element<T> listElement = new Element<T>();
        listElement.data = element;
        listElement.last = end;
        if (size() == 0) {
            begin = listElement;
            end = listElement;
        } else {
            end.follow = listElement;
        }
        end = listElement;
        count++;
    }
    public void addFirst(T element) {
        Element<T> listElement = new Element<T>();
        listElement.data = element;
        if (size() == 0) {
            end = listElement;
        } else {
            begin.last = listElement;
        }
        listElement.follow = begin;
        begin = listElement;
        count++;
    }
    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size());
        }
        Element<T> listElement = begin;
        listElement = transitionToElement(index);
        T replaceableElement = listElement.data;
        listElement.data = element;
        return replaceableElement;
    }
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size());
        }
        Element<T> listElement = begin;
        listElement = transitionToElement(index);
        return listElement.data;
    }
    public int indexOf(T o) {
        int index = -1;
        Element<T> listElement = begin;
        for (int i = 0; i < size(); i++) {
            if (listElement.data.equals(o)) {
                return i;
            }
            listElement = listElement.follow;
        }
        return index;
    }
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Element<T> listElement = begin;
        listElement =transitionToElement(index - 1);
        T removableElement = listElement.follow.data;
        if (index == 0) {
            removableElement = listElement.data;
            begin = listElement.follow;
        } else if (index == size() - 1) {
            listElement.follow.data = null;
            listElement.follow = null;
            end = listElement;
        } else {
            listElement.follow = listElement.follow.follow;
            listElement.follow.last = listElement;
        }
        count--;
        return removableElement;
    }
    private Element<T> transitionToElement(int index) {
        Element<T> listElement = new Element<>();
        if (index < size()/2 + 1) {
            listElement = begin;
            int i = 0;
            while (i < index) {
                listElement = listElement.follow;
                i++;
            }
        } else {
            listElement = end;
            int i = 0;
            while (i < size() - index - 1) {
                listElement = listElement.last;
                i++;
            }
        }
        return listElement;
    }

    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

