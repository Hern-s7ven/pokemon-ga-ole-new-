package game;

public class LegendaryNormalMove extends Move {
    public LegendaryNormalMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Normal";
    }
}
