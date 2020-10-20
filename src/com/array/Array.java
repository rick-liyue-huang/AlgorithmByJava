package com.array;

public class Array {
    private int[] data;
    private int size;  // 实际的数组长度 区别于 data.length

    /**
     * 构造函数创建容量为capacity的数组
     * @param capacity
     */
    public Array(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    /**
     * 默认的构造函数创建容量为10的数组
     */
    public Array() {
        this(10);
    }

    /**
     * 得到数组的实际大小
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 得到数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组最后的位置添加元素
     * @param el
     */
    public void addLast(int el) {
        /*if (size == data.length) {
            throw new IllegalArgumentException("add last failed, array is full");
        }
        data[size++] = el;*/
        addOnPosition(size, el);
    }

    /**
     * 在开始位置添加元素
     * @param el
     */
    public void addFirst(int el) {
        addOnPosition(0, el);
    }

    /**
     * 在指定位置添加元素
     * @param index
     * @param el
     */
    public void addOnPosition(int index, int el) {
        if (size == data.length) {
            throw new IllegalArgumentException("add last failed, array is full");
        }
        if (index < 0|| index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = el;
        size++;
    }

}



















