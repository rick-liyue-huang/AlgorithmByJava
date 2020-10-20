package com.queue;


import com.array.Array;

public class ArrayQueue<E> implements Queue<E>  {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }
    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue: front [");
        for (int j = 0; j < array.getSize(); j++) {
            result.append(array.getElement(j));
            if (j != array.getSize() - 1) {
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
