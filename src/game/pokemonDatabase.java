package game;
import java.util.*;

public class pokemonDatabase{
	
public static ArrayList<Pokemon> PokemonList = new ArrayList<>();
	
	public void loadWildPokemon() {
	    
		//1 Star
		PokemonList.add(new Pokemon("Charmander", "Charmander", "Fire", "★", 1));
		PokemonList.add(new Pokemon("Squirtle", "Squirtle", "Water", "★", 1));
		PokemonList.add(new Pokemon("Bulbasaur", "Bulbasaur","Grass", "★",1 ));
		PokemonList.add(new Pokemon("Pidgey", "Pidgey", "Flying", "★", 1));
		PokemonList.add(new Pokemon("Caterpie", "Caterpie", "Bug", "★", 1));
		PokemonList.add(new Pokemon("Weedle", "Weedle", "Bug", "★", 1));
		
		//2star
		PokemonList.add(new Pokemon("Machop", "Machop", "Fighting", "★★", 2));
		PokemonList.add(new Pokemon("Abra", "Abra", "Psychic", "★★", 2));
		PokemonList.add(new Pokemon("Gastly", "Gastly", "Ghost", "★★", 2));
		PokemonList.add(new Pokemon("Rhyhorn", "Rhyhorn", "Rock", "★★", 2));
		PokemonList.add(new Pokemon("Poliwag", "Poliwag", "Water", "★★", 2));
		PokemonList.add(new Pokemon("Geodude", "Geodude", "Rock", "★★", 2));
		
		//3 star
		PokemonList.add(new Pokemon("Scyther", "Scyther", "Bug", "★★★", 3));
		PokemonList.add(new Pokemon("Pinsir", "Pinsir", "Bug", "★★★", 3));
		PokemonList.add(new Pokemon("Tauros", "Tauros", "Normal", "★★★", 3));
		PokemonList.add(new Pokemon("Electabuzz", "Electabuzz", "Electric", "★★★", 3));
		PokemonList.add(new Pokemon("Magmar", "Magmar", "Fire", "★★★", 3));
		
		//4 star
		PokemonList.add(new Pokemon("Mewtwo", "Mewtwo", "Psychic", "★★★★★", 5));
		PokemonList.add(new Pokemon("Rayquaza", "Rayquaza", "Flying", "★★★★★", 5));
		PokemonList.add(new Pokemon("Arceus", "Arceus", "Normal", "★★★★★", 5));
	}

}