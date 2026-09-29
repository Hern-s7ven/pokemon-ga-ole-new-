package game;
import java.util.*;

public class TypeChart {
    static Map<String, List<String>> superEffective = new HashMap<>();
    static Map<String, List<String>> notEffective = new HashMap<>();

    static {
        superEffective.put("Fire", Arrays.asList("Grass","Bug"));
        superEffective.put("Water", Arrays.asList("Fire", "Rock"));
        superEffective.put("Grass", Arrays.asList("Water", "Rock"));
        superEffective.put("Electric", Arrays.asList("Water", "Flying"));
        superEffective.put("Rock", Arrays.asList("Flying", "Bug", "Fire"));
        superEffective.put("Fighting", Arrays.asList("Rock", "Bug", "Normal"));
        superEffective.put("Ghost", Arrays.asList("Ghost", "Psychic"));
        superEffective.put("Bug", Arrays.asList("Grass", "Ghost"));
        superEffective.put("Flying", Arrays.asList("Bug", "Fighting"));
        superEffective.put("Psychic", Arrays.asList("Fighting", "Ghost"));

        notEffective.put("Fire", Arrays.asList("Water", "Rock", "Fire"));
        notEffective.put("Water", Arrays.asList("Grass", "Water"));
        notEffective.put("Grass", Arrays.asList("Fire", "Bug", "Grass"));
        notEffective.put("Electric", Arrays.asList("Grass", "Electric"));
        notEffective.put("Rock", Arrays.asList("Rock", "Fighting"));
        notEffective.put("Fighting", Arrays.asList("Flying", "Ghost"));
        notEffective.put("Ghost", Arrays.asList("Rock"));
        notEffective.put("Bug", Arrays.asList("Rock", "Fire"));
        notEffective.put("Flying", Arrays.asList("Rock", "Electric"));
        notEffective.put("Psychic", Arrays.asList("Psychic"));
        notEffective.put("Normal", Arrays.asList("Rock"));
    }

    public static double getEffectiveness(String attackType, String defenderType) {
        if (superEffective.containsKey(attackType) && superEffective.get(attackType).contains(defenderType)) {
            return 2.0;
        } else if (notEffective.containsKey(attackType) && notEffective.get(attackType).contains(defenderType)) {
            return 0.5;
        }
        return 1.0;
    }

    public static String effectivenessText(double multiplier) {
        if (multiplier == 2.0) return "super effective";
        if (multiplier == 0.5) return "not very effective";
        return "normally effective";
    }
}
