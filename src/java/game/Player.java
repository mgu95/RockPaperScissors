package game;

public class Player {

    private String name;
    private boolean human;
    private short points = 0;
    private Choices choice;

    public Player(String name, boolean human) {
        this.name = name;
        this.human = human;
    }

    public String getName() {
        return name;
    }

    public void addPoint() {
        points++;
    }

    public short getPoints() {
        return points;
    }

    public Choices getChoice() {
        return choice;
    }

    public void setChoice(Choices choice) {
        this.choice = choice;
    }

    public boolean isHuman() {
        return human;
    }
}
