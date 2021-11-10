package pt.pa;

import pt.pa.adts.Queue;
import pt.pa.adts.QueueLinkedList;

/**
 *  Nuno Reis
 *  nº 202000753
 */

public class Main {

    public static void main(String[] args) {

        Queue<Integer> queue = new QueueLinkedList<>();

        try {
            for (int i=0; i<100; i++) {
                queue.enqueue(i+1);
                System.out.println(queue.front());
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(queue.dequeue());
        }

        try {
            System.out.println("Queue is empty? " + queue.isEmpty());

            System.out.println("Top of queue is: " + queue.front());

            System.out.println("Pop all elements from queue:");
            while(!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }

            System.out.println("Queue is empty? " + queue.isEmpty());

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---------------");

        try {
            for (int i=0; i<100; i++) {
                queue.enqueue(i+1);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Queue is empty? " + queue.isEmpty());

            System.out.println("Top of queue is: " + queue.front());

            queue.clear();

            System.out.println("Queue is empty? " + queue.isEmpty());

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
