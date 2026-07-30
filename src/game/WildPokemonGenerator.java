package game;
import java.util.*;

public class WildPokemonGenerator extends pokemonDatabase{
	String chosenRarity = "★";
	public List<Pokemon> generateWildPokemon() {
		
		if (PokemonList.isEmpty()) {
	        loadWildPokemon();
	    }
		
		List<Pokemon> wildPokemons = new ArrayList<>();
		Random rand = new Random();
    
		while (wildPokemons.size() < 3) {
		    Collections.shuffle(PokemonList);
		    int roll = rand.nextInt(100) + 1;

        	if (roll < 45) {
        		chosenRarity = "★";
        	} else if (roll <= 75) {
        		chosenRarity = "★★";
        	} else if (roll <= 95) {
        		chosenRarity = "★★★";
        	} else if (roll <= 100) {
        		chosenRarity = "★★★★";
        	}
        	
        	for (Pokemon p : PokemonList) {
    			if (p.getRarity().equals(chosenRarity)) {
    				Pokemon chosen = new Pokemon(p); 

    				chosen.setBaseHP(rand.nextInt(100) + 501);
    				chosen.setBaseATK(rand.nextInt(100) + 101);
    				chosen.setLevel(rand.nextInt(40) + 61);
    				chosen.setMaxHP(chosen.calculateMaxHP());
    				chosen.setCurrentHP(chosen.getMaxHP());

    				wildPokemons.add(chosen);
    				break;
    			}
    		}
        }
        return wildPokemons;
    }
}