package game;

public class BattleEngine {
    Utilities util = new Utilities();

    public boolean runBattle(Pokemon[] playerTeam, Pokemon[] wildTeam) {
        int playerIndex = 0;
        int wildIndex = 0;
        int round = 1;

        Pokemon currentPlayerMon = playerTeam[playerIndex];
        Pokemon currentWildMon = wildTeam[wildIndex];
        
        util.clearConsole();
        System.out.println("\n⚔️ The battle begins!\n");

        while (true) {
            System.out.println("============ Round " + round + " ============\n");

            currentPlayerMon.attack(currentWildMon, true);
            
            if (currentWildMon.isDefeated()) {
                System.out.println(Utilities.BRIGHT_RED + currentWildMon.getName() + " fainted!" + Utilities.RESET + "\n");

                wildIndex++;
                if (wildIndex >= wildTeam.length) {
                    System.out.println("✅ You defeated all wild Pokémon!\n");
                    return true;
                }

                currentWildMon = wildTeam[wildIndex];
                System.out.println("➡ A wild " + Utilities.BRIGHT_RED + currentWildMon.getName() + Utilities.RESET + " appeared!\n");
            } else {
            	
                currentWildMon.attack(currentPlayerMon, false);

                if (currentPlayerMon.isDefeated()) {
                    System.out.println(Utilities.BRIGHT_BLUE + currentPlayerMon.getName() + " fainted!" + Utilities.RESET + "\n");

                    playerIndex++;
                    if (playerIndex >= playerTeam.length) {
                        System.out.println("❌ All your Pokémon fainted!");
                        return false;
                    }

                    currentPlayerMon = playerTeam[playerIndex];
                    System.out.println("➡ You send out " + Utilities.BRIGHT_BLUE + currentPlayerMon.getName() + Utilities.RESET + "!");
                }
            }

            util.waitForEnter();
            util.clearConsole();
            round++;
        }
    }
}
