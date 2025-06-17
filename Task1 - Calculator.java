import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField input1, input2;
    JButton addBtn, subBtn, mulBtn, divBtn;
    JLabel resultLabel;

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Panel for inputs
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Enter first number:"));
        input1 = new JTextField();
        panel.add(input1);

        panel.add(new JLabel("Enter second number:"));
        input2 = new JTextField();
        panel.add(input2);

        // Buttons for operations
        addBtn = new JButton("Add");
        subBtn = new JButton("Subtract");
        mulBtn = new JButton("Multiply");
        divBtn = new JButton("Divide");

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);

        panel.add(addBtn);
        panel.add(subBtn);
        panel.add(mulBtn);
        panel.add(divBtn);

        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        add(panel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            double result = 0;

            if (e.getSource() == addBtn) {
                result = num1 + num2;
            } else if (e.getSource() == subBtn) {
                result = num1 - num2;
            } else if (e.getSource() == mulBtn) {
                result = num1 * num2;
            } else if (e.getSource() == divBtn) {
                if (num2 == 0) {
                    resultLabel.setText("Error: Division by zero");
                    return;
                }
                result = num1 / num2;
            }

            resultLabel.setText("Result: " + result);

        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculator().setVisible(true);
        });
    }
}
