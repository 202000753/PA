package pt.pa.refactoring.pieces;

import pt.pa.refactoring.board.Board;
import pt.pa.refactoring.board.Spot;

/**
 * @author amfs
 */
public abstract class Piece {

    private boolean killed = false;

    private boolean white = false;

    public Piece(boolean white) {
        this.setWhite(white);
    }

    public abstract int getValue();

    public abstract String getSymbol();

    // No need to validate the move rules for now or after refactor
    public abstract boolean canMove(Board board, Spot start, Spot end);

    public boolean isWhite()
    {
        return this.white;
    }

    public void setWhite(boolean white)
    {
        this.white = white;
    }

    public boolean isKilled()
    {
        return this.killed;
    }

    public void setKilled(boolean killed)
    {
        this.killed = killed;
    }
}
