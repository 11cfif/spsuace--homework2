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
        mapCount(key, mapKey);
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        mapCount(value, mapValue);
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        V number = map.get(key);
        mapCount(key, mapKey);
        mapCount(number, mapValue);

        return number;
    }

    @Override
    public V put(K key, V value) {
        V putNumber = map.put(key, value);
        mapCount(value, mapValue);
        mapCount(putNumber, mapValue);
        mapCount(key, mapKey);

        return putNumber;
    }

    @Override
    public V remove(Object key) {
        V removeNumber = map.remove(key);
        mapCount(key, mapKey);
        mapCount(removeNumber, mapValue);

        return removeNumber;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        //throw new UnsupportedOperationException("putAll");
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
        return popularCount(mapKey);
    }


    /**
     * Возвращает количество использование ключа
     */
    public int getKeyPopularity(K key) {
        if (mapKey.get(key) == null){
            return 0;
        }
        return mapKey.get(key);
    }

    private <T> void mapCount(Object obj, Map<T, Integer> map) {
        if (map.containsKey(obj) && obj != null) {
            int pattern;
            pattern = map.get(obj);
            map.put((T) obj, ++pattern);
        } else {
            map.put((T) obj, 1);
        }
    }

    public <T> T popularCount(Map<T, Integer> map) {
        T mapPopular = null;
        int count = 0;

        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= count) {
                mapPopular = entry.getKey();
                count = entry.getValue();
            }
        }
        return mapPopular;
    }
    /**
     * Дополнительное задание (1 балл)
     * Возвращает самое популярное, на данный момент, значение. Надо учесть что значени может быть более одного
     */
    public V getPopularValue() {
        return null;
    }

    /**
     * Дополнительное задание (1 балл)
     * Возвращает количество использований значений в методах: containsValue, get, put (учитывается 2 раза, если
     * старое значение и новое - одно и тоже), remove (считаем по старому значению).
     */
    public int getValuePopularity(V value) {
        return 0;
    }

    /**
     * Дополнительное задание (1 балла)
     * Вернуть итератор, который итерируется по значениям (от самых НЕ популярных, к самым популярным)
     */
    public Iterator<V> popularIterator() {
        return null;
    }
}
