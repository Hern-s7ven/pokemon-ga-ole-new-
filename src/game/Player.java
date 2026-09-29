package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Player {
    private String name;
    public List<Pokemon> team;
    private static final String TEAM_FILE = "team.txt";
    
    Scanner input = new Scanner(System.in);
    Utilities util = new Utilities();

    public Player() {
        this.team = new ArrayList<>();
    }

    public List<Pokemon> getTeam() {
        return team;
    }
    
    public void checkEmptyTeam() {
    	if (team.size() < 2) {
        	Pokemon starter = new Pokemon("Pikachu", "Pikachu", "Electric", "Starter", 1);
        	starter.setBaseATK(150);
			starter.setBaseHP(600);
			starter.setLevel(80);
			starter.setEvolutionLevel(0);
			starter.setEvolutionCounter(10);
			starter.setMaxHP(starter.calculateMaxHP());
			team.add(starter);
			
			Pokemon starter2 = new Pokemon("Magikarp", "Magikarp", "Water", "Starter", 1);
        	starter2.setBaseATK(140);
			starter2.setBaseHP(550);
			starter2.setLevel(75);
			starter2.setEvolutionLevel(0);
			starter2.setEvolutionCounter(10);
			starter2.setMaxHP(starter.calculateMaxHP());
			team.add(starter2);
        }
    }
    
    public void newUser() {
		if (getName() == null) {
			System.out.println("Welcome! What is your name?");
			String name = input.nextLine();
			setName(name);
		}
	}
    
    public void loadTeam() {
    	
    	team.clear();  
    	
        File file = new File("team.txt");
        if (!file.exists()) {
            System.out.println("ℹ No saved team found. Giving you starter Pokémons!");
            checkEmptyTeam(); 
            saveTeam();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("⚠ Error creating new team file: " + e.getMessage());
            }
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 10) { 
                    String name = parts[0];
                    String baseName = parts[1];
                    String type = parts[2];
                    String rarity = parts[3];
                    
                    int nRarity = Integer.parseInt(parts[4]);
                    int baseATK = Integer.parseInt(parts[5]);
                    int baseHP = Integer.parseInt(parts[6]);
                    int level = Integer.parseInt(parts[7]);
                    int evolutionLevel = Integer.parseInt(parts[8]);
                    int evolutionCounter = Integer.parseInt(parts[9]);

                    Pokemon loadedPokemon = new Pokemon(name, baseName, type, rarity, nRarity);
                    	loadedPokemon.setBaseATK(baseATK);
                    	loadedPokemon.setBaseHP(baseHP);
                    	loadedPokemon.setLevel(level);
                    	loadedPokemon.setEvolutionLevel(evolutionLevel);
                    	loadedPokemon.setEvolutionCounter(evolutionCounter);
                    	loadedPokemon.setMaxHP(loadedPokemon.calculateMaxHP());
                    	
                    team.add(loadedPokemon);
                    
                }
            } 
        } catch (IOException e) {
            System.out.println("Error loading team: " + e.getMessage());
        }
    }
    
    public void saveTeam() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEAM_FILE))){
			for(Pokemon p : team) {
				if (p.getEvolutionCounter() == 0 && p.getEvolutionLevel() == 0) {
					p.setEvolutionCounter(10);
					p.setEvolutionLevel(1);
				}
				bw.write(p.getName() + "," + p.getBaseName() + "," + p.getType() + "," + p.getRarity() + "," + p.getnRarity() + "," + p.getBaseATK()
				+ "," + p.getBaseHP() + "," + p.getLevel() + "," +  p.getEvolutionLevel() + "," + p.getEvolutionCounter());
				bw.newLine();
				}
			}catch (IOException e) {
				System.out.println("Error saving team: " + e.getMessage());
			}
			System.out.println("Team Saved!");
			
		}

    public void addPokemon(Pokemon p) {
            team.add(p);
            System.out.println(p.getName() + " was added to " + name + "'s team!");
    }

    public void viewTeam() {
        int nameWidth = 12;
        int lvlWidth = 5;
        int rarityWidth = 8;
        int atkWidth = 5;
        int hpWidth = 4;

        System.out.println("\n===================== " + getName() + "'s Team =====================\n");
        System.out.printf("%-3s | %-" + nameWidth + "s | %-" + lvlWidth + "s | %-" + rarityWidth + "s | %-" + atkWidth + "s | %-" + hpWidth + "s%n",
                "#", "Name", "LVL", "Rarity", "ATK", "HP");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < team.size(); i++) {
            Pokemon p = team.get(i);
            System.out.printf("%-3d | %-" + nameWidth + "s | %-" + lvlWidth + "d | %-" + rarityWidth + "s | %-" + atkWidth + "d | %-" + hpWidth + "d%n",
                    (i + 1),
                    p.getName(),
                    p.getLevel(),
                    p.getRarity(),
                    p.calculateAttack(), 
                    p.getMaxHP());
        }
        System.out.println("======================================================");
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}