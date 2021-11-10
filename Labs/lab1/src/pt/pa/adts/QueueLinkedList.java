package pt.pa.adts;

/**
 *  Nuno Reis
 *  nº 202000753
 */

/**
 * Implementation of a queue based in linked list
 *
 * @param <E>
 */
public class QueueLinkedList<E> implements Queue<E> {

    private ListNode header, trailer;
    private int size;

    /**
     * Constructor of an object of type QueueLinkedList
     * Complexity: O(1)
     */
    public QueueLinkedList() {
        this.trailer = new ListNode(null, null, null);
        this.header  = new ListNode(null, null, this.trailer);
        this.trailer.prev = this.header;

        this.size = 0;
    }

    /**
     * Insert an element in the final of the queue
     * Complexity: O(1)
     *
     * @param element to insert
     */
    @Override
        public void enqueue(E element){
        try {
            /*ListNode newNode = new ListNode(element, trailer.prev, trailer);
            trailer.prev.next = newNode;
            trailer.prev = newNode;*/

            ListNode prevNode = trailer.prev;
            ListNode newNode = new ListNode(element, prevNode, trailer);
            trailer.prev = newNode;
            prevNode.next = newNode;

            size++;
        }
        catch (OutOfMemoryError otme)
        {
            throw new FullQueueException();
        }
    }

    /**
     * remove and return the element on the front of the queue
     * Complexity: O(1)
     *
     * @return the front element
     * @throws EmptyQueueException if the queue is empty
     */
    @Override
    public E dequeue() throws EmptyQueueException {
        if(this.isEmpty()) throw new EmptyQueueException();

        E removeElem = this.header.next.element;

        this.header.next.next.prev = this.header;
        this.header.next = this.header.next.next;

        size--;

        return removeElem;
    }

    /**
     * return the element on the front of the queue
     * Complexity: O(1)
     *
     * @return the front element
     * @throws EmptyQueueException if the queue is empty
     */
    @Override
    public E front() throws EmptyQueueException {
        if(this.isEmpty()) throw new EmptyQueueException();

        return this.header.next.element;
    }

    /**
     * get the size
     * Complexity: O(1)
     *
     * @return the size of the queue
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * see if the queue is empty
     * Complexity: O(1)
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    /**
     * clear the queue
     *
     * Complexity: O(1)
     */
    @Override
    public void clear() {
        this.header.prev = this.trailer;
        this.trailer.prev = this.header;

        this.size = 0;
    }

    private class ListNode {
        private E element;
        private ListNode next;
        private ListNode prev;

        public ListNode(E element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
