package game;

public class FightingMove extends Move {
    public FightingMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Fighting";
    }
}
