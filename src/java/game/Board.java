package game;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Board {

    private Player player1;
    private Player player2;
    private short whenToWin;
    Scanner scanner = new Scanner(System.in);
    Judge judge = new Judge();

    public Board (short whenToWin, Player player1, Player player2) {
        this.whenToWin = whenToWin;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        while (player1.getPoints() < whenToWin && player2.getPoints() < whenToWin) {
            System.out.println("Punktacja:\n" +
                    player1.getName() + " ilość punktów: " + player1.getPoints() + "\n" +
                    player2.getName() + " ilość punktów: " + player2.getPoints()
            );
            makeChoice(player1);
            makeChoice(player2);
            System.out.println("\nUżytkownik " + player1.getName() + " wybrał " + player1.getChoice() + ", a " +
                    player2.getName() + " " + player2.getChoice() + ".");
            String winner = judge.whoWin(player1, player2);
            if (winner == null) {
                System.out.println("Remis! Graj dalej!");
            } else if (winner.equals(player1.getName())) {
                player1.addPoint();
                System.out.println("Wygrywa " + player1.getName() + "!");
            } else if (winner.equals(player2.getName())) {
                player2.addPoint();
                System.out.println("Wygrywa " + player2.getName() + "!");
            }
            player1.setChoice(null);
            player2.setChoice(null);
        }
    }

    private void makeChoice(Player player) {

        while (player.getChoice() == null) {
            if (player.isHuman()) {
                System.out.println("Jaki jest twój wybór? Wpisz:\n" +
                        "K, aby wybrać kamień,\n" +
                        "P, aby wybrać papier,\n" +
                        "N, aby wybrać nożyce.");
                String tmp = scanner.nextLine().toUpperCase();
                if (tmp.equals("K")) {
                    player.setChoice(Choices.ROCK);
                } else if (tmp.equals("P")) {
                    player.setChoice(Choices.PAPER);
                } else if (tmp.equals("N")) {
                    player.setChoice(Choices.SCISSORS);
                } else {
                    System.out.print("Niepoprawny wybór! ");
                }
            } else {
                int random = new Random().nextInt(3);
                if (random == 0) {
                    player.setChoice(Choices.ROCK);
                } else if (random == 1) {
                    player.setChoice(Choices.PAPER);
                } else if (random == 2) {
                    player.setChoice(Choices.SCISSORS);
                }
            }
        }
    }
}
