public enum Players {
    PLAYER1("X", "Player 1"),
    PLAYER2("O", "Player 2");

    public final String identifyChar;
    public final String name;

    Players(String identifyChar, String name) {
        this.identifyChar = identifyChar;
        this.name = name;
    }
}
