package pt.pa.adts;

/**
 *  Nuno Reis
 *  nº 202000753
 */

/**
 * Describes the behavior of a queue
 *
 * @param <E> Genric type that represents an element
 */
public interface Queue<E> {
    /**
     * Insert an element in the final of the queue
     *
     * @param element to insert
     */
    public void enqueue(E element);

    /**
     * remove and return the element on the front of the queue
     *
     * @return the front element
     * @throws EmptyQueueException if the queue is empty
     */
    public E dequeue() throws EmptyQueueException;

    /**
     * return the element on the front of the queue
     *
     * @return the front element
     * @throws EmptyQueueException if the queue is empty
     */
    public E front() throws EmptyQueueException;

    /**
     * get the size
     *
     * @return the size of the queue
     */
    public int size();

    /**
     * see if the queue is empty
     *
     * @return true if the queue is empty
     */
    public boolean isEmpty();

    /**
     * clear the queue
     */
    public void clear();
}
