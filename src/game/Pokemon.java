package game; 

public class Pokemon {
    private String name;
    private String baseName;
    private String type;
    private int baseHP;
    private int baseATK;
    private int level;
    private String rarity;
    private Move move;
    private int evolutionLevel;
    private int evolutionCounter;
    private int currentHP;
    private int nRarity;
    private int maxHP;
    Utilities util = new Utilities();

    public Pokemon(String name, String baseName, String type, String rarity, int nRarity) {
        this.name = name;
        this.baseName = baseName;
        this.type = type;
        this.rarity = rarity;
        this.nRarity = nRarity;
        
        this.move = MoveFactory.createMove(type);

    }
    
    public Pokemon(Pokemon listed) {
    	this.name = listed.name;
    	this.baseName = listed.baseName;
    	this.type = listed.type;
    	this.rarity = listed.rarity;
    	this.move = listed.move;
    	this.evolutionLevel = listed.evolutionLevel;
    	this.evolutionCounter = listed.evolutionCounter;
    	this.baseHP = listed.baseHP;
        this.baseATK = listed.baseATK;
        this.level = listed.level;
        this.nRarity = listed.nRarity;
        this.maxHP = listed.maxHP;
        this.currentHP = listed.currentHP;
    }
    

    public int calculateMaxHP() {
        return baseHP + (level * 2) + (evolutionLevel * 12) + (nRarity * 30 - 25);
    }

    public void attack(Pokemon target, boolean isPlayerPokemon) {
        String attackerColor = isPlayerPokemon ? Utilities.BRIGHT_BLUE : Utilities.BRIGHT_RED;
        String targetColor = isPlayerPokemon ? Utilities.BRIGHT_RED : Utilities.BRIGHT_BLUE;
        String hpBarColor = targetColor;

        System.out.println(attackerColor + this.name + Utilities.RESET +
                           " uses " + this.move.getName() + "!");

        double multiplier = TypeChart.getEffectiveness(this.getType(), target.getType());
        int finalDamage = (int) (this.baseATK * multiplier);

        System.out.println(targetColor + target.getName() + Utilities.RESET +
                           " takes " + finalDamage + " damage!");

        if (multiplier != 1.0) {
            String effectText = TypeChart.effectivenessText(multiplier);
            System.out.println("➡ It’s " + effectText + "!");
        }

        target.takeDamage(finalDamage, hpBarColor);
        
        System.out.println();
    }

    public int calculateAttack() {
        return baseATK + (level / 2) + (evolutionLevel * 6 - 6) + (nRarity * 5 - 5);
    }

    public void takeDamage(int damage, String barColor) {
        currentHP -= damage;
        if (currentHP < 0) currentHP = 0;

        int barLength = 20;
        int filledBars = (int) (((double) currentHP / maxHP) * barLength);
        int emptyBars = barLength - filledBars;

        StringBuilder bar = new StringBuilder();
        bar.append("[");
        for (int i = 0; i < filledBars; i++) bar.append("█");
        for (int i = 0; i < emptyBars; i++) bar.append("░");
        bar.append("]");

        System.out.println("HP: " + barColor + bar + Utilities.RESET +
                           " " + currentHP + "/" + maxHP);
    }
    
    public boolean isDefeated() {
        return currentHP <= 0;
    }
    
    public boolean checkEvolution() {
        return this.getEvolutionLevel() < 3 && this.getEvolutionCounter() <= 0 && EvolutionDatabase.hasEvolution(this.getBaseName(), this.getEvolutionLevel() + 1);
    }
    
    public void evolve() {
    	System.out.println("\n=======================================");
    	System.out.println(" ⚡ Something strange is happening! ⚡");
    	System.out.println(" " + this.getName() + " is surrounded by a glowing light!");
    	System.out.println("=======================================");
    	util.waitForEnter();
    	
    	Evolution evo = EvolutionDatabase.getEvolution(this.getBaseName(), this.getEvolutionLevel() + 1);
    	
    	System.out.println("\n🎉 " + this.getName() + " evolved into " + evo.getName() + "!");
    	System.out.println("🔥 Its power has increased significantly! 🔥");
    	
    	this.name = evo.getName();
		this.baseATK += evo.getIncreaseATK();
		this.baseHP += evo.getIncreaseHP();
		this.level += 10;
		this.nRarity++;
		this.rarity = "★".repeat(this.nRarity);
		this.evolutionCounter = 10;
		this.evolutionLevel++;
		
		System.out.println("\nNAME: " + this.getName() + " | Type: " + this.getType() + " | Rarity: " + this.getRarity() + 
				" | ATK: "+ this.calculateAttack() + " | HP:  " + this.calculateMaxHP() + " | LVL " + this.getLevel() + "\n");
    }
    
    @Override
    public String toString() {
        return name + " | Type: " + type + " | Rarity: " + rarity + " | LVL " + level;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBaseHP() {
		return baseHP;
	}

	public void setBaseHP(int baseHP) {
		this.baseHP = baseHP;
	}

	public int getBaseATK() {
		return baseATK;
	}

	public void setBaseATK(int baseATK) {
		this.baseATK = baseATK;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public int getEvolutionLevel() {
		return evolutionLevel;
	}

	public void setEvolutionLevel(int evolutionLevel) {
		this.evolutionLevel = evolutionLevel;
	}

	public int getEvolutionCounter() {
		return evolutionCounter;
	}

	public void setEvolutionCounter(int evolutionCounter) {
		this.evolutionCounter = evolutionCounter;
	}

	public int getnRarity() {
		return nRarity;
	}

	public void setnRarity(int nRarity) {
		this.nRarity = nRarity;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	
	public int getCurrentHP() {
		return currentHP;
	}
    
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
}
