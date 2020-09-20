package game;

public class Judge {

    public String whoWin(Player player1, Player player2) {

        if (player1.getChoice() == player2.getChoice()) {
            return null;
        } else {
            if (player1.getChoice() == Choices.ROCK) {
                if (player2.getChoice() == Choices.PAPER) {
                    return player2.getName();
                } else {
                    return player1.getName();
                }
            } else if (player1.getChoice() == Choices.PAPER) {
                if (player2.getChoice() == Choices.ROCK) {
                    return player1.getName();
                } else {
                    return player2.getName();
                }
            } else {
                if (player2.getChoice() == Choices.ROCK) {
                    return player2.getName();
                } else {
                    return player1.getName();
                }
            }
        }
    }
}
