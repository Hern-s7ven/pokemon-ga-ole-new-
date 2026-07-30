package game.items;
import java.util.ArrayList;

public class Ball extends BaseItem {
    private final double catchRate;
    public static ArrayList<Ball> balls = new ArrayList<>();
    
    public static void loadBall() {
	    balls.add(new Ball("Poké Ball", 0, 50));
	    balls.add(new Ball("Great Ball", 200, 60));
	    balls.add(new Ball("Ultra Ball", 500, 75));
	    balls.add(new Ball("Master Ball", 1000, 100));
	}
    
    
    public Ball(String name, int cost, double catchRate) {
        super(name, cost);
        this.catchRate = catchRate;
    }
	
    public double getEffectiveness() {
        return catchRate;
    }


	public static ArrayList<Ball> getBalls() {
		return balls;
	}


	public static void setBalls(ArrayList<Ball> balls) {
		Ball.balls = balls;
	}
    
    
}