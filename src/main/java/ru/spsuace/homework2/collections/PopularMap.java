package ru.spsuace.homework2.collections;


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Написать структуру данных, реализующую интерфейс мапы + набор дополнительных методов.
 * 2 дополнительных метода должны вовзращать самый популярный ключ и его популярность.
 * Популярность - это количество раз, который этот ключ (или значение) учавствовал в методах мапы containsKey,
 * containsValue, get, put, remove в качестве аргумента или возвращаемого значения.
 * Читайте документацию к методам (ctrl + Q) для понимания, что где возвращается.
 * Считаем, что null я вам не передаю ни в качестве ключа, ни в качестве значения
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

    private final Map<V,Integer> ValueMap= new HashMap<>();
    private final Map<K,Integer> KeyMap= new HashMap<>();
    public PopularMap() {
        this.map = new HashMap<>();
    }

    public PopularMap(Map<K, V> map) {
        this.map = map;
    }

    private <T> void UsabilityCount(Map<T, Integer> UsabilityMap, Object object) {
        int UsedCount = UsabilityMap.getOrDefault((T) object, 0);
        UsabilityMap.put((T) object, ++UsedCount);
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
        UsabilityCount(KeyMap, key);
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        UsabilityCount(ValueMap, value);
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        V value = map.get(key);
        UsabilityCount(KeyMap, key);

        if (value != null) {
            UsabilityCount(ValueMap, value);
        }
        return value;
    }

    @Override
    public V put(K key, V value)
    {        V oldValue = map.put(key, value);
        if (oldValue != null) {
            UsabilityCount(ValueMap, oldValue);
        }

        UsabilityCount(KeyMap, key);
        UsabilityCount(ValueMap, value);
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        V removedValue = map.remove(key);
        UsabilityCount(KeyMap, key);

        if (removedValue != null) {
            UsabilityCount(ValueMap, removedValue);
        }
        return removedValue;
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

    public <T> T TheMostUsedObject(Map<T, Integer> UsabilityMap) {
        if (UsabilityMap.isEmpty()) {
            return null;
        }

        Entry<T, Integer> MostUsedEntry = null;

        for (Entry<T, Integer> UsedCount : UsabilityMap.entrySet()) {
            if (MostUsedEntry == null || MostUsedEntry.getValue() <= UsedCount.getValue()) {
                MostUsedEntry = UsedCount;
            }
        }
        return MostUsedEntry.getKey();
    }

    /**
     * Возвращает самый популярный, на данный момент, ключ
     * 1 балл
     */
    public K getPopularKey() {
        return TheMostUsedObject(KeyMap);
    }


    /**
     * Возвращает количество использование ключа
     * 1 балла
     */
    public int getKeyPopularity(K key) {
        return KeyMap.getOrDefault(key,0);
    }

    /**
     * Возвращает самое популярное, на данный момент, значение. Надо учесть что значени может быть более одного
     * 1 балл
     */
    public V getPopularValue() {
        return TheMostUsedObject(ValueMap);
    }

    /**
     * Возвращает количество использований значений в методах: containsValue, get, put (учитывается 2 раза, если
     * старое значение и новое - одно и тоже), remove (считаем по старому значению).
     *  1 балл
     */
    public int getValuePopularity(V value) {
        return ValueMap.getOrDefault(value,0);
    }

    /**
     * Вернуть итератор, который итерируется по значениям (от самых НЕ популярных, к самым популярным)
     * 2 балла (Сортировать можно через метод Collections.sort() с использованием Comparator (как с фильтрами)
     */
    public Iterator<V> popularIterator() {
        return ValueMap.entrySet()
                .stream()
                .sorted(Entry.comparingByValue())
                .map(Entry::getKey)
                .collect(Collectors.toList())
                .iterator();

    }
}
