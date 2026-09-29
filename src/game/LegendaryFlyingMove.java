package game;

public class LegendaryFlyingMove extends Move {
    public LegendaryFlyingMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Flying";
    }
}
