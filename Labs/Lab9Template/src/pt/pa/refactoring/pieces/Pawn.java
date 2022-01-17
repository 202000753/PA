package pt.pa.refactoring.pieces;

import pt.pa.refactoring.board.Board;
import pt.pa.refactoring.board.Spot;

public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public int getValue() {
        return 1;
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "P" : "p";
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return true;
    }
}
