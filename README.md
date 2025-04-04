# Connect 4 in Java

## Project Overview
This is a simple Connect 4 game implemented in Java. It features:
1. **Two-Player Mode**: Two human players take turns placing pieces on a console-based board.
2. **Single-Player Mode**: One player competes against a basic opponent: machine is playing randomly.
3. **Single-Player VS AI Mode**: One player competes against an AI using MiniMax.

The game is played in a 6-row by 7-column grid, following the classic Connect 4 rules.

## Features
- **Game Modes:**
  - Player vs. Player
  - Player vs. Random AI
  - Player vs. Minimax AI (intelligent opponent)
- Console-based interface for easy play.
- Valid move checks to prevent invalid placements.
- Automatic win detection (horizontal, vertical, diagonal victory conditions).
- **Minimax Algorithm:** The AI evaluates the board and makes optimal moves.

## How to Play
- Players take turns selecting a column (1-7) to drop their pieces.
- The game checks for a winner after every move.
- If a player connects four pieces in a row (horizontally, vertically, or diagonally), they win.
- If all columns are full and no player has won, the game ends in a draw.
- In **single-player modes**, the AI will make its move automatically after the player.

## Installation & Usage
### Prerequisites
- Java Development Kit (JDK)
- Use a terminal or command prompt to run the game.

### Steps to Run
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/AurelieMrtn/Connect_Four.git
   cd Connect_Four
   ```
2. **Compile the Java Files:**
   ```sh
   javac -d out src/*.java
   ```
3. **Run the Game:**
   ```sh
   java -cp out Connect_Four
   ```
4. **Follow the Instructions in the Console** to choose your game mode and play!
