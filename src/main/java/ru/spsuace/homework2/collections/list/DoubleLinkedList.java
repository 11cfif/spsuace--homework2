package ru.spsuace.homework2.collections.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int count;


    public int size() {

        return count;
    }

    public boolean contains(Object o) {

        if (indexOf((T) o) != -1) {
            return true;
        }
        return false;
    }

    public void clear() {
        first = null;
        last = null;
        count = 0;
    }

    private void addBetweenNodes(Node insertNode, Node movingNode) {
        Node temp = movingNode.previous;
        temp.next = insertNode;
        movingNode.previous = insertNode;
        insertNode.previous = temp;
        insertNode.next = movingNode;
    }


    public void add(int index, T element) {
        Node insertNode = new Node(element);
        if (index >= 0 && index <= count) {
            if (index == 0) {
                addFirst(element);
            } else if (index == count) {
                addLast(element);
            } else {
                addBetweenNodes(insertNode, searchItem(index));
                count++;
            }

        } else {
            throw new IndexOutOfBoundsException("Item is empty");
        }

    }

    private void addFirstItem(T element, Node node) {
        first = node;
        last = node;
    }

    public void addLast(T element) {
        Node node = new Node(element);
        if (count == 0) {
            addFirstItem(element, node);
        } else {
            node.previous = last;
            last.next = node;
            last = node;
        }
        count++;
    }


    public void addFirst(T element) {
        Node node = new Node(element);
        if (count == 0) {
            addFirstItem(element, node);
        } else {
            node.next = first;
            first.previous = node;
            first = node;
        }
        count++;
    }

    private Node searchItem(int index) {

        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Item is empty");
        }


        if (index == 0) {
            return first;
        }
        if (index == count - 1) {
            return last;
        }

        Node temp = first.next;
        if (index <= count / 2) {
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            temp = last;
            for (int i = count; i > index; i--) {
                temp = temp.previous;
            }
            return temp.next;
        }

    }

    public T set(int index, T element) {
        Node<T> temp = searchItem(index);

        if (temp == null) {
            return null;
        }
        T tempReplaced = (T) temp.value;
        temp.value = element;
        return tempReplaced;
    }

    public T get(int index) {
        return (T) searchItem(index).value;
    }


    public int indexOf(T o) {
        if (first != null) {
            Node temp = first;
            for (int i = 0; i < count; i++) {
                if (o.equals(temp.value)) {
                    return i;
                }
                temp = temp.next;
            }
        }
        return -1;
    }

    public T remove(int index) {
        if (index == 0 && count == 1) {
            Node<T> temp = first;
            first = null;
            last = null;
            count--;
            return temp.value;
        }
        if (index == 0) {
            Node<T> temp = first;
            first = first.next;
            first.previous = null;
            count--;
            return temp.value;
        }
        if (index == count - 1) {
            Node<T> temp = last;
            last = last.previous;
            last.next = null;
            count--;
            return temp.value;
        }

        Node<T> removeNode = searchItem(index);
        if (removeNode != null) {
            Node<T> temp = removeNode.previous;
            temp.next = removeNode.next;
            removeNode.next.previous = temp;
            count--;
            return temp.value;
        }
        return null;
    }


    private class Node<T> {
        private T value;
        private Node next;
        private Node previous;

        Node(T element) {
            value = element;
        }
    }


    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator {
        Node<T> current = first;
        private T returned = current.value;
        private int index = -1;

        @Override
        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            returned = current.value;
            current = current.next;
            index++;
            return returned;
        }

        @Override
        public void remove() {
            if (returned == null) {
                throw new IllegalStateException();
            }
            DoubleLinkedList.this.remove(index);
        }

        @Override
        public boolean hasNext() {
            if (current == null) {
                return false;
            }
            return true;
        }
    }

}