package game;
import java.util.*;

public class Utilities {
	
	Scanner input = new Scanner(System.in);
	
    public static final String RESET = "\u001B[0m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_RED = "\u001B[91m";

    public static String color(String text, String color) {
        return color + text + RESET;
    }
	
	public void waitForEnter() {
		System.out.println("\n\n---------------------------------------");
	    System.out.println("   ➡ Press ENTER to continue...");
	    System.out.println("---------------------------------------");
		input.nextLine();
	}

	public void clearConsole() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}
	public void lines() {
		System.out.println("================================================================");
	}
	
	public int getChoice(int maxChoice) {
	    int choice = 0;

	    while (true) {
	        System.out.print("Enter your choice: ");
	        try {
	            choice = input.nextInt();

	            if (choice >= 1 && choice <= maxChoice) {
	                return choice;
	            } else {
	                System.out.println("⚠ Please enter ONLY numbers between 1 and " + maxChoice + ".");
	            }

	        } catch (InputMismatchException e) {
	            System.out.println("⚠ Invalid input! Please enter a number only.");
	            input.nextLine();
	        }
	    }
	}
	
	public void printPokemon() {
	    String[] art = {
	        "██████╗  ██████╗ ██╗  ██╗███████╗███╗   ███╗ ██████╗ ███╗   ██╗",
	        "██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝████╗ ████║██╔═══██╗████╗  ██║",
	        "██████╔╝██║   ██║█████╔╝ █████╗  ██╔████╔██║██║   ██║██╔██╗ ██║",
	        "██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██║╚██╔╝██║██║   ██║██║╚██╗██║",
	        "██║     ╚██████╔╝██║  ██╗███████╗██║ ╚═╝ ██║╚██████╔╝██║ ╚████║",
	        "╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═══╝",
	    };

	    for (String line : art) {
	        System.out.println(line);
	    }
	}
}
