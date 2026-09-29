
package game;

public class WaterMove extends Move {
    public WaterMove(String name, int power) {
        super(name, power);
    }

    @Override
    public String getType() {
        return "Water";
    }
}
