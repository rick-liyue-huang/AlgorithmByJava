package com.sort.proj1;

import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {}

    public static <E extends Comparable<E>> void insertSort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {
//            将 arr[i] 放入合适的位置
            /*for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
                else break;
            }*/
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void insertSort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
//            将 arr[i] 寄存起来然后处理
            E temp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static <E extends Comparable<E>> void insertSort3(E[] arr) {
        for(int i = arr.length - 1; i >= 0; i --){

            // 将 arr[i] 插入到合适的位置
            E t = arr[i];
            int j;
            for(j = i; j + 1 < arr.length && t.compareTo(arr[j + 1]) > 0; j ++){
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n: dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//            Integer[] arr = ArrayGenerator.generateOrderedArray(n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            Integer[] arr3 = Arrays.copyOf(arr, arr.length);
            SortingVerify.sortTest("InsertionSort", arr);
            SortingVerify.sortTest("InsertionSort2", arr2);
            SortingVerify.sortTest("InsertionSort3", arr3);
        }
    }
}
