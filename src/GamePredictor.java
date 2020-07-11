public class GamePredictor {

    public Board predictBoardInNextPlay(Board board, int selectedIndex, Players player) {
        board.setCharToIndex(selectedIndex, player.identifyChar);

        return board;
    }
}
