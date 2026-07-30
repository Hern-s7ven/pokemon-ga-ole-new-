package game;

public class NormalMove extends Move {
    public NormalMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Normal";
    }
}
