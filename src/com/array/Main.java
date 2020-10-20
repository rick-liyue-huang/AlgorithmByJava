package com.array;

import com.sort.proj1.Student;

public class Main {
    public static void main(String[] args) {

        Array<Integer> arr = new Array<Integer>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.addLast(11);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

//        arr.addOnPosition(1, 100);
//        System.out.println(arr);
//
//        arr.addFirst(-1);
//        System.out.println(arr);
//
//        System.out.println(arr.getElement(0));
//        arr.setElement(0, 89);
//        System.out.println(arr);
//
//        arr.removeOnPosition(2);
//        System.out.println(arr);
//        arr.removeElement(4);
//        System.out.println(arr);
//
//        arr.removeFirst();
//        System.out.println(arr);

        Array<Student> students = new Array<>();
        students.addLast(new Student("Rick", 100));
        students.addLast(new Student("Leo", 90));
        students.addLast(new Student("Claire", 80));
        System.out.println(students);
    }
}
