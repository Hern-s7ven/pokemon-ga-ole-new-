package game.items;

public class BaseItem {
    private final String name;
    private final int cost;
    
    public BaseItem(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
    	return name;
    	}

    public int getCost() {
    	return cost;
    	}
}