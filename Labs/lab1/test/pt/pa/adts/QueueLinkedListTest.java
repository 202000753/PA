package pt.pa.adts;

/**
 *  Nuno Reis
 *  nº 202000753
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class QueueLinkedListTest {

    @Test
    void enqueue() {
        Queue<Integer> queue = new QueueLinkedList<>();

        for (int i=0; i<100; i++) {
            queue.enqueue(i+1);

            assertEquals(i+1, queue.front());
        }
    }

    @org.junit.jupiter.api.Test
    void dequeue() {
        Queue<Integer> queue = new QueueLinkedList<>();

        for (int i=0; i<100; i++) {
            queue.enqueue(i+1);

            assertEquals(i+1, queue.dequeue());
        }
    }

    @org.junit.jupiter.api.Test
    void front() {
        Queue<Integer> queue = new QueueLinkedList<>();

        for (int i=0; i<100; i++) {
            queue.enqueue(i+1);

            assertEquals(i+1, queue.front());
        }
    }

    @org.junit.jupiter.api.Test
    void size() {
        Queue<Integer> queue = new QueueLinkedList<>();

        int size = 0;

        for (int i=0; i<100; i++) {
            queue.enqueue(i+1);
            size++;

            assertEquals(size, queue.size());
        }

        while(!queue.isEmpty()) {
            queue.dequeue();
            size--;

            assertEquals(size, queue.size());
        }
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Queue<Integer> queue = new QueueLinkedList<>();

        assertTrue(queue.isEmpty());

        for (int i=0; i<100; i++) {
            queue.enqueue(i+1);
        }

        assertFalse(queue.isEmpty());

        while(!queue.isEmpty()) {
            queue.dequeue();
        }

        assertTrue(queue.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        Queue<Integer> queue = new QueueLinkedList<>();

        int size = 0;

        for (int i=0; i<100; i++) {
            queue.enqueue(i+1);
            size++;

            assertEquals(size, queue.size());
        }

        assertFalse(queue.isEmpty());

        queue.clear();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }
}