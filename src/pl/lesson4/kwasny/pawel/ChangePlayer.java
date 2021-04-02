package pl.lesson4.kwasny.pawel;

public class ChangePlayer {
    private static Player firstPlayer = new Player(Sign.CROSS);
    private static Player secondPlayer = new Player(Sign.CIRCLE);
    public static Player currentPlayer = firstPlayer;

    public static void changePlayer() {
        if (currentPlayer == firstPlayer) {
            currentPlayer = secondPlayer;
        } else {
            currentPlayer = firstPlayer;
        }

    }
}
