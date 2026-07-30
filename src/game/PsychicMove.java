package game;

public class PsychicMove extends Move {
    public PsychicMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Psychic";
    }
}
