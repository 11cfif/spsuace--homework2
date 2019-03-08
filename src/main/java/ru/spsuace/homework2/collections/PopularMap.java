package ru.spsuace.homework2.collections;

import java.util.*;
import java.util.Map;

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

    private HashMap<K, Integer> keysMap = new HashMap<>();
    private HashMap<V, Integer> valueMap = new HashMap<>();

    public PopularMap() {
        this.map = new HashMap<>();
    }

    public PopularMap(Map<K, V> map){
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
        countValue((V)value);
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        countKeys(key);

        V value = map.get(key);
        countValue(value);

        return value;
    }

    @Override
    public V put(K key, V value) {
        countKeys(key);

        if (map.containsKey(key)) {
            countValue(map.get(key));
        }

        countValue(value);

        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {

        countKeys(key);
        countValue(map.get(key));

        return map.remove(key);
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

    private void countKeys(Object key) {

        if (keysMap.containsKey(key)) {
            int temp = keysMap.get(key);
            temp++;
            keysMap.put((K)key, temp);

        }else {
            keysMap.put((K)key, 1);
        }
    }

    private void countValue(V value) {
        if (value == null){
            return;
        }
        
        if (valueMap.containsKey(value)) {
            int temp = valueMap.get(value);
            temp++;
            valueMap.put(value, temp);
        } else {
            valueMap.put(value, 1);
        }
    }

    /**
     * Возвращает самый популярный, на данный момент, ключ
     */
    public K getPopularKey() {

        K moreRepeatable = null;
        int counter = 0;

        for (Map.Entry<K, Integer> entry : keysMap.entrySet()) {

            if (entry.getValue() > counter) {
                counter = entry.getValue();
                moreRepeatable = entry.getKey();
            }

        }
        return moreRepeatable;
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

        List<V> values = new ArrayList<>();

        int counter = 0;

        for (Map.Entry<V, Integer> entry : valueMap.entrySet()) {

            if (entry.getValue() == counter) {
                values.add(entry.getKey());

            }

            if (entry.getValue() > counter) {
                values.clear();
                values.add(entry.getKey());
            }
        }

        return values.get(0);
    }

    /**
     * Дополнительное задание (1 балл)
     * Возвращает количество использований значений в методах: containsValue, get, put (учитывается 2 раза, если
     * старое значение и новое - одно и тоже), remove (считаем по старому значению).
     */
    public int getValuePopularity(V value) {
        if (valueMap.containsKey(value)) {
            return valueMap.get(value);
        }
        return 0;
    }

    /**
     * Дополнительное задание (2 балла)
     * Вернуть итератор, который итерируется по значениям (от самых НЕ популярных, к самым популярным)
     */
    public Iterator<V> popularIterator() {

        return new hashMapIterator();
    }

    private class hashMapIterator implements Iterator {

        private HashMap<V, Integer> temp = sorting();
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

    public HashMap<V, Integer> sorting(){

        HashMap<V, Integer> unsorted = valueMap;
        HashMap<V, Integer> sorted = new LinkedHashMap<>();

        List<Entry<V, Integer>> list = new LinkedList<>(unsorted.entrySet());


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
