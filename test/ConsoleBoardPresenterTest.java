import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ConsoleBoardPresenterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testBoardPresenterPrintsBoardToConsole() {
        int boardSize = 3;
        BoardShaper boardShaper = new BoardShaper(boardSize);
        Board board = new Board(boardSize, boardShaper.boardInitialValues());

        ConsoleBoardPresenter presenter = new ConsoleBoardPresenter();
        System.setOut(new PrintStream(outContent));
        presenter.displayBoard(board);

        assertEquals("0|1|2\n3|4|5\n6|7|8\n", outContent.toString());
    }
}