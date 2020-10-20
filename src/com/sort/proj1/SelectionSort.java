package com.sort.proj1;

/**
 * 循环不变量：
 * arr[i, ... n) 未排序
 * arr[0, ... i) 已排序  循环不变量
 * arr[i, ... n) 中最小值要放到 arr[i] 的位置上
 */
public class SelectionSort {

    private SelectionSort() {}

    public static <E extends Comparable<E>> void selectSort(E[] arr) {


        /*for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] <= arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }*/



        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        /*Integer[] arr = {12, 4, 56, 2, 1};
        SelectionSort.selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();*/

        /*Student[] students = {new Student("rick", 100),
                new Student("leo", 90),
                new Student("claire", 98)};
        SelectionSort.selectSort(students);
        for (Student stu: students) {
            System.out.print(stu + " ");
        }
        System.out.println();*/

        int[] dataSize = {10000, 100000};
        for (int n: dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingVerify.sortTest("SelectionSort", arr);
        }

        /*long startTime = System.nanoTime();
        SelectionSort.selectSort(arr);
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;

        if (!SortingVerify.isSorted(arr)) {
            throw new RuntimeException("selectionSort failed");
        }
        System.out.println("time: " + time);*/



    }
}
