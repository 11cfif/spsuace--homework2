package ru.spsuace.homework2.collections;


/*import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;*/
import java.util.*;


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
    private Map<K, Integer> counterMap = new HashMap<>();

    public PopularMap() {
        this.map = new HashMap<>();
    }

    public PopularMap(Map<K, V> map) {
        this.map = map;
    }

    @Override
    public int size() {
        return map.size();
    } //Размер

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    } //Проверить что Map — пустой

    @Override
    public boolean containsKey(Object key) {
        counter(key, counterMap);
        return map.containsKey(key);
    } //Проверить наличие «ключа»


    public void counter(Object obj, Map map){

        if (!map.containsKey(obj)){
        }else {
            map.put(obj, (int) map.get(obj) + 1);
        }

    }
    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    } //Проверить наличие «значения»

    @Override
    public V get(Object key) {
        counter(key, counterMap);
        return map.get(key);
    } //Получить значение по ключу

    @Override
    public V put(K key, V value) {
        counter(key, counterMap);
        return map.put(key,value);
    } //Добавить пару

    @Override
    public V remove(Object key) {
        counter(key, counterMap);
        return map.remove(key);
    } //Удалить элемент по ключу

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    //Зачем это написано?
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
        return map.entrySet() ;
    }

    /**
     * Возвращает самый популярный, на данный момент, ключ
     */
    public K getPopularKey() {

        int counter = 0;
        K key = null;

        for (Map.Entry<K, Integer> pair : counterMap.entrySet()) {

            int value = pair.getValue();

            if(counter < value){
                counter = value;
                key = pair.getKey(); //ключ
            }

        }

        return key;
    }


    /**
     * Возвращает количество использование ключа
     */
    public int getKeyPopularity(K key) {
        return counterMap.get(key);
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
     * Дополнительное задание (2 балла)
     * Вернуть итератор, который итерируется по значениям (от самых НЕ популярных, к самым популярным)
     */
    public Iterator<V> popularIterator() {
        return null;
    }
}
