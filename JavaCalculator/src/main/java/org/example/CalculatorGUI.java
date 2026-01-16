package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField display;
    private Calculator calculator;
    
    private double num1 = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public CalculatorGUI() {
        calculator = new Calculator();
        setTitle("Java Scientific Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Display
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        add(display, BorderLayout.NORTH);

        // Buttons Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 5, 5));

        // Button Labels
        String[] buttons = {
            "sin", "cos", "tan", "C",
            "log", "ln", "^", "sqrt",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Handle number inputs
        if ("0123456789.".contains(command)) {
            if (startNewNumber) {
                display.setText(command);
                startNewNumber = false;
            } else {
                if (command.equals(".")) {
                    if (!display.getText().contains(".")) {
                        display.setText(display.getText() + ".");
                    }
                } else {
                    display.setText(display.getText() + command);
                }
            }
            return;
        }

        // Handle Clear
        if (command.equals("C")) {
            display.setText("0");
            num1 = 0;
            operator = "";
            startNewNumber = true;
            return;
        }

        // Handle scientific operations (immediate execution)
        if ("sin cos tan log ln sqrt".contains(command)) {
            try {
                double value = Double.parseDouble(display.getText());
                double result = 0;
                switch (command) {
                    case "sin": result = calculator.sin(value); break;
                    case "cos": result = calculator.cos(value); break;
                    case "tan": result = calculator.tan(value); break;
                    case "log": result = calculator.log(value); break;
                    case "ln":  result = calculator.ln(value); break;
                    case "sqrt": result = calculator.sqrt(value); break;
                }
                display.setText(String.valueOf(result));
                startNewNumber = true;
            } catch (Exception ex) {
                display.setText("Error");
                startNewNumber = true;
            }
            return;
        }

        // Handle basic operators and power (delayed execution)
        if ("+ - * / ^".contains(command)) {
            try {
                num1 = Double.parseDouble(display.getText());
                operator = command;
                startNewNumber = true;
            } catch (Exception ex) {
                display.setText("Error");
            }
            return;
        }

        // Handle Equals
        if (command.equals("=")) {
            if (operator.isEmpty()) return;
            try {
                double num2 = Double.parseDouble(display.getText());
                double result = 0;
                switch (operator) {
                    case "+": result = calculator.add(num1, num2); break;
                    case "-": result = calculator.subtract(num1, num2); break;
                    case "*": result = calculator.multiply(num1, num2); break;
                    case "/": result = calculator.divide(num1, num2); break;
                    case "^": result = calculator.power(num1, num2); break;
                }
                display.setText(String.valueOf(result));
                operator = "";
                startNewNumber = true;
            } catch (Exception ex) {
                display.setText("Error");
                startNewNumber = true;
            }
        }
    }
}
