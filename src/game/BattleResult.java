package game;

public class BattleResult {
    private Player player;
    private ScoreManager sm;
    private CatchPhase catchPhase;
    private Utilities util = new Utilities();

    public BattleResult(Player player, ScoreManager sm) {
        this.player = player;
        this.sm = sm;
        this.catchPhase = new CatchPhase(player, sm);
    }

    public void handleBattleEnd(Pokemon[] playerTeam, Pokemon[] wildTeam, boolean playerWon) {
        if (playerWon) {
            System.out.println("🎉 You won the battle!\n");
            
            int battleScore = calculateScore(playerTeam[0], wildTeam[0]) + calculateScore(playerTeam[1], wildTeam[1]);
            boolean flawlessVictory = (playerTeam[0].getCurrentHP() > 0 && playerTeam[1].getCurrentHP() > 0);
            
            if (flawlessVictory) {
                System.out.println("✨ Flawless Victory Bonus! +100 BP ✨");
                battleScore += 100;
            }
            
            System.out.println("You have earned " + battleScore + " Battle Score!\n");
            sm.saveScores(battleScore);
            sm.accumulateScore(battleScore);
            sm.saveTotalScore();
            sm.saveToFile();

            util.waitForEnter();

            for (Pokemon p : playerTeam) {
                p.setEvolutionCounter(p.getEvolutionCounter() - 1);
                if (p.checkEvolution()) {
                    p.evolve();
                }
            }
            player.saveTeam();

            util.waitForEnter();
            for (Pokemon defeated : wildTeam) {
                catchPhase.attemptCatch(defeated);
            }
        } else {
            System.out.println("Oh no, you have lost the battle... Better luck next time!");
        }
    }

    private int calculateScore(Pokemon playerMon, Pokemon wildMon) {
        int hpBonus = playerMon.getCurrentHP() / 10; 
        int rarityBonus = wildMon.getnRarity() * 40; 
        int baseScore = 100;  

        return baseScore + hpBonus + rarityBonus;
    }
}
