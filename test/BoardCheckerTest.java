import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardCheckerTest {
    @Test
    public void testNotEnoughPlaysToWin() {
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        board.setCharToIndex(3, Players.PLAYER1.identifyChar);
        board.setCharToIndex(1, Players.PLAYER1.identifyChar);
        board.setCharToIndex(4, Players.PLAYER1.identifyChar);
        board.setCharToIndex(6, Players.PLAYER1.identifyChar);

        BoardChecker boardChecker = new BoardChecker();

        assertEquals(CheckStatus.KEEP_PLAYING, boardChecker.check(board));
    }

    @Test
    public void testPlayerWinBySameCharInRow() {
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        board.setCharToIndex(0, Players.PLAYER1.identifyChar);
        board.setCharToIndex(6, Players.PLAYER2.identifyChar);
        board.setCharToIndex(1, Players.PLAYER1.identifyChar);
        board.setCharToIndex(7, Players.PLAYER2.identifyChar);
        board.setCharToIndex(2, Players.PLAYER1.identifyChar);

        BoardChecker boardChecker = new BoardChecker();

        assertEquals(CheckStatus.PLAYER_WIN, boardChecker.check(board));
    }

    @Test
    public void testPlayerWinBySameCharInSameRowIndexes() {
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        board.setCharToIndex(0, Players.PLAYER1.identifyChar);
        board.setCharToIndex(5, Players.PLAYER2.identifyChar);
        board.setCharToIndex(3, Players.PLAYER1.identifyChar);
        board.setCharToIndex(7, Players.PLAYER2.identifyChar);
        board.setCharToIndex(6, Players.PLAYER1.identifyChar);

        BoardChecker boardChecker = new BoardChecker();

        assertEquals(CheckStatus.PLAYER_WIN, boardChecker.check(board));
    }

    @Test
    public void testGameDrawBecauseBoardDoesNotHaveMoreAvailableIndexes() {
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        board.setCharToIndex(0, Players.PLAYER1.identifyChar);
        board.setCharToIndex(1, Players.PLAYER2.identifyChar);
        board.setCharToIndex(2, Players.PLAYER1.identifyChar);
        board.setCharToIndex(6, Players.PLAYER2.identifyChar);
        board.setCharToIndex(4, Players.PLAYER1.identifyChar);
        board.setCharToIndex(5, Players.PLAYER2.identifyChar);
        board.setCharToIndex(3, Players.PLAYER1.identifyChar);
        board.setCharToIndex(8, Players.PLAYER2.identifyChar);
        board.setCharToIndex(7, Players.PLAYER1.identifyChar);

        BoardChecker boardChecker = new BoardChecker();

        assertEquals(CheckStatus.GAME_DRAW, boardChecker.check(board));
    }

    @Test
    public void testGameDrawBecauseBoardDoesNotHaveEnoughAvailableIndexes() {
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        board.setCharToIndex(0, Players.PLAYER1.identifyChar);
        board.setCharToIndex(1, Players.PLAYER2.identifyChar);
        board.setCharToIndex(2, Players.PLAYER1.identifyChar);
        board.setCharToIndex(3, Players.PLAYER2.identifyChar);
        board.setCharToIndex(4, Players.PLAYER1.identifyChar);
        board.setCharToIndex(5, Players.PLAYER2.identifyChar);
        board.setCharToIndex(7, Players.PLAYER1.identifyChar);

        BoardChecker boardChecker = new BoardChecker();

        assertEquals(CheckStatus.GAME_DRAW, boardChecker.check(board));
    }
}