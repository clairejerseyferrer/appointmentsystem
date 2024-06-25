package Appointmentsystem_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class BillingPaymentWindow {
    private JFrame frame;
    private JPanel panel;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField contactNumberField;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> dayComboBox;
    private JComboBox<String> yearComboBox;
    private JTextField recipientField;
    private JTextField referenceNumberField;
    private JButton addButton;
    private JTextArea paymentList;
    private static AtomicInteger referenceCounter = new AtomicInteger(10001); // Initialize reference number counter

    public BillingPaymentWindow() {
        // Create the frame
        frame = new JFrame("Billing and Payment Window");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setResizable(false);

        // Create the panel
        panel = new JPanel(new BorderLayout());
        frame.add(panel);

        // Create input fields and labels
        nameField = new JTextField(20);
        addressField = new JTextField(20);
        contactNumberField = new JTextField(20);
        recipientField = new JTextField(20);

        // Date combo boxes
        monthComboBox = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"});
        dayComboBox = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30", "31"});
        yearComboBox = new JComboBox<>(new String[]{"2023", "2024", "2025"});

        // Reference number field (read-only)
        referenceNumberField = new JTextField(20);
        referenceNumberField.setText(String.valueOf(referenceCounter.get()));
        referenceNumberField.setEditable(false);

        // Create a button to add the payment
        addButton = new JButton("Add Payment");

        // Text area to display payments
        paymentList = new JTextArea(20, 50);
        paymentList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(paymentList);

        // Panel for input fields and labels
        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 10, 10)); // Adjust gaps between components
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        inputPanel.add(new JLabel("Patient's Name: "));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Patient's Address: "));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Contact Number: "));
        inputPanel.add(contactNumberField);
        inputPanel.add(new JLabel("Date of Payment: "));
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Panel for date components
        datePanel.add(monthComboBox);
        datePanel.add(dayComboBox);
        datePanel.add(yearComboBox);
        inputPanel.add(datePanel);
        inputPanel.add(new JLabel("Recipient: "));
        inputPanel.add(recipientField);
        inputPanel.add(new JLabel("Reference Number: "));
        inputPanel.add(referenceNumberField);
        inputPanel.add(new JLabel()); // Placeholder for alignment
        inputPanel.add(addButton);

        // Add components to main panel
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add action listener to the button
        addButton.addActionListener(e -> addPayment());

        // Make the frame visible
        frame.setVisible(true);
    }

    private void addPayment() {
        String name = nameField.getText().trim();
        String address = addressField.getText().trim();
        String contactNumber = contactNumberField.getText().trim();
        String month = (String) monthComboBox.getSelectedItem();
        String day = (String) dayComboBox.getSelectedItem();
        String year = (String) yearComboBox.getSelectedItem();
        String recipient = recipientField.getText().trim();
        String referenceNumber = referenceNumberField.getText();

        // Validate input fields
        if (name.isEmpty() || address.isEmpty() || contactNumber.isEmpty() || recipient.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Construct payment date
        String paymentDate = String.format("%s %s, %s", month, day, year);
        String paymentDetails = String.format("Patient's Name: %s\nAddress: %s\nContact Number: %s\nDate of Payment: %s\nRecipient: %s\nReference Number: %s\n\n",
                name, address, contactNumber, paymentDate, recipient, referenceNumber);

        // Append payment details to the text area
        paymentList.append(paymentDetails);

        // Update reference number for next payment
        referenceNumberField.setText(String.valueOf(referenceCounter.incrementAndGet()));

        // Clear input fields after adding the payment
        nameField.setText("");
        addressField.setText("");
        contactNumberField.setText("");
        recipientField.setText("");

        JOptionPane.showMessageDialog(frame, "Payment added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new BillingPaymentWindow();
    }
}
