package game;
import game.items.*;

public class GameSequenceManager {

    private final Player player;
    private final ScoreManager sm;
    private final MenuManager mm;
    private final BattleManager bm;
    Utilities util = new Utilities();

    public GameSequenceManager() {
        this.player = new Player();
        this.sm = new ScoreManager(player);
        this.mm = new MenuManager();
        this.bm = new BattleManager(player, sm);
    }

    public void startGame() {
        sm.loadTopScores(); 
        sm.loadTotalScore();
        Ball.loadBall();
        Berry.loadBerry();
        player.loadTeam();

        System.out.println("\n===============================================================");
        util.printPokemon();
        System.out.println("===============================================================\n");

        player.newUser();
        gameLoop();
    }

    private void gameLoop() {
        while (true) {
            int choice = mm.displayMenu();

            switch (choice) {
                case 1 -> {
                    util.clearConsole();
                    util.printPokemon();
                    bm.startBattle();
                    util.waitForEnter();
                }
                case 2 -> {
                    util.clearConsole();
                    util.lines();
                    util.printPokemon();
                    util.lines();
                    sm.displayTopScores();
                    util.waitForEnter();
                }
                case 3 -> {
                    util.clearConsole();
                    util.lines();
                    util.printPokemon();
                    util.lines();
                    sm.displayTotalScore();
                    util.waitForEnter();
                }
                case 4 -> {
                    util.clearConsole();
                    util.lines();
                    util.printPokemon();
                    util.lines();
                    player.viewTeam();
                    util.waitForEnter();
                }
                case 5 -> {
                    util.clearConsole();
                    util.lines();
                    util.printPokemon();
                    util.lines();
                    sm.resetScore();
                    util.waitForEnter();
                }
                case 6 -> {
                    System.out.println("Exiting Game...");
                    util.input.close();
                    System.exit(0);
                }
                default -> System.out.println("⚠ Invalid choice, try again.");
            }
        }
    }
}
