public interface BoardPresenter {
    public void displayBoard(Board board);
    public void displayPlayerTurn(Players player);
    public void displayWelcome();
    public void displayInvalidIndex();
    public void displayGameWinner(Players player);
    public void displayGameDraw();
}
