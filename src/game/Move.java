package game;

public abstract class Move {
    protected String name;
    protected String type;
    protected int power;

    public Move(String name, int power) {
        this.name = name;
        this.power = power;
        this.type = getType(); 
    }

    public abstract String getType(); 

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }
}
