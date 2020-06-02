package ru.spsuace.homework2.stepic;

import java.util.Scanner;

public class Main {
//
//    Darko 10
//    Marko 5
//    Ana 24
//    END!

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.next();
//        while (!str.equals("END!")) {
//            System.out.print(str + " ");
//            int number = scanner.nextInt();
//            System.out.print(number);
//            str = scanner.next();
//        }
//    }


//    2
//    we you
//    not yes
//    Are we going home? Of course not.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
//        scanner.nextLine();

        String[][] commands = new String[count][2];
        for (int i = 0; i < count; i++) {
            commands[i][0] = scanner.next();
            commands[i][1] = scanner.next();
            System.out.println("command " + i + " " + commands[i][0] + commands[i][1]);
        }

        String line = scanner.nextLine();
        System.out.println("line: " + line);

    }
}

class Second extends Main {

}
