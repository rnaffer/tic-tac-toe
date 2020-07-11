public class ConsoleBoardPresenter implements BoardPresenter {
    public void displayBoard(Board board) {
        String formattedBoard = "";

        for (int i = 0; i < board.size; i++) {
            formattedBoard += String.join("|", board.rows.get(i).get());
            formattedBoard += "\n";
        }

//        this.clearConsole();
        System.out.print(formattedBoard);
    }

    public void displayWelcome() {
        System.out.println("Tic Tac Toe Game");
        System.out.println("Write -1 to exit");
    }

    public void displayPlayerTurn(Players player) {
        System.out.println("\nTurn: " + player.name);
        System.out.print("Select an available index: ");
    }

    public void displayInvalidIndex() {
        System.out.println("Invalid index.");
    }

    public void displayGameWinner(Players player) {
        System.out.println(player.name + " (" + player.identifyChar + ") Wins!");
    }

    public void displayGameDraw() {
        System.out.println("Game is Draw.\n");
    }

//    private void clearConsole() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }
}
