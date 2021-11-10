package pt.pa.adts;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StackArrayList<T> implements Stack<T> {
    private static final int DEFAULT_CAPACITY = 40;

    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public StackArrayList() {
        this.elements = (T[])new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void push(T element) throws FullStackException {
        if(this.size >= this.elements.length) //throw new FullStackException();
        {
            T[] expanded = (T[]) new Object[this.elements.length * 2];
            System.arraycopy(elements, 0, expanded, 0, size);
            elements = expanded;
        }

        this.elements[this.size++] = element;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(this.isEmpty()) throw new EmptyStackException();

        T elem = this.elements[this.size - 1];
        this.elements[this.size - 1] = null; //Q: Strictly necessary? Why is it a good idea?
        this.size--;

        return elem;
    }

    @Override
    public T peek() throws EmptyStackException {
        if(this.isEmpty()) throw new EmptyStackException();

        return this.elements[this.size - 1];
    }

    @Override
    public int size() { return this.size; }

    @Override
    public boolean isEmpty() { return this.size == 0; }

    @Override
    public void clear() {
        this.elements = (T[])new Object[DEFAULT_CAPACITY];
        this.size = 0;

        /*
        while (!isEmpty()) {
            this.pop();
        }
        */
    }
}
