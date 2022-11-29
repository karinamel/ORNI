package org.example.ex3;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Storekeeper {
    private int[] array;

    public Storekeeper(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
        }
        Collections.shuffle(arrayList);
        this.array = new int[n];
        for (int i = 0; i < n; i++) {
            this.array[i] = arrayList.get(i);
        }
    }

    public abstract void sort();

    public void sortWithPrintTime() {
        long start = System.currentTimeMillis();
        sort();
        System.out.println(this.getClass().getSimpleName() + ": " + (System.currentTimeMillis() - start)  + " ms");
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

}
