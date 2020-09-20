import game.Board;
import game.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj swoje imię: ");
        String name = scan.nextLine();
        System.out.print("Do ilu punktów ma się toczyć gra? ");
        short whenToWin = scan.nextShort();
        System.out.println("OK! Zaczynamy!\n");
        Board board = new Board(whenToWin, new Player(name, true), new Player("Computer", false
        ));
        board.play();
    }
}
