package game;
import game.items.*;

public class CatchPhase {
    private Utilities util = new Utilities();
    private Player player;
    private Shop shop;
    private CatchSystem cs;

    public CatchPhase(Player player, ScoreManager sm) {
        this.player = player;
        this.shop = new Shop(sm);
        this.cs = new CatchSystem(player);
    }

    public void attemptCatch(Pokemon wildMon) {
        util.lines();
        System.out.println("Would you like to attempt to capture " + wildMon.getName() + "?");
        System.out.println("Enter 1 for Yes!");
        System.out.println("Enter 2 for No!");
        util.lines();
        int choice = util.getChoice(2);
        
        util.clearConsole();
        
        if (choice == 1) {
            shop.showBall();
            System.out.println("\nCurrent Catch Chance: " + 
                    cs.calculateCatchProbability(wildMon, Ball.getBalls().get(0), null) + "%");
            util.lines();
            
            int ballChoice = util.getChoice(Ball.getBalls().size());
            shop.purchaseBall(wildMon, ballChoice, cs);
            Ball selectedBall = Ball.getBalls().get(ballChoice - 1);

            shop.showBerry();
            System.out.println("\nCurrent Catch Chance: " + 
                    cs.calculateCatchProbability(wildMon, Ball.getBalls().get(ballChoice - 1), null) + "%");
            util.lines();
            
            int berryChoice = util.getChoice(Berry.getBerries().size());
            shop.purchaseBerry(wildMon, berryChoice, cs, selectedBall);
            Berry selectedBerry = Berry.getBerries().get(berryChoice - 1);

            cs.caught(wildMon, selectedBall, selectedBerry);
            util.lines();
            
        } else {
            System.out.println("\nThe wild " + wildMon.getName() + " has fled!");
        }
    }
}
