package ru.spsuace.homework2.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Написать структуру данных, реализующую интерфейс мапы + набор дополнительных методов.
 * 2 дополнительных метода должны вовзращать самый популярный ключ и его популярность.
 * Популярность - это количество раз, который этот ключ (или значение) учавствовал в методах мапы containsKey,
 * containsValue, get, put, remove в качестве аргумента или возвращаемого значения.
 * Читайте документацию к методам (ctrl + Q) для понимания, что где возвращается.
 * Считаем, что null я вам не передю ни в качестве ключа, ни в качестве значения
 * <p>
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
 * <p>
 * Помните, что по мапе тоже можно итерироваться
 * <p>
 * for (Map.Entry<K, V> entry : map.entrySet()) {
 * entry.getKey();
 * entry.getValue();
 * }
 * <p>
 * <p>
 * Полный балл за все: 7
 *
 * @param <K> - тип ключа
 * @param <V> - тип значения
 */
public class PopularMap<K, V> implements Map<K, V> {

    private final Map<K, V> map;
    private final Map<K, Integer> mapKey = new HashMap<>();
    private final Map<V, Integer> mapValue = new HashMap<>();

    public PopularMap() {
        this.map = new HashMap<>();
    }

    public PopularMap(Map<K, V> map) {
        this.map = map;
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
        KeyCount(key);
        return map.containsKey(key);
    }

    private void KeyCount(Object key) {
        Integer value = mapKey.get(key);
        if (value != null) {
            value++;
            mapKey.put((K) key, value);
        } else {
            mapKey.put((K) key, 1);
        }
    }

    @Override
    public boolean containsValue(Object value) {
        ValueCount(value);
        return map.containsValue(value);
    }

    private void ValueCount(Object Value) {
        Integer value = mapValue.get(Value);
        if (value != null) {
            value++;
            mapValue.put((V) Value, value);
        } else {
            mapValue.put((V) Value, 1);
        }
    }

    @Override
    public V get(Object key) {
        KeyCount(key);
        V value = map.get(key);
        ValueCount(value);
        return value;
    }

    @Override
    public V put(K key, V value) {
        KeyCount(key);
        V oldValue = map.get(key);
        if (oldValue != null) {
            ValueCount(oldValue);
        }
        ValueCount(value);
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        KeyCount(key);
        V value = map.remove(key);
        if (value != null) {
            ValueCount(value);
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

    /**
     * Возвращает самый популярный, на данный момент, ключ
     * 1 балл
     */
    public K getPopularKey() {
        return popularCount(mapKey);
    }


    /**
     * Возвращает количество использование ключа
     * 1 балла
     */
    public int getKeyPopularity(K key) {
        if (mapKey.get(key) == null) {
            return 0;
        }
        return mapKey.get(key);
    }

    /**
     * Возвращает самое популярное, на данный момент, значение. Надо учесть что значени может быть более одного
     * 1 балл
     */
    public V getPopularValue() {
        return popularCount(mapValue);
    }

    /**
     * Возвращает количество использований значений в методах: containsValue, get, put (учитывается 2 раза, если
     * старое значение и новое - одно и тоже), remove (считаем по старому значению).
     * 1 балл
     */
    public int getValuePopularity(V value) {
        if (mapValue.get(value) != null) {
            return mapValue.get(value);
        }
        return 0;
    }

    public <T> T popularCount(Map<T, Integer> map) {
        T popular = null;
        int count = 0;

        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= count) {
                popular = entry.getKey();
                count = entry.getValue();
            }
        }
        return popular;
    }

    /**
     * Вернуть итератор, который итерируется по значениям (от самых НЕ популярных, к самым популярным)
     * 2 балла (Сортировать можно через метод Collections.sort() с использованием Comparator (как с фильтрами)
     */
    public Iterator<V> popularIterator() {
        return null;
    }
}
