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
 * Дополнительное задание описано будет ниже
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
        popKeys(key);
        return map.containsKey(key);
    }

    private void popKeys(Object key) {
        Integer value = mapKey.get(key);
        if (value == null){
            mapKey.put((K) key, 1);
        } else {
            mapKey.put((K) key, value + 1);
        }
    }

    @Override
    public boolean containsValue(Object value) {
        popValues(value);
        return map.containsValue(value);
    }

    private void popValues(Object Value) {
        Integer value = mapValue.get(Value);
        if (value != null) {
            mapValue.put((V) Value, value + 1);
        } else {
            mapValue.put((V) Value, 1);
        }
    }

    @Override
    public V get(Object key) {
        V value = map.get(key);
        popKeys(key);
        popValues(value);
        return value;
    }

    @Override
    public V put(K key, V value) {
        popKeys(key);
        popValues(value);
        if (map.get(key) != null) popValues(map.get(key));
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        popKeys(key);
        V value = map.remove(key);
        if (value != null) popValues(value);
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
     */
    public K getPopularKey() {
        return popCount(mapKey);
    }


    /**
     * Возвращает количество использование ключа
     */
    public int getKeyPopularity(K key) {
        if(mapKey.get(key) == null) return 0;
        return mapKey.get(key);
    }

    public <T> T popCount(Map<T, Integer> map) {
        T pop = null;
        int count = 0;
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= count) {
                pop = entry.getKey();
                count = entry.getValue();
            }
        }
        return pop;
    }

    /**
     * Дополнительное задание (1 балл)
     * Возвращает самое популярное, на данный момент, значение. Надо учесть что значени может быть более одного
     */
    public V getPopularValue() {
        return popCount(mapValue);
    }

    /**
     * Дополнительное задание (1 балл)
     * Возвращает количество использований значений в методах: containsValue, get, put (учитывается 2 раза, если
     * старое значение и новое - одно и тоже), remove (считаем по старому значению).
     */
    public int getValuePopularity(V value) {
        if(mapValue.get(value) == null) {
            return 0;
        }
        return mapValue.get(value);
    }

    /**
     * Дополнительное задание (1 балла)
     * Вернуть итератор, который итерируется по значениям (от самых НЕ популярных, к самым популярным)
     */
    public Iterator<V> popularIterator() {
        return null;
    }
}
