package game;

public class BugMove extends Move {
    public BugMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Bug";
    }
}
