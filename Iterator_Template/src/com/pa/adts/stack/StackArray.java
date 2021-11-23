/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.adts.stack;

import java.util.Iterator;

public class StackArray<E> implements Stack<E> {

    private E[] storage;
    private int size;
    private final static int MAX = 500;

    public StackArray(int capacity) {
        storage = (E[]) new Object[capacity];
        size = 0;
    }

    public StackArray() {
        this(MAX);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
       return size == 0;
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return storage[size - 1];
    }

    @Override
    public void push(E elem) throws FullStackException {
        if (size == storage.length) {
            throw new FullStackException();
        }
        storage[size++] = elem;
    }

    @Override
    public E pop() throws EmptyStackException {
     E elem = peek();
     storage[--size]=null;
     return elem;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorStack();
    }

    private class IteratorStack implements Iterator<E> {

        private int pos;

        public IteratorStack() {
            pos=size-1;
        }

        @Override
        public boolean hasNext() {
            return pos>=0;
        }

        @Override
        public E next() {
            E elem= storage[pos];
            pos--;
            return elem;
        }
    }
}
