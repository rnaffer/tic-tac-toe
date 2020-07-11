import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void testBoardHasASize() {
        BoardShaper boardShaper = new BoardShaper(3);
        Board board = new Board(3, boardShaper.boardInitialValues());

        assertEquals(3, board.size);
    }

    @Test
    public void testBoardHasRowsCount() {
        int boardSize = 4;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        assertEquals(boardSize, board.rows.size());
    }

    @Test
    public void testBoardSpotCountIsSquareOfSide() {
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        int boardSpotsCount = 0;

        for (int i = 0; i < board.rows.size(); i++) {
            boardSpotsCount += board.rows.get(i).size();
        }

        assertEquals(9, boardSpotsCount);
    }

    @Test
    public void testCharIsInIndexAfterSet() {
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        board.setCharToIndex(2, Players.PLAYER1.identifyChar);

        assertEquals(board.rows.get(0).getIndexValue(2), Players.PLAYER1.identifyChar);
    }

    @Test
    public void testAvailableIndexesAfterPlays() {
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        board.setCharToIndex(0, Players.PLAYER1.identifyChar);
        board.setCharToIndex(2, Players.PLAYER2.identifyChar);
        board.setCharToIndex(3, Players.PLAYER1.identifyChar);
        board.setCharToIndex(1, Players.PLAYER2.identifyChar);
        board.setCharToIndex(4, Players.PLAYER1.identifyChar);
        board.setCharToIndex(6, Players.PLAYER2.identifyChar);

        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(5);
        indexes.add(7);
        indexes.add(8);

        assertEquals(board.availableIndexes(), indexes);
    }

    @Test
    public void testIndexIsAlreadyUsedWhenAttemptSet() {
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        board.setCharToIndex(2, Players.PLAYER1.identifyChar);

        assertThrows(IllegalArgumentException.class, () ->
                board.setCharToIndex(2, Players.PLAYER1.identifyChar));
    }

    @Test
    public void testIndexOutOfRangeWhenAttemptSet() {
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        assertThrows(IllegalArgumentException.class, () ->
                board.setCharToIndex(16, Players.PLAYER1.identifyChar));
    }

//    @Test
//    public void testPrintsBoardToFile() {
//        Board board = new Board();
//
//        try {
//            File boardFile = new File("gameBoard.txt");
//            Scanner scanner = new Scanner(boardFile);
//
//            String content = scanner.useDelimiter("\\A").next();
//            scanner.close();
//
//            assertEquals(board.toString(), content.substring(0, content.length() - 2));
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Error while reading file");
//        }
//    }
}