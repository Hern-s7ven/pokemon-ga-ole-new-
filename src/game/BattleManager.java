package game;

public class BattleManager {
    private BattleSetup setup;
    private BattleEngine engine;
    private BattleResult result;
    
    Utilities util = new Utilities();

    public BattleManager(Player player, ScoreManager sm) {
        this.setup = new BattleSetup(player, sm);
        this.engine = new BattleEngine();
        this.result = new BattleResult(player, sm);
    }

    public void startBattle() {
        setup.preBattleCatch();
        util.waitForEnter();

        Pokemon[] wildTeam = setup.generateWildBattleTeam();
        Pokemon[] playerTeam = setup.chooseTwoPlayerPokemon();

        for (Pokemon p : playerTeam) {
            p.setCurrentHP(p.getMaxHP());
        }
        for (Pokemon p : wildTeam) {
            p.setCurrentHP(p.getMaxHP());
        }

        boolean playerWon = engine.runBattle(playerTeam, wildTeam);

        result.handleBattleEnd(playerTeam, wildTeam, playerWon);
    }

}