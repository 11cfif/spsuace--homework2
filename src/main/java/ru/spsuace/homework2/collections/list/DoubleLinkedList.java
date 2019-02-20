package ru.spsuace.homework2.collections.list;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 */
public class DoubleLinkedList<T> {
    Node first;
    Node last;
    int count;

    public DoubleLinkedList() {
        first = null;
        last = null;
        count = -1;
    }

    public int size() {
        return count + 1;
    }

    boolean contains(Object o) {
        if (count == 0) {
            return false;
        } else {
            Node temp = first;
            for (int i = 0; i <= count; i++) {

                if (o.equals(temp)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    void clear() {
        for (int i = count; i >= 0; i--) {
            remove(i);
        }
    }


    void add(int index, T element) {
        Node node = new Node(element);
        Node tempNext = first;
        Node tempPrevious = tempNext;
        if (index > count + 1 && index < 0) {
            System.out.println("Такого индекса не существует в этом списке");
        }
        if (index > 0 && index < count) {


            if (index <= count / 2 + 1) {

                for (int i = 1; i < index; i++) {
                    tempPrevious = tempNext;
                    tempNext = tempNext.next;
                }
                tempPrevious.next = node;
                tempNext.previous = node;
                node.previous = tempPrevious;
                node.next = tempNext;
            } else {
                tempPrevious = last;
                for (int i = count; i > index; i--) {
                    tempNext = tempPrevious;
                    tempPrevious = tempPrevious.previous;
                }
                tempPrevious.next = node;
                tempNext.previous = node;
                node.previous = tempPrevious;
                node.next = tempNext;

            }
            count++;
        }
        if (index == 0) {
            addFirst(element);
        }
        if (index == count + 1) {
            addLast(element);
        }

    }

    void addLast(T element) {
        Node node = new Node(element);
        node.next = null;
        if (count == -1) {
            node.previous = null;
            first = node;
        } else {
            node.previous = last;
            node.previous.next = node;
        }
        last = node;
        count++;
    }


    void addFirst(T element) {
        Node node = new Node(element);
        // Node temp;
        node.previous = null;
        if (count == -1) {
            node.next = null;
            last = node;
        } else {
            first.previous = node;
            node.next = first;
        }
        first = node;
        count++;
    }


    T set(int index, T element) {
        Node temp;
        Node replacedNode = first;
        if (index > count && index < 0) {
            System.out.println("Ошибка!Такого индекса не существует");
            return null;
        }

        if (index <= (count + 1) / 2) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            replacedNode = temp;
            temp.node = element;
        } else {
            temp = last;
            for (int i = count; i > index; i--) {
                temp = temp.previous;
            }
            replacedNode = temp;
            temp.node = element;
        }
        return replacedNode.node;
    }

    T get(int index) {
        Node temp;
        if (index > count || index < 0) {
            System.out.println("Ошибка!Такого индекса не существует");
            return null;
        }

        if (index <= (count + 1) / 2) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.node;
        } else {
            temp = last;
            for (int i = count; i > index; i--) {
                temp = temp.previous;
            }
            return temp.node;
        }

    }

    int indexOf(T element) {


        if (count == -1) {
            return -1;
        }
        Node node = new Node(element);
        Node temp = first;
        for (int i = 0; i <= count; i++) {
            if (node.node == temp.node) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    T remove(int index) {

        Node temp;
        if (index > count || index < 0) {
            System.out.println("Ошибка!Такого индекса не существует");
            return null;
        }


        if (index <= (count + 1) / 2) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = count; i > index; i--) {
                temp = temp.previous;
            }

        }

        if (index == 0) {
            temp = first;
            first = first.next;
            first.previous = null;
            count--;
            return temp.node;
        }
        if (index == count) {
            temp = last;
            last = last.previous;
            last.next = null;
            count--;
            return temp.node;
        }

        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;

        count--;
        return temp.node;
    }

    /**
     * Дополнительное задание
     */
    Iterator<T> iterator() {
        return null;
    }


    public class Node {
        protected T node;
        protected Node previous;
        protected Node next;

        public Node(T obj) {
            this.node = obj;
            this.next = null;
            this.previous = null;
        }

    }




}
