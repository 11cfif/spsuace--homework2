package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 * Полный балл - 6
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    // ----------- 1 балл -----------

    public int size() {
        return 0;
    }

    public boolean contains(Object o) {
        return false;
    }

    public void clear() {

    }

    public int indexOf(T o) {
        return -1;
    }

    // ----------- 1 балл -----------

    public void add(int index, T element) {

    }

    public void addLast(T element) {

    }


    public void addFirst(T element) {

    }

    // ----------- 1 балл -----------

    public T set(int index, T element) {
        return null;
    }

    public T get(int index) {
        return null;
    }

    public T remove(int index) {
        return null;
    }


    /**
     * Надо реализовать свой итератор, который будет последовательно идти с первого по последний элемент
     * 3 балла
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
