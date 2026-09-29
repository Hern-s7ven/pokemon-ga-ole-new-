package game;

public class MenuManager {
	
	Utilities util = new Utilities();
	
	public int displayMenu() {
		util.clearConsole();
		util.lines();
		util.printPokemon();
		util.lines();
		System.out.println("\n================== Main Menu ==================");
		
		System.out.println("1) Start Game");
		System.out.println("2) View Top Scores");
		System.out.println("3) View Accumulated Battle Score");
		System.out.println("4) View Team");
		System.out.println("5) Reset Battle Score");
		System.out.println("6) Exit Game");
		System.out.println("===============================================");
		
		return util.getChoice(6);
	}
	

}
