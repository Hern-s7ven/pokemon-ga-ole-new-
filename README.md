# Pokémon Ga-Ole

A console-based Pokémon battle and catching game written in Java, built around OOP principles (inheritance, polymorphism, factory pattern) across 38 classes.

## Features

- **Battle System** — Choose 2 Pokémon to fight 2 wild Pokémon in turn-based combat, with a type effectiveness chart (super/not-very effective) driving damage calculations.
- **Catching System** — Encounter wild Pokémon with weighted rarity rolls (★ to ★★★★), then buy Poké/Great/Ultra/Master Balls and Berries to boost catch probability.
- **Evolution** — Pokémon evolve after enough battles, gaining stat boosts and rarity upgrades.
- **Shop** — Spend Battle Points (BP) earned from battles on Balls and Berries.
- **Scoring** — Battle scores are tallied per fight (with a Flawless Victory bonus), saved to a top-10 leaderboard, and accumulated into a running total.
- **Persistence** — Team roster, top scores, and total score are saved to and loaded from local text files (`team.txt`, `scores.txt`, `Total Score.txt`) between sessions.

## Project Structure

```
src/
└── game/
    ├── Main.java                  # Entry point
    ├── GameSequenceManager.java   # Startup + main menu loop
    ├── MenuManager.java           # Menu display
    ├── Player.java                # Player state, team persistence
    ├── Pokemon.java               # Core Pokémon model (stats, attack, evolve)
    ├── pokemonDatabase.java       # Master list of catchable species
    ├── WildPokemonGenerator.java  # Weighted rarity encounter generation
    ├── TypeChart.java             # Type effectiveness lookup
    ├── EvolutionDatabase.java / Evolution.java
    ├── Move.java + [Type]Move.java + LegendaryXMove.java  # Move type hierarchy
    ├── MoveFactory.java           # Move creation by Pokémon type
    ├── BattleManager.java / BattleSetup.java / BattleEngine.java / BattleResult.java
    ├── CatchPhase.java / CatchSystem.java
    ├── Shop.java / ScoreManager.java
    ├── Utilities.java             # Shared console I/O helpers
    └── items/
        ├── BaseItem.java
        ├── Ball.java
        └── Berry.java
```

## How to Run

Requires JDK 17+.

```bash
# Compile
javac -d out $(find src -name "*.java")

# Run (from the directory containing your data files)
java -cp out game.Main
```

On first run it will create `team.txt` with two starter Pokémon (Pikachu, Magikarp) if none exists.

## Notes

- All classes live in package `game` (items in `game.items`).
- Console I/O runs through a single shared `Scanner` in `Utilities` — earlier revisions created a new `Scanner(System.in)` in multiple classes, which caused intermittent `NoSuchElementException` crashes on menu input; this has been fixed so all input reads share one stream.
