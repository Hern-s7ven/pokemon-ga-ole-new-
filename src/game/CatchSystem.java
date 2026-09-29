package game;
import game.items.*;

public class CatchSystem {
	
	private Player player;
	
    public boolean attemptCatch(Pokemon pokemon, Ball ball, Berry berry) {
        double catchProbability = calculateCatchProbability(pokemon, ball, berry) / 100;
        return Math.random() < catchProbability;
    }
    
    public CatchSystem(Player player) {
    	this.player = player;
    }

    public double calculateCatchProbability(Pokemon pokemon, Ball ball, Berry berry) {
        
        double baseRate = ball.getEffectiveness();
        double levelPenalty = (pokemon.getLevel() - 60) * 0.5;
        double rarityPenalty = pokemon.getnRarity() * 3;
        double berryBonus = (berry != null) ? berry.getEffectiveness() : 0;
        
        double probability = baseRate - levelPenalty - rarityPenalty + berryBonus;
        
        if (probability > 100) {
        	probability = 100;
        } else if (probability < 0) {
        		probability = 0;
        	} 
        return probability;
    }
    
    public void caught(Pokemon pokemon, Ball ball, Berry berry) {
    	if(attemptCatch(pokemon, ball, berry)) {
    		System.out.println("The wild " + pokemon.getName() + " has been captured!");
    		player.loadTeam();
    		player.addPokemon(pokemon);
    		player.saveTeam();
    	} else {
    		System.out.println("\n" + pokemon.getName() + " has broken free!\n");
    		System.out.println("The wild " + pokemon.getName() + " has fled!");
    	}
    }
}