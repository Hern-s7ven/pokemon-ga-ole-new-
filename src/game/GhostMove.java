package game;

public class GhostMove extends Move {
    public GhostMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Ghost";
    }
}
