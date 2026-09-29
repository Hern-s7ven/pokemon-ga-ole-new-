package game;
import game.items.*;

public class Shop {

    private ScoreManager sm;
    Utilities util = new Utilities();

    public Shop(ScoreManager sm) {
        this.sm = sm;
    }

    public void showBall() {

        System.out.println("\n======== 🛒 Shop Items ========");

        int i = 1;

        System.out.println("\n🎯 Balls:");
        for (Ball bl : Ball.getBalls()) {
            System.out.println(i + ") " + bl.getName() + "  -  " + bl.getCost() + " BP");
            i++;
        }

        System.out.println("\n💰 You currently have: " + sm.getTotalScore() + " BP");
    }
    
    public void showBerry() {
    	
    	System.out.println("\n======== 🛒 Shop Items ========");
    	
    	int i = 1;
    	
    	System.out.println("\n🍓 Berries:");
        for (Berry br : Berry.getBerries()) {
            System.out.println(i + ") " + br.getName() + "  -  " + br.getCost() + " BP");
            i++;
        }
    	
        System.out.println("\n💰 You currently have: " + sm.getTotalScore() + " BP");	
    }

    public int askForBall() {
        util.lines();
        System.out.print("What Poké Ball would you like to use? ");
        return util.getChoice(Ball.getBalls().size());
    }
    
    public int askForBerry() {
        util.lines();
        System.out.print("What Berry would you like to purchase? ");
        return util.getChoice(Berry.getBerries().size());
    }

    public void purchaseBall(Pokemon wildMon, int choice, CatchSystem cs) {
        while (true) {
            Ball selectedBall = Ball.getBalls().get(choice - 1);

            if (buyItem(selectedBall)) {
                break;
            }

            showBall();
            
            System.out.println("\nCurrent Catch Chance: " + 
                    cs.calculateCatchProbability(wildMon, Ball.getBalls().get(0), Berry.getBerries().get(3)) + "%");
            util.lines();
            
            choice = util.getChoice(Ball.getBalls().size());
        }
    }
    
    public void purchaseBerry(Pokemon wildMon, int choice, CatchSystem cs, Ball selectedBall) {
        while (true) {
            Berry selectedBerry = Berry.getBerries().get(choice - 1);

            if (buyItem(selectedBerry)) {
                break;
            }

            showBerry();
            
            System.out.println("Current Catch Chance: " + 
                    cs.calculateCatchProbability(wildMon, selectedBall, Berry.getBerries().get(3)) + "%");
            util.lines();
            choice = util.getChoice(Berry.getBerries().size());
        }
    }

    private boolean buyItem(BaseItem item) {
        int currentBP = sm.getTotalScore();

        if (currentBP >= item.getCost()) {
            sm.setTotalScore(currentBP - item.getCost());

            if (item.getName().equals("I dont want to purchase a berry!")) {
                System.out.println("\n❌ You didn't use a berry!");
            } else {
                System.out.println("\n✅ You used a " + item.getName() + "!");
            }
            sm.saveTotalScore();
            return true;
        } else {
            System.out.println("\n❌ Not enough BP to buy " + item.getName() + ".");
            return false;
        }
    }
}
