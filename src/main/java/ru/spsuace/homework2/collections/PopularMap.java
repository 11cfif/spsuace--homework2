package ru.spsuace.homework2.collections;


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Написать структуру данных, реализующую интерфейс мапы + набор дополнительных методов.
 * 2 дополнительных метода должны вовзращать самый популярный ключ и его популярность.
 * Популярность - это количество раз, который этот ключ учавствовал в других методах мапы, такие как
 * containsKey, get, put, remove.
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
 * Дополнительное задание описано будет ниже
 *
 * @param <K> - тип ключа
 * @param <V> - тип значения
 */
public class
PopularMap<K, V> implements Map<K, V> {

    private final Map<K, V> map;

    private Map<K, Integer> keysMap = new HashMap<>();
    private Map<V, Integer> valuesMap = new HashMap<>();

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
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        count(value, valuesMap);
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        V value = map.get(key);
        count(key, keysMap);
        count(value, valuesMap);

        return value;
    }

    @Override
    public V put(K key, V value) {
        V valuePut = map.put(key, value);

        count(value, valuesMap);

        count(valuePut, valuesMap);
        count(key, keysMap);

        return valuePut;
    }

    @Override
    public V remove(Object key) {
        V value = map.remove(key);
        count(key, keysMap);
        count(value, valuesMap);
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

    private void count(Object obj, Map map) {
        if (obj == null) {
            return;
        }
        if (map.containsKey(obj)) {
            int temp = (int) map.get(obj);
            temp++;
            map.put(obj, temp);
        } else {
            map.put(obj, 1);
        }
    }


    /**
     * Возвращает самый популярный, на данный момент, ключ
     */

    public <T> T countMostPopular(Map<T, Integer> map) {

        T currentPopular = null; // просто для теста
        int counter = 0;

        for (Map.Entry<T, Integer> entry : map.entrySet()) {

            if (entry.getValue() >= counter) {
                currentPopular = entry.getKey();
                counter = entry.getValue();
            }
        }

        return currentPopular;
    }


    public K getPopularKey() {

        return countMostPopular(keysMap);
    }


    /**
     * Возвращает количество использование ключа
     */
    public int getKeyPopularity(K key) {
        return keysMap.get(key);
    }

    /**
     * Дополнительное задание (1 балл)
     * Возвращает самое популярное, на данный момент, значение. Надо учесть что значени может быть более одного
     */
    public V getPopularValue() {
        return countMostPopular(valuesMap);
    }

    /**
     * Дополнительное задание (1 балл)
     * Возвращает количество использований значений в методах: containsValue, get, put (учитывается 2 раза, если
     * старое значение и новое - одно и тоже), remove (считаем по старому значению).
     */
    public int getValuePopularity(V value) {
        if (valuesMap.get(value) != null) {
            return valuesMap.get(value);
        }
        return 0;
    }

    /**
     * Дополнительное задание (2 балла)
     * Вернуть итератор, который итерируется по значениям (от самых НЕ популярных, к самым популярным)
     */
    public Iterator<V> popularIterator() {
        return null;
    }
}
