package game;

public class LegendaryPsychicMove extends Move {
    public LegendaryPsychicMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Psychic";
    }
}
