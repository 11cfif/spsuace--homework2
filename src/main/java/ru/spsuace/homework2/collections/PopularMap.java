package ru.spsuace.homework2.collections;


import java.util.*;

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
    private Map<K, Integer> keysMap = new HashMap<>();
    private Map<V, Integer> valueMap = new HashMap<>();

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
        count(key, keysMap);
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        count(value, valueMap);
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        count(key, keysMap);
        V value = map.get(key);
        count(value, valueMap);
        return value;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = map.put(key, value);
        count(key, keysMap);
        count(oldValue, valueMap);
        count(value, valueMap);
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        count(key, keysMap);
        V value = map.remove(key);
        count(value, valueMap);
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

    private void count(Object type, Map map) {
        if (type == null) {
            return;
        }
        if (map.containsKey(type)) {
            int temp = (int) map.get(type);
            temp++;
            map.put(type, temp);
        } else {
            map.put(type, 1);
        }
    }
    /**
     * Возвращает самый популярный, на данный момент, ключ
     * 1 балл
     */
    public K getPopularKey() {
        return countPopular(keysMap);
    }


    /**
     * Возвращает количество использование ключа
     * 1 балла
     */
    public int getKeyPopularity(K key) {
        return keysMap.getOrDefault(key, 0);
    }

    /**
     * Возвращает самое популярное, на данный момент, значение. Надо учесть что значени может быть более одного
     * 1 балл
     */
    public V getPopularValue() {
        return countPopular(valueMap);
    }

    public <T> T countPopular(Map<T, Integer> map) {
        T popular = null;
        int counter = 0;
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= counter) {
                popular = entry.getKey();
                counter = entry.getValue();
            }
        }
        return popular;
    }

    /**
     * Возвращает количество использований значений в методах: containsValue, get, put (учитывается 2 раза, если
     * старое значение и новое - одно и тоже), remove (считаем по старому значению).
     *  1 балл
     */
    public int getValuePopularity(V value) {
        return valueMap.getOrDefault(value, 0);
    }

    /**
     * Вернуть итератор, который итерируется по значениям (от самых НЕ популярных, к самым популярным)
     * 2 балла (Сортировать можно через метод Collections.sort() с использованием Comparator (как с фильтрами)
     */
    public Iterator<V> popularIterator() {
        return new MapIterator();
    }

    private class MapIterator implements Iterator {
        private Map<V, Integer> temp = sorting();
        private Iterator iter = temp.entrySet().iterator();

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public Object next() {
            return ((Entry) iter.next()).getKey();
        }
    }

    private Map<V, Integer> sorting() {
        Map<V, Integer> unsorted = valueMap;
        Map<V, Integer> sorted = new LinkedHashMap<>();
        List<Entry<V, Integer>> list = new ArrayList<>(unsorted.entrySet());
        Collections.sort(list, new Comparator<Entry<V, Integer>>() {
            public int compare(HashMap.Entry<V, Integer> map1, HashMap.Entry<V, Integer> map2) {
                return (map1.getValue()).compareTo(map2.getValue());
            }
        });
        for (Entry<V, Integer> entry : list) {
            sorted.put(entry.getKey(), entry.getValue());
        }
        return sorted;
    }
}
