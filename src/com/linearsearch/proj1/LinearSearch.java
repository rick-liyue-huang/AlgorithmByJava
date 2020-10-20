package com.linearsearch.proj1;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object student) {
        if (this == student) return true;
        if (student == null) return false;
        if (this.getClass() != student.getClass()) return false;

        Student anotherStudent = (Student)student;
        return this.name.toLowerCase().equals(anotherStudent.name.toLowerCase());
    }
}

public class LinearSearch {
    private LinearSearch() {}
    public static <T> int search(T[] data, T target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /*
        Integer[] arr = {12, 23, 45, 16, 33, 90};

        for (int k = 0; k < 100; k++) {
            LinearSearch.search(arr, n);
        }
        int res1 = LinearSearch.search(arr, n);
        System.out.println(res1);

        Student[] students = {new Student("rick"), new Student("leo")};
        Student stu = new Student("LEO");
        int res2 = LinearSearch.search(students, stu);
        System.out.println(res2);
         */

        int[] dataSize = {1000000, 10000000};
        for (int n: dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs: " + time + "s" );
        }
    }
}
