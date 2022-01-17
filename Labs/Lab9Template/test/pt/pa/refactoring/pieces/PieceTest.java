package pt.pa.refactoring.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    private Rook rook;
    private Bishop bishop;
    private Pawn pawn;

    @BeforeEach
    void setUp() {
        rook = new Rook(true);
        bishop = new Bishop(false);
        pawn = new Pawn(true);
    }

    @Test
    @DisplayName("Get Value")
    void getValue() {
        Piece piece = rook;
        assertEquals(5, piece.getValue());
        piece = bishop;
        assertEquals(3, piece.getValue());
        piece = pawn;
        assertEquals(1, piece.getValue());
    }
}