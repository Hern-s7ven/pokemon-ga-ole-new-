package game;

public class FlyingMove extends Move {
    public FlyingMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Flying";
    }
}
