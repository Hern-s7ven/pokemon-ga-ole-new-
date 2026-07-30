package game;

public class GrassMove extends Move {
    public GrassMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Grass";
    }
}
