package org.example.ex4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Karina", 24));
        users.add(new User("Igor", 35));
        users.add(new User("Misha", 20));
        users.add(new User("Karina", 19));
        users.add(new User("Alina", 8));

        Sorter sorter = new NameSorter();
        sorter.sort(users);
        System.out.println("Отсортированы по имени:");
        for (User user: users) {
            user.print();
        }

        sorter = new AgeSorter();
        sorter.sort(users);
        System.out.println("Отсортированы по возврасту:");
        for (User user: users) {
            user.print();
        }
    }
}
