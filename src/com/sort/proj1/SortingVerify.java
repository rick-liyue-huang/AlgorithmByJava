package com.sort.proj1;

public class SortingVerify {
    private SortingVerify() {}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {

        long startTime = System.nanoTime();
        if (sortName.equals("SelectionSort")) {
            SelectionSort.selectSort(arr);
        }
        else if (sortName.equals("InsertionSort")) {
            InsertionSort.insertSort(arr);
        }
        else if (sortName.equals("InsertionSort2")) {
            InsertionSort.insertSort2(arr);
        }
        else if (sortName.equals("InsertionSort3")) {
            InsertionSort.insertSort3(arr);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;

        if (!SortingVerify.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.println(String.format("%s, n = %d : %f", sortName, arr.length, time));
    }
}
