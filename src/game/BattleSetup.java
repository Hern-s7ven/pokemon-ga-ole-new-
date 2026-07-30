package game;
import java.util.*;

public class BattleSetup {
    private Player player;
    private Utilities util = new Utilities();
    private WildPokemonGenerator generator = new WildPokemonGenerator();
    private CatchPhase catchPhase;
    private ScoreManager sm;

    public BattleSetup(Player player, ScoreManager sm) {
        this.player = player;
        this.sm = sm;
        this.generator = new WildPokemonGenerator();
        this.catchPhase = new CatchPhase(player, sm);
    }

    public void preBattleCatch() {
        util.lines();
        System.out.println("🌟 You have encountered some wild Pokémon!\n");
        List<Pokemon> wildChoices = generator.generateWildPokemon();

        for (int i = 0; i < wildChoices.size(); i++) {
            System.out.println((i+1) + " | " + wildChoices.get(i));
        }

        util.lines();

        System.out.println("Select a Pokémon to capture!");

        int choice = util.getChoice(3);
        if (choice != 0) {
            Pokemon chosen = wildChoices.get(choice-1);
            catchPhase.attemptCatch(chosen);
        }
    }

    public Pokemon[] generateWildBattleTeam() {
        List<Pokemon> wild = generator.generateWildPokemon();
        System.out.println("Two fierce wild Pokémon have pounced in front of you!\n");

        int nameWidth = 12;
        int typeWidth = 10;
        int rarityWidth = 6;
        int lvlWidth = 5;

        System.out.printf("%-" + nameWidth + "s | %-" + typeWidth + "s | %-" + rarityWidth + "s | %-" + lvlWidth + "s%n",
                "Name", "Type", "Rarity", "LVL");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < 2; i++) {
            Pokemon p = wild.get(i);
            System.out.printf("%-" + nameWidth + "s | %-" + typeWidth + "s | %-" + rarityWidth + "s | %-" + lvlWidth + "d%n",
                    p.getName(), p.getType(), p.getRarity(), p.getLevel());
        }

        return new Pokemon[]{ wild.get(0), wild.get(1) };
    }

    public Pokemon[] chooseTwoPlayerPokemon() {
        util.lines();
        System.out.println("📜 Choose TWO Pokémon for the battle!");

        player.viewTeam();

        System.out.print("➡ Choose your first Pokémon: \n");
        int firstChoice = util.getChoice(player.getTeam().size());
        Pokemon firstMon = player.getTeam().get(firstChoice - 1);

        Pokemon secondMon;
        while (true) {
            System.out.print("➡ Choose your second Pokémon: \n");
            int secondChoice = util.getChoice(player.getTeam().size());

            if (secondChoice == firstChoice) {
                System.out.println("⚠ You already chose " + firstMon.getName() + "! Pick a different Pokémon.");
            } else {
                secondMon = player.getTeam().get(secondChoice - 1);
                break;
            }
        }

        System.out.println(firstMon.getName() + " is ready!");
        System.out.println(secondMon.getName() + " is ready!");

        return new Pokemon[]{ firstMon, secondMon };
    }

}