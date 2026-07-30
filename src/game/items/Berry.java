package game.items;

import java.util.ArrayList;

public class Berry extends BaseItem {
    private final double catchBonus;
    public static ArrayList<Berry> berries = new ArrayList<>();
    
    public Berry(String name, int cost, double catchBonus) {
        super(name, cost);
        this.catchBonus = catchBonus;
    }
    
    public static void loadBerry() {
	    berries.add(new Berry("Razz Berry", 100, 10));
	    berries.add(new Berry("Golden Razz Berry", 200, 15));
	    berries.add(new Berry("Soothing Berry", 400, 25));
	    berries.add(new Berry("I dont want to purchase a berry!", 0, 0));
    }
    
    public double getEffectiveness() {
        return catchBonus;
    }

	public static ArrayList<Berry> getBerries() {
		return berries;
	}

	public static void setBerries(ArrayList<Berry> berries) {
		Berry.berries = berries;
	}
}