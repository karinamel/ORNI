package org.example.ex3;

import java.util.Arrays;

public class SeniorStorekeeper extends JuniorStorekeeper {

    public SeniorStorekeeper(int n) {
        super(n);
    }

    public void mergeSort() {
        int[] array = this.getArray();
        int[] buffer1 = Arrays.copyOf(array, array.length);
        int[] buffer2 = new int[array.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, array.length);
        this.setArray(result);
    }

    public int[] mergeSortInner(int[] buffer1, int[] buffer2,
                                       int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    @Override
    public void sort() {
        this.mergeSort();
    }
}
