package ru.spsuace.homework2.collections;


import java.util.*;



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
    private final Map<K, Integer> keysMap = new HashMap<>();
    private final Map<V, Integer> valueMap = new HashMap<>();

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
        incrementKey((K) key);
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        incrementValue((V) value);
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        incrementKey((K) key);
        V value = map.get(key);
        incrementValue(value);
        return value;
    }

    @Override
    public V put(K key, V value) {
        incrementKey(key);
        incrementValue(value);
        V oldValue = map.put(key, value);
        incrementValue(oldValue);
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        incrementKey((K) key);
        V oldValue = map.remove(key);
        incrementValue(oldValue);
        return oldValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
        keysMap.clear();
        valueMap.clear();
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

    private void incrementKey(K key) {
        if (key != null) {
            keysMap.put(key, keysMap.getOrDefault(key, 0) + 1);
        }
    }

    private void incrementValue(V value) {
        if (value != null) {
            valueMap.put(value, valueMap.getOrDefault(value, 0) + 1);
        }
    }

    /**
     * Возвращает самый популярный, на данный момент, ключ
     * 1 балл
     */
    public K getPopularKey() {
        Entry<K, Integer> maxEntry = null;
        for (Entry<K, Integer> entry : keysMap.entrySet()) {
            if (maxEntry == null) {
                maxEntry = entry;
            } else if (maxEntry.getValue() < entry.getValue())
                maxEntry = entry;
        }
        return maxEntry == null ? null : maxEntry.getKey();
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
        Entry<V, Integer> maxEntry = null;
        for (Entry<V, Integer> entry : valueMap.entrySet()) {
            if (maxEntry == null) {
                maxEntry = entry;
            } else if (maxEntry.getValue() < entry.getValue())
                maxEntry = entry;
        }
        return maxEntry == null ? null : maxEntry.getKey();

    }

    /**
     * Возвращает количество использований значений в методах: containsValue, get, put (учитывается 2 раза, если
     * старое значение и новое - одно и тоже), remove (считаем по старому значению).
     * 1 балл
     */
    public int getValuePopularity(V value) {
        return valueMap.getOrDefault(value, 0);
    }

    /**
     * Вернуть итератор, который итерируется по значениям (от самых НЕ популярных, к самым популярным)
     * 2 балла (Сортировать можно через метод Collections.sort() с использованием Comparator (как с фильтрами)
     */
    public Iterator<V> popularIterator() {
        List<V> values = new ArrayList<>(valueMap.keySet());
        values.sort((value1, value2) -> {
            return valueMap.getOrDefault(value1, 0) - valueMap.getOrDefault(value2, 0);
        });
        return values.iterator();
    }
}
