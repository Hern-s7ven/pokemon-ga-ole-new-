package game;
import java.util.*;

public class EvolutionDatabase {

	private static final Map<String, List<Evolution>> evolutions = new HashMap<>();

    static {

        evolutions.put("Charmander", Arrays.asList(
            new Evolution("Charmeleon", "Charmander", 30, 30, "★★", 2),
            new Evolution("Charizard", "Charmander", 50, 60, "★★★", 3)
        ));

        evolutions.put("Squirtle", Arrays.asList(
            new Evolution("Wartortle", "Squirtle", 25, 40, "★★", 2),
            new Evolution("Blastoise", "Squirtle", 45, 60, "★★★", 3)
        ));

        evolutions.put("Bulbasaur", Arrays.asList(
            new Evolution("Ivysaur", "Bulbasaur", 25, 35, "★★", 2),
            new Evolution("Venusaur", "Bulbasaur", 50, 60, "★★★", 3)
        ));

        evolutions.put("Pidgey", Arrays.asList(
            new Evolution("Pidgeotto", "Pidgey", 20, 30, "★★", 2),
            new Evolution("Pidgeot", "Pidgey", 40, 50, "★★★", 3)
        ));

        evolutions.put("Caterpie", Arrays.asList(
            new Evolution("Metapod", "Caterpie", 5, 20, "★★", 2),
            new Evolution("Butterfree", "Caterpie", 30, 40, "★★★", 3)
        ));

        evolutions.put("Weedle", Arrays.asList(
            new Evolution("Kakuna", "Weedle", 5, 20, "★★", 2),
            new Evolution("Beedrill", "Weedle", 35, 50, "★★★", 3)
        ));


        evolutions.put("Machop", Arrays.asList(
            new Evolution("Machoke", "Machop", 40, 50, "★★★", 3),
            new Evolution("Machamp", "Machop", 50, 60, "★★★★", 4)
        ));

        evolutions.put("Abra", Arrays.asList(
            new Evolution("Kadabra", "Abra", 35, 20, "★★★", 3),
            new Evolution("Alakazam", "Abra", 55, 30, "★★★★", 4)
        ));

        evolutions.put("Gastly", Arrays.asList(
            new Evolution("Haunter", "Gastly", 30, 20, "★★★", 3),
            new Evolution("Gengar", "Gastly", 50, 40, "★★★★", 4)
        ));

        evolutions.put("Rhyhorn", Arrays.asList(
            new Evolution("Rhydon", "Rhyhorn", 40, 60, "★★★", 3),
            new Evolution("Rhyperior", "Rhyhorn", 50, 70, "★★★★", 4)
        ));

        evolutions.put("Poliwag", Arrays.asList(
            new Evolution("Poliwhirl", "Poliwag", 25, 30, "★★★", 3),
            new Evolution("Poliwrath", "Poliwag", 40, 50, "★★★★", 4)
        ));

        evolutions.put("Geodude", Arrays.asList(
            new Evolution("Graveler", "Geodude", 30, 40, "★★★", 3),
            new Evolution("Golem", "Geodude", 45, 60, "★★★★", 4)
        ));
    }

    public static Evolution getEvolution(String baseName, int stage) {
        List<Evolution> evoList = evolutions.get(baseName);
        if (evoList != null && stage > 0 && stage <= evoList.size()) {
            return evoList.get(stage - 1);
        }
        return null;
    }
    
    public static boolean hasEvolution(String pokemonName, int stage) {
        return evolutions.containsKey(pokemonName)
               && stage > 0
               && stage <= evolutions.get(pokemonName).size();
    }
    
    
}
