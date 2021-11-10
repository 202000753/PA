package pt.pa.adts;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StackLinkedList<T> implements Stack<T> {

    private Node top; //sentinel of linked list
    private int size;

    public StackLinkedList() {
        /*
        The configuration of an empty singly linked list is the sentinel
        pointing to null.
         */
        this.top = new Node(null, null);
        this.size = 0;
    }

    @Override
    public void push(T element) throws FullStackException {
        Node newNode = new Node(element, top.next);
        top.next = newNode;
        size++;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(this.isEmpty()) throw new EmptyStackException();

        T elem = this.top.next.element;

        Node newTop = top.next.next;
        top.next = newTop;

        size--;

        return elem;
    }

    @Override
    public T peek() throws EmptyStackException {
        if(this.isEmpty()) throw new EmptyStackException();

        return this.top.next.element;
    }

    @Override
    public int size() { return this.size; }

    @Override
    public boolean isEmpty() { return size==0; }

    @Override
    public void clear() {
        top.next = null;
        size = 0;
    }

    /**
     * Inner class representing a linked list node.
     * Only recognized in the context of this class (private).
     */
    private class Node {
        private T element;
        private Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
