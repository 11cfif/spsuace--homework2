package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private int length;
    Element<T> first;
    Element<T> last;

    private class Element<T> {
        T data;
        Element<T> next;
        Element<T> prev;

        Element(T data) {
            this.data = data;

        }

    }

    private Element<T> getElement(int index) {
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException();
        }
        Element<T> element = first;
        if (index < (length - 1) / 2) {
            for (int i = 0; i <= (length - 1) / 2; i++) {
                if (i == index) {
                    return element;
                }
                element = element.next;

            }
        } else {
            element = last;
            for (int i = length - 1; i >= (length - 1) / 2; i--) {
                if (i == index) {
                    return element;
                }
                element = element.prev;
            }
        }


        return null;
    }

    public int size() {
        return length;
    }

    public boolean contains(Object o) {
        if (indexOf((T) o) > -1) {
            return true;
        }
        return false;
    }

    public void clear() {
        last = null;
        first = null;
        length = 0;
    }

    public void add(int index, T element) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        if (index == length) {
            this.addLast(element);
        } else if (index == 0) {
            this.addFirst(element);
        } else {

            Element<T> newElement = new Element<>(element);
            Element<T> oldElement;
            oldElement = getElement(index);
            newElement.next = oldElement;
            oldElement.prev.next = newElement;
            newElement.prev = oldElement.prev;
            oldElement.prev = newElement;
            length++;
        }

    }

    public void addLast(T element) {
        Element<T> newElement = new Element<>(element);
        if (last == null) {
            addFirst(element);
        } else {
            newElement.prev = last;
            last.next = newElement;
            last = newElement;
            length++;
        }

    }


    public void addFirst(T element) {
        Element<T> newElement = new Element<>(element);

        if (first == null) {
            last = newElement;
            first = newElement;
        } else {
            newElement.next = first;
            first.prev = newElement;
            first = newElement;
        }
        length++;

    }


    public T set(int index, T element) {
        Element<T> newElement = getElement(index);
        T something = newElement.data;
        newElement.data = element;
        return something;
    }

    public T get(int index) {
        Element<T> newElement = getElement(index);
        if (newElement == null) {
            return null;

        } else {
            return newElement.data;
        }
    }

    public int indexOf(T o) {
        Element<T> newElement = first;
        for (int i = 0; i <= length - 1; i++) {
            if (o.equals(newElement.data)) {
                return i;
            }
            newElement = newElement.next;
        }
        return -1;
    }

    public T remove(int index) {
        Element<T> element;
        element = getElement(index);
        if (index == length - 1) {
            last = element.prev;
            last.next = null;
            length--;
            return element.data;

        } else if (index == 0) {
            first = element.next;
            first.prev = null;
            length--;
            return element.data;
        } else {
            element.prev.next = element.next;
            element.next.prev = element.prev;
            length--;
            return element.data;
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
