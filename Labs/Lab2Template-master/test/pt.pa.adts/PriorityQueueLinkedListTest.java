package pt.pa.adts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueLinkedListTest {
    private PriorityQueueLinkedList<Integer> q;

    @BeforeEach
    void setUp() {
        q= new PriorityQueueLinkedList<>();
    }

    @Test
    @DisplayName("Test is empty")
    void testIsEmpty(){
        q.enqueue(1);
        q.enqueue(3);
        q.clear();
        assertTrue(q.isEmpty(),"the queue should be empty after clear");
    }

    @Test
    @DisplayName("Test size")
    void testSize(){
        q.enqueue(3);
        q.enqueue(1);
        assertEquals(q.size(), 2,"the size should be 2");

        q.clear();
        assertEquals(q.size(), 0,"the size should be 0");
    }

    @Test
    @DisplayName("Test FIFO")
    void testFIFO(){
        q.enqueue(3);
        q.enqueue(1);
        assertEquals(q.front(), 3,"the element should be 3");
        assertEquals(q.dequeue(), 3,"the element should be 3");
        assertEquals(q.dequeue(), 1,"the element should be 1");
    }

    @Test
    @DisplayName("Test QueueEmptyException in Dequeue")
    void testDequeueQueueEmptyException(){
        assertThrows(QueueEmptyException.class, () ->{
           q.dequeue();
        });
    }

    @Test
    @DisplayName("Test QueueEmptyException in Front")
    void testFrontQueueEmptyException(){
        assertEquals(q.dequeue(), 3,"the element should be 3");
    }
}