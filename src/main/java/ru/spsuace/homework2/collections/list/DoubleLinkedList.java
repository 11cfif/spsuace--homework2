package ru.spsuace.homework2.collections.list;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    Node first;
    Node last;
    int count;

    public DoubleLinkedList() {
        first = null;
        last = null;
        count = 0;
    }

    public int size() {

        return count;
    }

    public boolean contains(Object o) {
        Node temp = first;
        for (int i = 0; i < count; i++) {
            if (o.equals(temp.value)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void clear() {
        first=null;
        last=null;
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
        assert first != null;
        Node temp = first.next;
        if (index == 0) {
            return first;
        }
        if (index == count - 1) {
            return last;
        }
        if (index > 0 && index <= count / 2) {
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else if (index > (count) / 2 && index < count) {
            temp = last;
            for (int i = count; i > index; i--) {
                temp = temp.previous;
            }
            return temp.next;
        }

        return null;
    }

    public T set(int index, T element) {

        Node<T> temp = searchItem(index);
        Node<T> tempReplaced = searchItem(index);
        if (temp != null) {
            temp.value = element;
            return tempReplaced.value;
        }
        return null;

    }

    public T get(int index) {

        if (index >= count || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException("Item is empty");
        }
        return (T) searchItem(index).value;
    }

    public int indexOf(T o) {
        assert first != null;
        Node temp = first;
        for (int i = 0; i < count; i++) {
            if (o.equals(temp.value)) {
                return i;
            }
            temp = temp.next;
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
        public T value;
        private Node next;
        private Node previous;

        public Node(T element) {
            this.value = element;
            this.next = null;
            this.previous = null;
        }
    }


    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }


}
