package pt.pa.adts;

public interface Stack<T>  {
    /**
     * insert element on the top of the stack
     * @param element to insert
     * @throws FullStackException if there is no space for more elements
     */
    public void push(T element) throws FullStackException;

    /**
     * remove and return the element on top of the stack
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() throws EmptyStackException;

    /**
     * return the element on top of the stack
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    public T peek() throws EmptyStackException;

    /**
     *
     * @return the size of the stack
     */
    public int size();

    /**
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty();

    /**
     * clear the stack
     */
    public void clear();
}