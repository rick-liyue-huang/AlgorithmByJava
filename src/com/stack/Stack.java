package com.stack;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E el);
    E pop();
    E peek();
}
