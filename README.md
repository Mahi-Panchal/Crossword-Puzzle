# 🧩 Java CLI Crossword Puzzle Game

<div align="center">

![Java](https://img.shields.io/badge/Language-Java%208%2B%20%2F%20JDK-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Paradigm](https://img.shields.io/badge/Paradigm-Object--Oriented%20Programming%20(OOP)-007396?style=for-the-badge)
![Architecture](https://img.shields.io/badge/Architecture-Inheritance%20%26%20Polymorphism-4B8BBE?style=for-the-badge)
![Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge&logo=github-actions&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

<p align="center">
  <strong>An interactive terminal-based 2D crossword puzzle game demonstrating core Object-Oriented Programming (OOP) principles, polymorphic grid rendering, and dynamic cursor-based navigation in pure Java.</strong>
</p>

[Key Features](#-key-features) •
[OOP Architecture](#-object-oriented-architecture) •
[How to Play](#-how-to-play) •
[Quickstart](#-quickstart--installation) •
[Project Structure](#-project-structure) •
[Engineering Highlights](#-engineering-highlights)

---

</div>

## 📌 Project Overview

The **Java CLI Crossword Puzzle Game** is a console-based, multi-level word puzzle application engineered from scratch in Java. It blends traditional crossword puzzle mechanics with interactive 2D grid matrix navigation, leveraging foundational Object-Oriented Software Design patterns.

Players navigate a 2D coordinate system using directional controls, inspect pre-populated hint characters, solve crossword clues, and edit designated mutable tiles while being constrained by non-traversable boundaries and immutable pre-set characters.

---

## 🚀 Key Features

- **🎮 Multi-Level Progression**: Features 3 distinct, escalating difficulty levels with custom grid topologies:
  - **Level 1**: $10 \times 10$ Grid Matrix
  - **Level 2**: $7 \times 8$ Grid Matrix
  - **Level 3**: $10 \times 8$ Grid Matrix
- **📍 Real-Time Cursor Rendering**: Dynamic terminal renderer displaying active player focus (`[ X ]`) versus ambient grid tiles (`  X  `).
- **🛡️ Defensive Boundary & Collision Detection**: Real-time validation preventing grid overflow, array out-of-bounds exceptions, and unauthorized edits on fixed/wall tiles.
- **🔄 Polymorphic Grid Engine**: 2D grid composed of polymorphic `Grid` objects dynamically resolving tile behaviors via inheritance.
- **⌨️ Intuitive Command Interface**: Single-keystroke command dispatcher for navigation, editing, verification, and session lifecycle control.

---

## 🏛️ Object-Oriented Architecture

The game demonstrates strong software engineering practices through a clean class hierarchy:

```
                      ┌──────────────────────┐
                      │      Grid.java       │
                      │  char letter = '_'   │
                      └──────────┬───────────┘
                                 │
                   ┌─────────────┴─────────────┐
                   │ (extends)                 │ (extends)
        ┌──────────▼───────────┐    ┌──────────▼───────────┐
        │     Letter.java      │    │      Wall.java       │
        ├──────────────────────┤    ├──────────────────────┤
        │ final int pos (0/1)  │    │ char letter = '#'    │
        │ char letter          │    │ final int pos = 1    │
        └──────────────────────┘    └──────────────────────┘
```

### OOP Principles Applied:

1. **Inheritance & Subtyping**: `Letter` and `Wall` extend the base `Grid` class, allowing the game board to be stored in a unified 2D polymorphic array:
   ```java
   Grid[][] array = new Grid[10][10];
   ```
2. **Encapsulation & Immutability**: Uses `final int pos` to distinguish between:
   - `pos = 1`: Immutable tiles (pre-filled hints or walls).
   - `pos = 0`: Mutable user-editable cells.
3. **Polymorphic Type Checking**: Safe downcasting at runtime using `instanceof` before mutating state:
   ```java
   if (array[x][y] instanceof Letter && ((Letter) array[x][y]).pos == 0) {
       // Safe to write
   }
   ```
4. **Constructors & Method Overloading**: Multiple constructor signatures in `Letter` (`Letter()`, `Letter(int tmp)`, `Letter(char temp, int tmp)`) supporting flexible tile instantiation.

---

## 🎮 How to Play

### Controls & Input Commands

| Command | Key | Description |
| :---: | :---: | :--- |
| **Up** | `U` | Move cursor one cell up |
| **Down** | `D` | Move cursor one cell down |
| **Left** | `L` | Move cursor one cell left |
| **Right** | `R` | Move cursor one cell right |
| **Write** | `W` | Enter edit mode to insert a letter at the active cursor |
| **Submit**| `S` | Validate the board against the level's solution |
| **Exit** | `E` | Terminate the application gracefully |

### Tile Legend:
- `[ _ ]` : Active cursor position on a blank, writable cell.
- `[ A ]` : Active cursor position on a character tile.
- `  #  ` : Non-playable boundary / wall tile.
- `  _  ` : Editable empty cell waiting for your input.
- `  D  ` : Immutable pre-filled clue / hint character.

---

## 💻 Quickstart & Installation

### Prerequisites
- **Java Development Kit (JDK 8 or higher)**
  ```bash
  javac -version
  java -version
  ```

### 🛠️ Compilation

Clone this repository and compile all Java classes:

```bash
# Clone the repository
git clone https://github.com/your-username/java-crossword-game.git
cd java-crossword-game

# Compile all source files
javac *.java
```

### ▶️ Run the Game

```bash
java Main
```

---

## 🖥️ Gameplay Demonstration

```text
            *    **********       ***********   ***********   ...
         **      **********       **       **   *             ...
       **        **       **      **       **   *             ...

Welcome to Crossword Game!

Rules:
1. There are 3 levels.
2. Keys for movements: Right(R), Left(L), Up(U), Down(D)
3. For any wrong move, message will be shown on right side of screen.
4. To check the answers, enter 'S'.
5. To exit the game, enter 'E'.

                                 Level 1

[ # ]  #    #    #    #    #    #    #    #    #  
  #    D    _    _    _    _    #    #    #    #  
  #    _    L    _    _    _    _    T    _    M  
  #    _    #    #    #    #    R    #    #    #  
  #    A    #    #    #    #    _    #    #    #  

Enter the choice(Up - U)(Down - D)(Right - R)(Left - L)(Submit - S)(Exit - E)(Write - W): 
```

---

## 📂 Project Structure

```text
├── Main.java       # Game entry point, banner presentation, level orchestrator
├── Grid.java       # Base abstract representation of a board cell
├── Letter.java     # Subclass for playable and hint-containing tiles
├── Wall.java       # Subclass for non-playable obstacles ('#')
├── Level1.java     # Level 1 grid definition (10x10) and validation logic
├── Level2.java     # Level 2 grid definition (7x8) and validation logic
├── Level3.java     # Level 3 grid definition (10x8) and validation logic
├── README.md       # Comprehensive documentation and engineering overview
└── LICENSE         # MIT Open-Source License
```

---

## 💡 Engineering Highlights for Recruiters

- **Zero External Dependencies**: Pure Java Standard Library implementation (`java.util.Scanner`), making it lightweight and cross-platform across Windows, macOS, and Linux.
- **Robust Exception Handling**: Defensive boundary checking preventing `ArrayIndexOutOfBoundsException` on all directional keystrokes.
- **Modular Level Management**: Each level is encapsulated in its own execution context, demonstrating loose coupling and modular design.
- **Extensible Architecture**: The `Grid` class hierarchy easily supports new tile types (e.g., `BonusTile`, `HintTile`) without breaking existing game loop logic (Open/Closed Principle).

---

## 👥 Authors

- **Mahi Panchal**
  
---

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.
