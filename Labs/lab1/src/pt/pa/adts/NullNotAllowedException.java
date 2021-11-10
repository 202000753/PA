package pt.pa.adts;

/**
 *  Nuno Reis
 *  nº 202000753
 */

public class NullNotAllowedException extends RuntimeException {
    public NullNotAllowedException() {
        super("Null not allowed.");
    }
}
