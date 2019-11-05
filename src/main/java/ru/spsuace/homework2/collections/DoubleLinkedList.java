package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private static class Component<T> {
        T data;
        Component<T> next;
        Component<T> prev;
    }
    private Component<T> head;
    private Component<T> tail;
    private int count;
    public DoubleLinkedList() {
        count = 0;
        head = null;
        tail = null;
    }
    public int size() {
        return count;
    }
    public boolean contains(Object o) {
                return indexOf((T) o) > -1;
            }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }
    public void add(int index, T component) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }else if (index==0){
            addFirst(component);
        } else if (index==size()) {
            addLast(component);
        } else {
            Component<T> additionalComponent = transitionToComponent( index-1);
           Component<T> listComponent = new Component<T>();
            listComponent.next = additionalComponent.next;
            additionalComponent.next.prev=listComponent;
            listComponent.prev = additionalComponent;
            listComponent.data = component;
            additionalComponent.next=listComponent;
            count++;
        }
    }
    public void addLast(T component) {
        Component<T> listComponent = new Component<T>();
        listComponent.data = component;
        listComponent.prev = tail;
        if (size() == 0) {
            head = listComponent;
            tail=listComponent;
        } else {
            tail.next = listComponent;
        }
        tail = listComponent;
        count++;
    }
    public void addFirst(T component) {
        Component<T> listComponent = new Component<T>();
        listComponent.data = component;
        if (size()==0){
            tail=listComponent;
        } else {
            head.prev=listComponent;
        }
        listComponent.next=head;
        head=listComponent;
        count++;
    }
    public T set(int index, T component) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Component<T> listComponent=head;
        listComponent=transitionToComponent(index);
        T replaceableComponent=listComponent.data;
        listComponent.data=component;
        return replaceableComponent;
    }
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Component<T> listComponent = head;
       listComponent=transitionToComponent(index);
       return listComponent.data;
    }
    public int indexOf(T o) {
        int index = -1;
        Component<T> listComponent = head;
        for (int i = 0; i < size(); i++) {
            if (listComponent.data.equals(o)) {
                return i;
            }
            listComponent = listComponent.next;
        }
        return index;
    }
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Component<T> listComponent = head;
        listComponent=transitionToComponent(index-1);
        T removableComponent=listComponent.next.data;

        if (index == 0) {
            removableComponent = listComponent.data;
            head = listComponent.next;
        } else if (index == size() - 1) {
            listComponent.next.data = null;
            listComponent.next = null;
            tail=listComponent;
        } else {
            listComponent.next = listComponent.next.next;
            listComponent.next.prev=listComponent;
        }
        count--;
        return removableComponent;
    }
    private Component<T> transitionToComponent(int index){
        Component<T> listComponent=new Component<>();
        if (index<size()/2+1){
            listComponent=head;
            int i=0;
            while(i<index){
                listComponent=listComponent.next;
                i++;
            }
        } else {
            listComponent=tail;
            int i=0;
            while (i < size() - index - 1) {
                listComponent = listComponent.prev;
                i++;
            }
        }
        return listComponent;
    }




    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
