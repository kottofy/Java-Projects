//Ballyn Miller
//Program 6 : Calculator
//Program is a basic calculator.

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JFrame {

    double result = 0;
    JButton num1 = new JButton("1");
    JButton num2 = new JButton("2");
    JButton num3 = new JButton("3");
    JButton num4 = new JButton("4");
    JButton num5 = new JButton("5");
    JButton num6 = new JButton("6");
    JButton num7 = new JButton("7");
    JButton num8 = new JButton("8");
    JButton num9 = new JButton("9");
    JButton num0 = new JButton("0");
    JButton ce = new JButton("ce");
    JButton addition = new JButton("+");
    JButton minus = new JButton("-");
    JButton multiplication = new JButton("*");
    JButton division = new JButton("/");
    JButton decimal = new JButton(".");
    JButton equals = new JButton("=");
    boolean decPressed = false;
    boolean actPressed = false;
    boolean minusPressed = false;
    boolean addPressed = false;
    boolean divPressed = false;
    boolean multPressed = false;
    JTextField textField = new JTextField();
    String var1String = "";
    String resultString = " ";
    JPanel bottomPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel otherPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel sidePanel = new JPanel();
    Button listener1 = new Button();
    Calculate listener = new Calculate();

    public Calculator() {
        textField.setEditable(false);
        textField.setVisible(true);
        textField.setBackground(Color.white);
        sidePanel.setLayout(new GridLayout(4, 1, 2, 2));
        mainPanel.setLayout(new BorderLayout(5, 10));
        buttonPanel.setLayout(new GridLayout(4, 3, 5, 5));
        otherPanel.setLayout(new GridLayout(2, 1, 1, 1));
        bottomPanel.setLayout(new GridLayout(1, 1));
        num1.addActionListener(listener1);
        num2.addActionListener(listener1);
        num3.addActionListener(listener1);
        num4.addActionListener(listener1);
        num5.addActionListener(listener1);
        num6.addActionListener(listener1);
        num7.addActionListener(listener1);
        num8.addActionListener(listener1);
        num9.addActionListener(listener1);
        num0.addActionListener(listener1);
        addition.addActionListener(listener);
        minus.addActionListener(listener);
        division.addActionListener(listener);
        multiplication.addActionListener(listener);


        ce.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                var1String = "";
                textField.setText(var1String);
                decPressed = false;
                actPressed = false;
                addPressed = false;
                minusPressed = false;
                divPressed = false;
                multPressed = false;
            }
        });

        decimal.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (decPressed != true) {
                    var1String += ".";
                }
                decPressed = true;

            }
        });

        equals.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (addPressed) {
                    result += Double.parseDouble(var1String);
                    Object obj = new Object();
                    obj = (Object) result;
                    textField.setText(obj.toString());
                    actPressed = true;
                    var1String = "0";
                } else if (minusPressed) {
                    result -= Double.parseDouble(var1String);
                    Object obj = new Object();
                    obj = (Object) result;
                    textField.setText(obj.toString());
                    actPressed = true;
                    var1String = "0";
                } else if (divPressed) {
                    result /= Double.parseDouble(var1String);
                    Object obj = new Object();
                    obj = (Object) result;
                    textField.setText(obj.toString());
                    actPressed = true;
                    var1String = "1";
                } else if (multPressed) {
                    result *= Double.parseDouble(var1String);
                    Object obj = new Object();
                    obj = (Object) result;
                    textField.setText(obj.toString());
                    actPressed = true;
                    var1String = "1";
                }
            }
        });

        otherPanel.add(textField);
        otherPanel.add(buttonPanel);
        buttonPanel.add(num1);
        buttonPanel.add(num2);
        buttonPanel.add(num3);
        buttonPanel.add(num4);
        buttonPanel.add(num5);
        buttonPanel.add(num6);
        buttonPanel.add(num7);
        buttonPanel.add(num8);
        buttonPanel.add(num9);
        buttonPanel.add(num0);
        buttonPanel.add(ce);
        buttonPanel.add(decimal);
        sidePanel.add(addition);
        sidePanel.add(minus);
        sidePanel.add(division);
        sidePanel.add(multiplication);
        bottomPanel.add(equals);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(sidePanel, BorderLayout.EAST);
        mainPanel.add(otherPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public static void main(String[] args) {
        Calculator frame = new Calculator();
        frame.setTitle("Calculator");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public class Button implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "1") {
                var1String += "1";
            } else if (e.getActionCommand() == "2") {
                var1String += "2";
            } else if (e.getActionCommand() == "3") {
                var1String += "3";
            } else if (e.getActionCommand() == "4") {
                var1String += "4";
            } else if (e.getActionCommand() == "5") {
                var1String += "5";
            } else if (e.getActionCommand() == "6") {
                var1String += "6";
            } else if (e.getActionCommand() == "7") {
                var1String += "7";
            } else if (e.getActionCommand() == "8") {
                var1String += "8";
            } else if (e.getActionCommand() == "9") {
                var1String += "9";
            } else if (e.getActionCommand() == "0") {
                var1String += "0";
            }

            textField.setText(var1String);
        }
    }

    public class Calculate implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (actPressed != true) {
                if (e.getActionCommand() == "+") {
                    result = Double.parseDouble(var1String);
                    textField.setText(var1String);
                    var1String = "";
                    actPressed = true;
                    addPressed = true;

                } else if (e.getActionCommand() == "-") {
                    result = Double.parseDouble(var1String);
                    textField.setText(var1String);
                    var1String = "";
                    actPressed = true;
                    minusPressed = true;
                } else if (e.getActionCommand() == "/") {
                    result = Double.parseDouble(var1String);
                    textField.setText(var1String);
                    var1String = "";
                    actPressed = true;
                    divPressed = true;
                } else if (e.getActionCommand() == "*") {
                    result = Double.parseDouble(var1String);
                    textField.setText(var1String);
                    var1String = "";
                    actPressed = true;
                    multPressed = true;
                }

            } else {
                if (e.getActionCommand() == "+") {
                    result += Double.parseDouble(var1String);
                    var1String = "";
                    Object obj = new Object();
                    obj = (Object) result;
                    textField.setText(obj.toString());
                    addPressed = true;
                } else if (e.getActionCommand() == "-") {
                    result -= Double.parseDouble(var1String);
                    var1String = "";
                    Object obj = new Object();
                    obj = (Object) result;
                    textField.setText(obj.toString());
                    minusPressed = true;
                } else if (e.getActionCommand() == "/") {
                    result /= Double.parseDouble(var1String);
                    var1String = "";
                    Object obj = new Object();
                    obj = (Object) result;
                    textField.setText(obj.toString());
                    divPressed = true;
                } else if (e.getActionCommand() == "*") {
                    result *= Double.parseDouble(var1String);
                    var1String = "";
                    Object obj = new Object();
                    obj = (Object) result;
                    textField.setText(obj.toString());
                    multPressed = true;

                }
            }

        }
    }
}