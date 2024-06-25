package Appointmentsystem_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventorySupplyWindow {
    private JFrame frame;
    private JPanel panel;
    private JTable inventoryTable1;
    private JTable inventoryTable2;
    private JTable inventoryTable3;
    private JTable inventoryTable4;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane3;
    private JScrollPane scrollPane4;

    public InventorySupplyWindow() {
        // Create the frame
        frame = new JFrame("Dental Inventory Supply");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setResizable(false);

        // Create the panel
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        // Add Operatory Equipment label
        JLabel titleLabel1 = new JLabel("Operatory Equipment", SwingConstants.CENTER);
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel1);

        // Column names
        String[] columnNames = {
                "Item", "Quantity on Hand", "Unit Cost", "Total Cost"
        };

        // Inventory data for the first table
        Object[][] data1 = {
                {"Dental Chairs", "", "", ""},
                {"Operating Units", "", "", ""},
                {"Amalgamators", "", "", ""},
                {"Handpieces", "", "", ""},
                {"Autoclaves/Sterilizers", "", "", ""},
                {"Compressors", "", "", ""},
                {"Cabinets", "", "", ""},
                {"Operating Lights", "", "", ""},
                {"Assistant Stools", "", "", ""},
                {"Operating Stools", "", "", ""},
                {"Oral Evacuator System", "", "", ""},
                {"Intra-Oral Camera", "", "", ""},
                {"X-Ray Equipment", "", "", ""}
        };

        // Create first table
        inventoryTable1 = new JTable(data1, columnNames);
        scrollPane1 = new JScrollPane(inventoryTable1);

        // Add scroll pane to panel
        panel.add(scrollPane1);

        // Add another label for the second table
        JLabel titleLabel2 = new JLabel("Laboratory Equipment", SwingConstants.CENTER);
        titleLabel2.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel2);

        // Inventory data for the second table
        Object[][] data2 = {
                {"Model Trimmers", "", "", ""},
                {"Polishing Equipment", "", "", ""},
                {"Plaster Dispenser", "", "", ""},
                {"Vacuum Forming Machine", "", "", ""},
                {"Porcelain Oven", "", "", ""}
        };

        // Create second table
        inventoryTable2 = new JTable(data2, columnNames);
        scrollPane2 = new JScrollPane(inventoryTable2);

        // Add scroll pane to panel
        panel.add(scrollPane2);

        // Add another label for the third table
        JLabel titleLabel3 = new JLabel("Dental Supplies", SwingConstants.CENTER);
        titleLabel3.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel3);

        // Inventory data for the third table
        Object[][] data3 = {
                {"Gloves", "", "", ""},
                {"Masks", "", "", ""},
                {"Disinfectants", "", "", ""},
                {"Cotton Rolls", "", "", ""},
                {"Impression Materials", "", "", ""}
        };

        // Create third table
        inventoryTable3 = new JTable(data3, columnNames);
        scrollPane3 = new JScrollPane(inventoryTable3);

        // Add scroll pane to panel
        panel.add(scrollPane3);

        // Add another label for the fourth table
        JLabel titleLabel4 = new JLabel("Safety Equipment", SwingConstants.CENTER);
        titleLabel4.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel4.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel4);

        // Inventory data for the fourth table
        Object[][] data4 = {
                {"Eye Protection", "", "", ""},
                {"Face Shields", "", "", ""},
                {"Sharps Containers", "", "", ""},
                {"Biohazard Bins", "", "", ""}
        };

        // Create fourth table
        inventoryTable4 = new JTable(data4, columnNames);
        scrollPane4 = new JScrollPane(inventoryTable4);

        // Add scroll pane to panel
        panel.add(scrollPane4);

        // Add close button
        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Create a panel for the button and add it to the main panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(closeButton);
        panel.add(buttonPanel);

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventorySupplyWindow::new);
    }
}
