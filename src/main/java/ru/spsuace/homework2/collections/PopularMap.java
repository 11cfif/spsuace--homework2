package ru.spsuace.homework2.collections;


import java.util.*;
import java.util.stream.Collectors;


/**
 * Написать структуру данных, реализующую интерфейс мапы + набор дополнительных методов.
 * 2 дополнительных метода должны вовзращать самый популярный ключ и его популярность.
 * Популярность - это количество раз, который этот ключ (или значение) учавствовал в методах мапы containsKey,
 * containsValue, get, put, remove в качестве аргумента или возвращаемого значения.
 * Читайте документацию к методам (ctrl + Q) для понимания, что где возвращается.
 * Считаем, что null я вам не передю ни в качестве ключа, ни в качестве значения
 *
 * Важный момент, вам не надо реализовывать мапу, вы должны использовать композицию.
 * Вы можете использовать любые коллекции, которые есть в java. Перечислю реализации основных типов коллекций:
 * List -> {@link java.util.ArrayList}
 * Set -> {@link java.util.HashSet}
 * Map -> {@link java.util.HashMap}
 * Stack -> {@link java.util.Stack}
 * Queue -> {@link java.util.LinkedList}
 * Deque -> {@link java.util.ArrayDeque}
 * Для быстрого перехода в нужный класс или метод, просто зажмите ctrl и щелкните по нему мышкой, или просто щелкните
 * колесиком. Бывает удобно, когда нужно переходить из одной точки кода в другую
 *
 * Помните, что по мапе тоже можно итерироваться
 *
 *         for (Map.Entry<K, V> entry : map.entrySet()) {
 *             entry.getKey();
 *             entry.getValue();
 *         }
 *
 *
 * Полный балл за все: 7
 * @param <K> - тип ключа
 * @param <V> - тип значения
 *
 */
public class PopularMap<K, V> implements Map<K, V> {

    private final Map<K, V> map;
    private final Map<K, Integer> keyPopMap;
    private final Map<V, Integer> valuePopMap;

    public PopularMap() {
        this.map = new HashMap<>();
        this.keyPopMap = new HashMap<>();
        this.valuePopMap = new HashMap<>();
    }

    public PopularMap(Map<K, V> map) {
        this.map = map;
        this.keyPopMap = new HashMap<>();
        this.valuePopMap = new HashMap<>();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        keyCounter(key);
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        if (value != null) {
            valueCounter(value);
        } else {
            valueCounter(null);
        }
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        keyCounter(key);
        V value = map.get(key);
        valueCounter(value);
        return value;
    }

    @Override
    public V put(K key, V value) {
        keyCounter(key);
        valueCounter(value);
        V result = map.put(key, value);
        if (valuePopMap.containsKey(result)){
            valueCounter(result);
        }
        return result;
    }

    @Override
    public V remove(Object key) {
        keyCounter(key);
        V value = map.remove(key);
        if (value != null) {
            valueCounter(value);
        }
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    private void keyCounter(Object key) {
        Integer count = keyPopMap.get(key);
        if (count == null) {
            count = 1;
            keyPopMap.put((K) key, count);
            return;
        }
        count = count + 1;
        keyPopMap.put((K) key, count);
    }

    private void valueCounter(Object value) {
        Integer count = valuePopMap.get(value);
        if (count == null) {
            count = 1;
            valuePopMap.put((V) value, count);
            return;
        }
        count = count + 1;
        valuePopMap.put((V) value, count);
    }

    /**
     * Возвращает самый популярный, на данный момент, ключ
     * 1 балл
     */
    public K getPopularKey() {
        return keyPopMap.entrySet().stream()
                .sorted(Map.Entry.<K, Integer>comparingByValue().reversed()).findFirst().get().getKey();
    }


    /**
     * Возвращает количество использование ключа
     * 1 балла
     */
    public int getKeyPopularity(K key) {
        if (keyPopMap.containsKey(key)) {
            return keyPopMap.get(key);
        } else {
            return 0;
        }
    }

    /**
     * Возвращает самое популярное, на данный момент, значение. Надо учесть что значени может быть более одного
     * 1 балл
     */
    public V getPopularValue() {
        return valuePopMap.entrySet().stream()
                .sorted(Map.Entry.<V, Integer>comparingByValue().reversed()).findFirst().get().getKey();
    }

    /**
     * Возвращает количество использований значений в методах: containsValue, get, put (учитывается 2 раза, если
     * старое значение и новое - одно и тоже), remove (считаем по старому значению).
     *  1 балл
     */
    public int getValuePopularity(V value) {
        if (valuePopMap.containsKey(value)) {
            return valuePopMap.get(value);
        } else {
            return 0;
        }
    }

    /**
     * Вернуть итератор, который итерируется по значениям (от самых НЕ популярных, к самым популярным)
     * 2 балла (Сортировать можно через метод Collections.sort() с использованием Comparator (как с фильтрами)
     */
    public Iterator<V> popularIterator() {

        Iterator<V> iterator = new Iterator<V>() {

            List<Entry<V, Integer>> iter = valuePopMap.entrySet().stream().sorted(Map.Entry.<V, Integer>comparingByValue()).collect(Collectors.toList());

            int cursor = 0;
            int size = iter.size();

            @Override
            public boolean hasNext() {
                if (cursor < size) {
                    return true;
                }
                return false;
            }

            @Override
            public V next() {
                if (cursor == size) {
                    throw new NoSuchElementException();
                }

                V v = iter.get(cursor).getKey();
                cursor = cursor + 1;
                return v;
            }
        };
        return iterator;
    }
}
