package game;

public class ElectricMove extends Move {
    public ElectricMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Electric";
    }
}