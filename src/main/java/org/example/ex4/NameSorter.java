package org.example.ex4;

import java.util.Comparator;
import java.util.List;

public class NameSorter implements Sorter {

    @Override
    public void sort(List<User> users) {
        users.sort(Comparator.comparing(User::getName));
    }
}
