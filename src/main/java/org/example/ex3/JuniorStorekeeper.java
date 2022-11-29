package org.example.ex3;

public class JuniorStorekeeper extends Storekeeper {

    public JuniorStorekeeper(int n) {
        super(n);
    }

    public void bubbleSort() {
        int[] array = this.getArray();
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j + 1] < array[j]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
    }

    @Override
    public void sort() {
        this.bubbleSort();
    }
}
