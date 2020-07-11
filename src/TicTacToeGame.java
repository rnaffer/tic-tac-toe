import java.util.Scanner;

public class TicTacToeGame {
    Board board;
    BoardPresenter presenter;
    BoardChecker boardChecker;
    Players currentPlayer;

    public TicTacToeGame(int size, BoardPresenter presenter) {
        BoardShaper boardShaper = new BoardShaper(size);
        this.board = new Board(size, boardShaper.boardInitialValues());

        this.presenter = presenter;
        this.currentPlayer = Players.PLAYER1;
        this.boardChecker = new BoardChecker();
    }

    public void initGame() {
        this.presenter.displayWelcome();

        this.gameLoop();
    }

    private void gameLoop() {
        Scanner in = new Scanner(System.in);
        int currentPlayerIndexValue;

        do {
            this.presenter.displayBoard(this.board);
            this.presenter.displayPlayerTurn(this.currentPlayer);

            currentPlayerIndexValue = in.nextInt();

            if (currentPlayerIndexValue == -1) continue;

            try {
                this.board.setCharToIndex(currentPlayerIndexValue, this.currentPlayer.identifyChar);
            } catch (IllegalArgumentException e) {
                this.presenter.displayInvalidIndex();

                continue;
            }

            CheckStatus checkStatus = boardChecker.check(this.board);

            if (checkStatus != CheckStatus.KEEP_PLAYING) {
                this.finishGame(checkStatus);
                break;
            }

            this.changePlayer();
        } while (currentPlayerIndexValue != -1);
    }

    private void changePlayer() {
        this.currentPlayer = this.currentPlayer == Players.PLAYER1 ? Players.PLAYER2 : Players.PLAYER1;
    }

    private void finishGame(CheckStatus checkStatus) {
        presenter.displayBoard(this.board);

        if (checkStatus == CheckStatus.GAME_DRAW) {
            this.presenter.displayGameDraw();
            return;
        }

        this.presenter.displayGameWinner(this.currentPlayer);
    }
}
