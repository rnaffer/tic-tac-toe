public class Main {

    public static void main(String[] args) {
        ConsoleBoardPresenter consoleBoardPresenter = new ConsoleBoardPresenter();
        TicTacToeGame ticTacToeGame = new TicTacToeGame(3, consoleBoardPresenter);

        ticTacToeGame.initGame();
    }
}
