package game;

public class MoveFactory {
    public static Move createMove(String type) {
        switch (type) {
            case "Grass":
                return new GrassMove("Razor Leaf", 55);
            case "Fire":
                return new FireMove("Fire Blast", 60);
            case "Water":
                return new WaterMove("Hydro Pump", 60);
            case "Electric":
                return new ElectricMove("Thunderbolt", 60);
            case "Flying":
                return new FlyingMove("Aerial Ace", 55);
            case "Bug":
                return new BugMove("Fury Cutter", 50);
            case "Rock":
                return new RockMove("Rock Slide", 60);
            case "Fighting":
                return new FightingMove("Punches", 65);
            case "Psychic":
                return new PsychicMove("Psyshock", 65);
            case "Ghost":
                return new GhostMove("Shadow Ball", 65);
            default:
                return new NormalMove("Body Slam", 40); 
        }
    }
    
    public static Move createLegendaryMove(String name, String type) {
        switch (name) {
            case "Mewtwo":
                return new LegendaryPsychicMove("Psystrike", 95);
            case "Rayquaza":
                return new LegendaryFlyingMove("Dragon Ascent", 95);
            case "Arceus":
                return new LegendaryNormalMove("Aeroblast", 90);
            default:
                return createMove(type);
        }
    }

}
