# Java Scientific Calculator

A robust, graphical calculator built with Java Swing that supports both standard arithmetic and common scientific operations.

## Features

### Arithmetic Operations
- Addition (`+`)
- Subtraction (`-`)
- Multiplication (`*`)
- Division (`/`)

### Scientific Operations
- Trigonometry: `sin`, `cos`, `tan` (Degrees)
- Logarithms: `log` (base 10), `ln` (Natural log)
- Power: `x^y`
- Square Root: `sqrt`

### Technical Details
- **GUI Framework**: Java Swing
- **Language**: Java 25
- **Build Tool**: Maven
- **Testing**: JUnit 5

## Getting Started

### Prerequisites
- JDK 25 or higher
- Apache Maven

### Installation & Running
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/JavaCalculator.git
   ```
2. Navigate to the project directory:
   ```bash
   cd JavaCalculator
   ```
3. Compile and Run:
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="org.example.Main"
   ```

### Running Tests
To verify the calculator's logic:
```bash
mvn test
```

## Project Structure
- `src/main/java/org/example/Calculator.java`: Core mathematical logic.
- `src/main/java/org/example/CalculatorGUI.java`: Swing-based user interface.
- `src/main/java/org/example/Main.java`: Application entry point.
- `src/test/java/org/example/CalculatorTest.java`: Unit tests for math operations.

## License
This project is open-source and available under the MIT License.
