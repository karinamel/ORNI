package org.example.ex3;

public class Main {
    public static void main(String[] args) {
        Storekeeper storekeeperJun = new JuniorStorekeeper(10000);
        Storekeeper storekeeperSenior = new SeniorStorekeeper(10000);

        storekeeperJun.sortWithPrintTime();
        storekeeperSenior.sortWithPrintTime();
    }
}
