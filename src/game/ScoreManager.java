package game;
import java.io.*;
import java.util.*;

public class ScoreManager {
	private List<Integer> scores = new ArrayList<>();
	private static final String SCORE_FILE = "scores.txt";
	private static final String TOTAL_SCORE_FILE = "Total Score.txt";
	private static final int MAX_SCORES = 10;
	private Player player;
	private int totalScore;
	Utilities util = new Utilities();
	
	public ScoreManager(Player player) {
        this.player = player;
    }
	
	public void saveScores(int score) {
		scores.add(score);
		scores.sort(Collections.reverseOrder());
		if(scores.size() > MAX_SCORES) {
			scores = scores.subList(0, MAX_SCORES);
		}
		saveToFile();
	}
	
	public List<Integer> loadTopScores(){
		scores.clear();
		File file = new File(SCORE_FILE);
		if (!file.exists()) return scores;
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while((line = br.readLine()) != null) {
				try {
					scores.add(Integer.parseInt(line.trim()));
				}catch(NumberFormatException ignored) {}
			}
		}catch(IOException e) {
			System.out.println("Error loading scores: " + e.getMessage());
		}
		scores.sort(Collections.reverseOrder());
		return scores;
	}
	public List<Integer> getTopScores(){
		return new ArrayList<>(scores);
	}
	
	public void displayTopScores() {
	    System.out.println("============== Top Scores ==============\n");
	    System.out.printf("%-3s | %-15s | %-6s%n", "#", "USERNAME", "SCORE");
	    System.out.println("----------------------------------------");

	    int rank = 1;

	    for (int score : scores) {
	        System.out.printf("%-3d | %-15s | %-6d%n",
	                rank,
	                player.getName(),
	                score);
	        rank++;
	    }

	    if (scores.isEmpty()) {
	        System.out.println("No scores yet.....");
	    }
	}
	
	public void saveToFile() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(SCORE_FILE))){
			for(int score: scores) {
				bw.write(String.valueOf(score));
				bw.newLine();
				}
			}catch (IOException e) {
				System.out.println("Error saving scores: " + e.getMessage());
			}
			
		}
	public int accumulateScore(int score) {
			totalScore += score;
			return totalScore;
		}
	
	public void saveTotalScore() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TOTAL_SCORE_FILE))) {
            bw.write(String.valueOf(totalScore));
        } catch (IOException e) {
            System.out.println("⚠ Error saving score: " + e.getMessage());
        }
    }

    public void loadTotalScore() {
        try (BufferedReader br = new BufferedReader(new FileReader(TOTAL_SCORE_FILE))) {
            String line = br.readLine();
            if (line != null) {
                totalScore = Integer.parseInt(line);
            }
        } catch (IOException e) {
            System.out.println("⚠ No previous score found!");
        }
    }
	
	public void resetScore() {
		util.lines();
		System.out.println("Would you like to reset your accumulated Battle Score?");
		System.out.println("Enter 1 for Yes!");
		System.out.println("Enter 2 for No!");
		util.lines();
		int choice = util.getChoice(2);
		if (choice == 1) {
			setTotalScore(0);
			saveTotalScore();
			System.out.println("Score reset successful!");
		} else if (choice == 2) {
			System.out.println("Score reset unsuccessful!");
		}	
	}

	public void displayTotalScore() {
	    int total = getTotalScore();
	    util.clearConsole();
	    util.printPokemon();
	    util.lines();

	    System.out.println("\n                 🌟  Your Total Score: " + total + " 🌟");
	    System.out.println("\n================================================================\n");
	}

	
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getTotalScore() {
		return totalScore;
	}
}