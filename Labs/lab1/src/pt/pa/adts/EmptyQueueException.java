package pt.pa.adts;

/**
 *  Nuno Reis
 *  nº 202000753
 */

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("The queue is empty.");
    }
}
