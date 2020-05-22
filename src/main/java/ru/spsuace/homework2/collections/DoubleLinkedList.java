package ru.spsuace.homework2.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private int size;
    private DNode first;
    private DNode last;

    private class DNode<T> {
        private T data;
        private DNode<T> prev;
        private DNode<T> next;

        private DNode(T data, DNode<T> prev, DNode<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private DNode<T> getElemet(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        DNode<T> node;
        if (index < size / 2) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    public int size() {
        return size;
    }

    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
                addLast(element);
        } else {
            DNode<T> node = new DNode<T>(element, null, null);
            DNode<T> oldNode = getElemet(index);
            node.prev = oldNode.prev;
            node.next = oldNode;
            oldNode.prev.next = node;
            oldNode.prev = node;
            size++;
        }
    }

    public void addLast(T element) {
        DNode<T> node = new DNode<T>(element, null, null);
        if (size != 0) {
            node.prev = last;
            last.next = node;
            last = node;
        } else {
            first = node;
            last = node;
        }
        size++;
    }


    public void addFirst(T element) {
        DNode<T> node = new DNode<T>(element, null, null);
        if (size != 0) {
            node.next = first;
            first.prev = node;
            first = node;
        } else {
            first = node;
            last = node;
        }
        size++;
    }


    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        DNode<T> node = getElemet(index);
        T replacedData = node.data;
        node.data = element;
        return replacedData;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getElemet(index).data;
    }

    public int indexOf(T o) {
        int index = 0;
        DNode<T> node = first;
        while (node != null) {
            if (node.data.equals(o)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        DNode<T> node = getElemet(index);
        if (index == 0) {
            node.next.prev = null;
            first = node.next;
        } else if (index == size - 1) {
            node.prev.next = null;
            last = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        return node.data;
    }

    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(this);
    }

    private class MyIterator<T> implements Iterator<T> {
        private DNode<T> node;
        private int index;

        public MyIterator(DoubleLinkedList<T> nodes) {
            this.node = new DNode<T>(null, null, nodes.first);
            index = -1;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public T next() {
            node = node.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            return node.data;
        }

        @Override
        public void remove() {
            if (node.next == null) {
                last = node.prev;
            } else {
                node.next.prev = node.prev;
            }
            if (node.prev == null) {
                first = node.next;
            } else {
                node.prev.next = node.next;
            }
            size--;
        }
    }
}
