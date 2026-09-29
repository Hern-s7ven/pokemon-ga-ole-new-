
package game;

public class FireMove extends Move {
    public FireMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Fire";
    }
}
