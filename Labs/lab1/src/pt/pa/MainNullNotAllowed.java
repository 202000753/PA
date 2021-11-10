package pt.pa;

/**
 *  Nuno Reis
 *  nº 202000753
 */

import pt.pa.adts.Queue;
import pt.pa.adts.QueueLinkedList;

public class MainNullNotAllowed {

    public static void main(String[] args) {

        Queue<Integer> queue = new QueueLinkedList<>();

        try {
            for (int i=0; i<100; i++) {
                queue.enqueue(i+1);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        queue.enqueue(null);
    }
}
