package game;

public class RockMove extends Move {
    public RockMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Rock";
    }
}
