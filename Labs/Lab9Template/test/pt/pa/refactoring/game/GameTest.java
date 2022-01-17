package pt.pa.refactoring.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pt.pa.refactoring.player.ComputerPlayer;
import pt.pa.refactoring.player.HumanPlayer;
import pt.pa.refactoring.player.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {
    private Game game;
    private Player p1;
    private Player p2;

    @BeforeEach
    void setUp() {
        p1 = new HumanPlayer(true);
        p2 = new ComputerPlayer(false);
        game = new Game(p1, p2);
    }

    @Test
    @DisplayName("Move Piece")
    void movePiece() throws Exception {
        assertTrue(game.movePiece(p2, 6, 0, 4, 0));

        assertTrue(game.movePiece(p1, 1, 0, 3, 0));
    }
}