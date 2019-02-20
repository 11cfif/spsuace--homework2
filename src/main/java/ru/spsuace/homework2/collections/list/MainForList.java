package ru.spsuace.homework2.collections.list;

public class MainForList {

    public static void main(String[] args) {

        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        ///////////////////////////
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        list.addLast(5);
        list.addLast(6);

        list.displayForward();
        System.out.println("size: " +list.size());
        ///////////////////////////
        System.out.println("--------------------------------");
        list.add(3, 4);

        list.displayForward();
        System.out.println("size: " +list.size());

        ////////////////////////////////
        System.out.println("check if list contain 11: " + list.contains(11));
        System.out.println("check if list contain 4: " + list.contains(4));
        System.out.println("index of 11: " + list.indexOf(11));
        System.out.println("index of 3: " + list.indexOf(3));
        System.out.println("Get list[0]: " + list.get(0));
        System.out.println("Get list[3]: " + list.get(3));

        /////////////////////////
        System.out.println("--------------------------------");
        System.out.println("Set List[0]: " + list.set(0, 2));
        System.out.println("Set List[2]: " + list.set(2, 2));
        System.out.println("getFirst: " + list.getFirst());
        System.out.println("getLast: " + list.getLast());
        list.displayForward();

        /////////////////////////
        System.out.println("--------------------------------");
        list.remove(0);
        list.remove(4);
        System.out.println("Remove 0 and 4 indexes");
        list.displayForward();

        /////////////////////////
        System.out.println("--------------------------------");
        System.out.println("Check if empty: " + list.isEmpty());
        System.out.println("Clear list..." );
        list.clear();
        System.out.println("Check if empty: " + list.isEmpty());
        System.out.println("size: " + list.size());
    }

}
