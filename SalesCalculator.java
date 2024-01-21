import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesCalculator extends JFrame {

    private JTextField phonePriceField, phoneQuantityField, repairPriceField, repairHoursField;
    private JTextArea resultArea;

    public SalesCalculator() {
        setTitle("Sales Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel phoneLabel = new JLabel("Phones");
        JLabel phonePriceLabel = new JLabel("Price:");
        JLabel phoneQuantityLabel = new JLabel("Quantity sold:");

        JLabel repairLabel = new JLabel("Repair Services");
        JLabel repairPriceLabel = new JLabel("Price per hour:");
        JLabel repairHoursLabel = new JLabel("Number of hours:");

        phonePriceField = new JTextField();
        phoneQuantityField = new JTextField();
        repairPriceField = new JTextField();
        repairHoursField = new JTextField();

        JButton calculateButton = new JButton("Calculate");
        resultArea = new JTextArea();

        // Set layout
        setLayout(new GridLayout(7, 2, 5, 5));

        // Add components to the JFrame
        add(phoneLabel);
        add(new JLabel()); // Placeholder for alignment
        add(phonePriceLabel);
        add(phonePriceField);
        add(phoneQuantityLabel);
        add(phoneQuantityField);

        add(repairLabel);
        add(new JLabel()); // Placeholder for alignment
        add(repairPriceLabel);
        add(repairPriceField);
        add(repairHoursLabel);
        add(repairHoursField);

        add(new JLabel()); // Placeholder for alignment
        add(calculateButton);
        add(new JLabel()); // Placeholder for alignment
        add(resultArea);

        // Set up button action listener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSales();
            }
        });
    }

    private void calculateSales() {
        try {
            double phonePrice = Double.parseDouble(phonePriceField.getText());
            int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());

            double repairPrice = Double.parseDouble(repairPriceField.getText());
            int repairHours = Integer.parseInt(repairHoursField.getText());

            double phoneTotalSales = phonePrice * phoneQuantity;
            double repairTotalSales = repairPrice * repairHours;

            resultArea.setText("Total Sales:\nPhones: ₱" + phoneTotalSales + "\nRepair Services: ₱" + repairTotalSales);
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter numeric values for prices and quantities.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SalesCalculator().setVisible(true);
            }
        });
    }
}
