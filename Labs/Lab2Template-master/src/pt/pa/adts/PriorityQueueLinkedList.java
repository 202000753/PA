package pt.pa.adts;


/**
 *
 * @author brunomnsilva
 */
public class PriorityQueueLinkedList<E extends Comparable> implements Queue<E> {

    private final ListNode header, trailer;
    //private int size;

    public PriorityQueueLinkedList() {
        this.trailer = new ListNode(null, null, null); //header not instantiated yet!
        this.header = new ListNode(null, null, this.trailer);
        this.trailer.prev = this.header;
        //this.size = 0;
    }

    @Override
    public int size() {
        int size = 0;

        ListNode node = header.next;

        if(node.elem == null)
            return 0;

        do {
            size++;

            node = node.next;
        } while (node != trailer);

        return size;

        //return this.size;
    }


    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    @Override
    public void clear() {
        /* return to empty state */
        this.header.next = this.trailer;
        this.trailer.prev = this.header;
        //this.size = 0;
    }

    @Override
    public void enqueue(E elem) throws QueueFullException {
        this.toString();
        ListNode listNode = nextNodeForElement(elem);

        try {
            ListNode prevNode = listNode.prev;
            ListNode newNode = new ListNode(elem, prevNode, listNode);
            listNode.prev=newNode;
            prevNode.next=newNode;
            //this.size++;
        }
        catch (OutOfMemoryError e) {
            throw new QueueFullException();
        }
    }

    private ListNode nextNodeForElement(E elem) {
        ListNode node = header.next;

        do {
            if(size() == 0)
                return this.trailer;


            if(node.elem.compareTo(elem) < 0)
            {

                return node;
            }

            node  = node.next;
        } while (node != trailer);

        return trailer;
    }

    @Override
    public E dequeue() throws QueueEmptyException {
        if( this.header.next == this.trailer ) throw new QueueEmptyException();

        E front = this.header.next.elem;

        this.header.next = this.header.next.next;
        this.header.next.prev = this.header;

        //this.size--;

        return front;
    }

    @Override
    public E front() throws QueueEmptyException {
        if( this.header.next == this.trailer ) throw new QueueEmptyException();

        return this.header.next.elem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PriorityQueueLinkedList{size=" + this.size() + ", front|[");

        ListNode node = this.header.next;

        while(node != this.trailer) {
            sb.append( node.elem );
            if(node != this.trailer.prev) { //don't place last comma
                sb.append( "," );
            }
            node = node.next;
        }

        sb.append("]|end}");
        return sb.toString();
    }

    private class ListNode {
        E elem;
        ListNode next, prev;

        public ListNode(E elem, ListNode prev, ListNode next) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }

    }
}
