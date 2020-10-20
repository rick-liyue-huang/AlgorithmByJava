package com.array;

public class Array<E> {
    private E[] data;
    private int size;  // 实际的数组长度 区别于 data.length

    /**
     * 构造函数创建容量为capacity的数组
     * @param capacity
     */
    public Array(int capacity) {
        this.data = (E[])(new Object[capacity]);
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
    public void addLast(E el) {
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
    public void addFirst(E el) {
        addOnPosition(0, el);
    }

    /**
     * 在指定位置添加元素
     * @param index
     * @param el
     */
    public void addOnPosition(int index, E el) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }

//        处理扩容
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = el;
        size++;
    }

    /**
     * 得到index对应的数组
     * @param index
     * @return
     */
    public E getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, index is illegal");
        }
        return data[index];
    }

    /**
     * 得到最后一个元素
     * @return
     */
    public E getLast() {
        return getElement(size - 1);
    }

    /**
     * 得到第一个元素
     * @return
     */
    public E getFirst() {
        return getElement(0);
    }

    /**
     *
     * @param index
     * @param el
     */
    public void setElement(int index, E el) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, index is illegal");
        }
        data[index] = el;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 查看是否包括元素
     * @param el
     * @return
     */
    public boolean contains(E el) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(el)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查看包含元素的索引
     * @param el
     * @return
     */
    public int find(E el) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(el)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回删除的元素
     * @param index
     * @return
     */
    public E removeOnPosition(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // loitering object != memory leak 防止

//        处理缩小容量
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除并且返回第一个元素
     * @return
     */
    public E removeFirst() {
        return removeOnPosition(0);
    }

    /**
     * 删除并且返回最后一个元素
     * @return
     */
    public E removeLast() {
        return removeOnPosition(size - 1);
    }

    public void removeElement(E el) {
        int index = find(el);
        if (index != -1) {
            removeOnPosition(index);
        }
    }

    /**
     * 实现动态数组的能力
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[])(new Object[newCapacity]);
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}



















