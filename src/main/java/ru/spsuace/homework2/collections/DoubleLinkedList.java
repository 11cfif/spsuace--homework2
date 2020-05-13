package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size=0;
    private Node<T> current;


    public DoubleLinkedList(){
        lastNode=new Node<T>(null, firstNode,null);
        firstNode=new Node<T>(null,null,lastNode);
        current=new Node<T>(null,null,null);
    }

    private class Node<T>{
        private T currentElement;
        public Node<T> nextElement;
        private Node<T> prevElement;

        private Node(T currentElement, Node<T> prevElement, Node<T> nextElement){
            this.currentElement=currentElement;
            this.nextElement=nextElement;
            this.prevElement=prevElement;
        }


        public void setCurrentElement(T currentElement) {
            this.currentElement = currentElement;
        }

        public void setNextElement(Node<T> nextElement) {
            this.nextElement=nextElement;
        }

        public void setPrevElement(Node<T> prevElement) {
            this.prevElement = prevElement;
        }

        public Node<T> getPrevElement() {
            return prevElement;
        }

        public Node<T> getNextElement() {
            return nextElement;
        }

        public T getCurrentElement() {
            return currentElement;
        }
        private void allToNull() {
            this.currentElement = null;
            this.nextElement = null;
            this.prevElement = null;
        }

    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(o)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        if (size != 0) {
            Node<T> element = firstNode;
            Node<T> element2;
            for (int i = 0; i < size; i++) {
                element2 = element.getNextElement();
                element.prevElement = null;
                element.nextElement = null;
                element.currentElement = null;
                element = element2;
            }
            size = 0;
            firstNode = null;
            lastNode = null;
        }

    }

    public void add(int index, T element) {

    }

    public void addLast(T element) {
        Node<T> prev=lastNode;
        prev.setCurrentElement(element);
        lastNode=new Node<>(null,prev,null);
        prev.setNextElement(lastNode);
        size++;
    }

    public void addFirst(T element) {
        Node<T> next=firstNode;
        next.setCurrentElement(element);
        firstNode=new Node<>(null,null,next);
        next.setPrevElement(firstNode);
        size++;
    }

    public T set(int index, T element) {
        for (int i = 0; i < size; i++) {
            if (i==index) {
                return element;
            }
        }
        return null;
    }




    public T get(int index) {
        Node<T> target =firstNode.getNextElement();
        for (int i=0;i<index;i++){
            target=getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<T> getNextElement(Node<T> current) {
        return current.getNextElement();
    }


    public int indexOf(T o) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {

        return null;
    }


    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter=0;
            @Override
            public boolean hasNext() {
                return counter<size;
            }

            @Override
            public T next() {
                return get(counter++);
            }
        };
    }
}
