# Battleship Game

A full-featured, console-based implementation of the classic Battleship game in Java. This project guides you through all the core mechanics of Battleship: ship placement, turn-based shooting, fog of war, win detection, and multiplayer support.

---

## Table of Contents

- [Overview](#overview)
- [Game Rules](#game-rules)
- [Project Features](#project-features)
- [Gameplay Examples](#gameplay-examples)
- [How to Run](#how-to-use)
- [License](#license)

---

## Overview

Battleship (also known as Sea Battle) is a two-player strategy game whose history traces back to the First World War. It started as a pencil-and-paper game and was later published as a board and computer game. In this project, you will recreate this timeless classic in Java, following the original rules.

---

## Game Rules

- The game is played on a 10×10 grid, with rows labeled **A–J** and columns **1–10**.
- Each player arranges the following five ships on their field:
    - **Aircraft Carrier** (5 cells)
    - **Battleship** (4 cells)
    - **Submarine** (3 cells)
    - **Cruiser** (3 cells)
    - **Destroyer** (2 cells)
- Ships can be placed horizontally or vertically, but not diagonally. Ships must not overlap or touch each other, even at corners.
- Symbols used on the field:
    - `~` — Fog of war (unknown or empty water)
    - `O` — Ship segment
    - `X` — Hit ship segment
    - `M` — Missed shot

---

## Project Features

### 1. Field Creation and Ship Placement

- Print an empty 10×10 field with correct row and column labels.
- Players place their ships by entering two coordinates (start and end). The order does not matter.
- The program validates input: ships must be straight, correct length, within bounds, and not adjacent to other ships.
- Ships are placed in order from largest to smallest.
- The field is displayed after each successful placement.


### 2. Shooting Mechanics

- After all ships are placed, players take turns shooting by entering a coordinate.
- Hits are marked with `X`, misses with `M`.
- The program displays messages indicating whether the shot was a hit, miss, or resulted in sinking a ship.


### 3. Fog of War

- Before each shot, the opponent’s field is displayed with fog of war (`~` for unknown cells, except for hits and misses).
- After each shot, both the foggy opponent field and the player's own field are shown.


### 4. Game Progression and Win Detection

- The game continues until all ships of one player are sunk.
- When a ship is completely destroyed, the program prints:
`You sank a ship!`
- When the last ship is sunk, the program prints:
`You sank the last ship. You won. Congratulations!`


### 5. Multiplayer Mode

- Two players take turns placing ships and shooting at each other’s fields.
- After each move, the program prompts:
`Press Enter and pass the move to another player`
- This ensures fair play and prevents peeking.
- The first player to sink all opponent’s ships wins.

---

## Gameplay Examples

Below are selected gameplay snippets illustrating the main features and user interactions.

### Ship Placement

```
Player 1, place your ships on the game field

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
...
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

Enter the coordinates of the Aircraft Carrier (5 cells):
&gt; F3 F7

  1 2 3 4 5 6 7 8 9 10
F ~ ~ O O O O O ~ ~ ~
...
```


### Shooting and Fog of War

```
Take a shot!
> A1

  1 2 3 4 5 6 7 8 9 10
A X ~ ~ ~ ~ ~ ~ ~ ~ ~
...

You hit a ship!
```


### Multiplayer Turn Passing

```
Player 1, it's your turn:
> I3
You missed!
Press Enter and pass the move to another player

Player 2, it's your turn:
> A1
You hit a ship!
Press Enter and pass the move to another player
```


### End of Game

```
You sank the last ship. You won. Congratulations!
```


---

## How to use

You can directly launch the game with `gradle`:

```bash
gradle run --quiet --console=plain
```

It will download dependencies, build, test and then launch the game.
The `--quiet` and `--console=plain` option will disable gradle output, so you will see only the console game interface and interact with it.

## Development

You can build the project with:

```bash
gradle build
```

It will build and tests this project, if you want to skip tests, run `gradle assemble`.

To run the tests:

```bash
gradle test
```

## License

This project is for educational purposes as part of the Hyperskill Java course.

---
