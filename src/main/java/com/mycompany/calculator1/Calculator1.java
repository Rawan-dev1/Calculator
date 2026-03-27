
package com.mycompany.calculator1;
  import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator1 extends JFrame implements ActionListener {
    JTextField textField;
    String operator;
    double num1, num2, result;

    public Calculator1() {
        setTitle("الحاسبة");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // شاشة الحاسبة
        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        add(textField, BorderLayout.NORTH);

        // الأزرار
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            textField.setText(textField.getText() + command);
        } else if ("/-*+".contains(command)) {
            num1 = Double.parseDouble(textField.getText());
            operator = command;
            textField.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": 
                    if (num2 != 0) result = num1 / num2;
                    else { JOptionPane.showMessageDialog(this, "لا يمكن القسمة على صفر!"); return; }
                    break;
            }
            textField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new Calculator1();
    }
    }


