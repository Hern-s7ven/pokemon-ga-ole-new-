package game;

public class Evolution {
	
	private String name;
	private int increaseATK;
	private int increaseHP;
	private String rarity;
	private int nRarity;
	Pokemon evolved;
	
	public Evolution (String name, String baseName, int increaseATK, int increaseHP, String rarity, int nRarity) {
		this.name = name;
		this.increaseATK = increaseATK;
		this.increaseHP = increaseHP;
		this.rarity = rarity;
		this.nRarity = nRarity;
	}
	
	public String getName() {
		return name;
	}
    public int getIncreaseATK() {
    	return increaseATK;
    }
    public int getIncreaseHP() {
    	return increaseHP;
    	}
    public String getRarity() {
    	return rarity;
    	}
    public int getnRarity() {
    	return nRarity;
    	}
}
