package Appointmentsystem_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffManagementWindow extends JFrame {

    // Constructor to setup the GUI components
    public StaffManagementWindow() {
        setTitle("Staff Management");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel to hold the staff management components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Label
        JLabel label = new JLabel("Staff Management");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        // Text field for staff name
        JTextField staffNameField = new JTextField(20);
        staffNameField.setMaximumSize(staffNameField.getPreferredSize());
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between components
        panel.add(new JLabel("Staff Name:"));
        panel.add(staffNameField);

        // Text field for staff role
        JTextField staffRoleField = new JTextField(20);
        staffRoleField.setMaximumSize(staffRoleField.getPreferredSize());
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between components
        panel.add(new JLabel("Staff Role:"));
        panel.add(staffRoleField);

        // Text field for staff ID
        JTextField staffIdField = new JTextField(20);
        staffIdField.setMaximumSize(staffIdField.getPreferredSize());
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between components
        panel.add(new JLabel("Staff ID:"));
        panel.add(staffIdField);

        // Buttons for add, edit, and delete
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement add staff logic here
                String staffName = staffNameField.getText();
                String staffRole = staffRoleField.getText();
                String staffId = staffIdField.getText();
                // Logic to add staff to the system
                JOptionPane.showMessageDialog(null, "Staff added: " + staffName);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement edit staff logic here
                String staffName = staffNameField.getText();
                String staffRole = staffRoleField.getText();
                String staffId = staffIdField.getText();
                // Logic to edit staff in the system
                JOptionPane.showMessageDialog(null, "Staff edited: " + staffName);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement delete staff logic here
                String staffId = staffIdField.getText();
                // Logic to delete staff from the system
                JOptionPane.showMessageDialog(null, "Staff deleted with ID: " + staffId);
            }
        });

        // Panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // Add panels to the frame
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StaffManagementWindow();
    }
}
