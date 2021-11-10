package pt.pa.adts;

/**
 *  Nuno Reis
 *  nº 202000753
 */

public class FullQueueException extends RuntimeException {
    public FullQueueException() {
        super("The queue is full.");
    }
}
