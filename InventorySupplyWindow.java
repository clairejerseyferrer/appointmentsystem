package Appointmentsystem_package;

import javax.swing.*;
import java.awt.*;

public class InventorySupplyWindow {
    private JFrame frame;
    private JPanel panel;
    private JTable inventoryTable;
    private JScrollPane scrollPane;

    public InventorySupplyWindow() {
        // Create the frame
        frame = new JFrame("Dental Inventory Checklist");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setResizable(false);

        // Create the panel
        panel = new JPanel(new BorderLayout());
        frame.add(panel);

        // Column names
        String[] columnNames = {
                "Item", "Quantity on Hand", "Unit Cost", "Total Cost",
                "Reorder Level", "Last Order Date", "Last Order Quantity"
        };

        // Inventory data based on the images provided
        Object[][] data = {
                {"Dental Chairs", "", "", "", "", "", ""},
                {"Operating Units", "", "", "", "", "", ""},
                {"Amalgamators", "", "", "", "", "", ""},
                {"Handpieces", "", "", "", "", "", ""},
                {"Autoclaves/Sterilizers", "", "", "", "", "", ""},
                {"Compressors", "", "", "", "", "", ""},
                {"Cabinets", "", "", "", "", "", ""},
                {"Operating Lights", "", "", "", "", "", ""},
                {"Assistant Stools", "", "", "", "", "", ""},
                {"Operating Stools", "", "", "", "", "", ""},
                {"Oral Evacuator System", "", "", "", "", "", ""},
                {"Intra-Oral Camera", "", "", "", "", "", ""},
                {"X-Ray Equipment", "", "", "", "", "", ""},
                {"Model Trimmers", "", "", "", "", "", ""},
                {"Polishing Equipment", "", "", "", "", "", ""},
                {"Plaster Dispenser", "", "", "", "", "", ""},
                {"Vacuum Forming Machine", "", "", "", "", "", ""},
                {"Porcelain Oven", "", "", "", "", "", ""},
                {"Gloves", "", "", "", "", "", ""},
                {"Masks", "", "", "", "", "", ""},
                {"Disinfectants", "", "", "", "", "", ""},
                {"Cotton Rolls", "", "", "", "", "", ""},
                {"Impression Materials", "", "", "", "", "", ""}
        };

        // Create table
        inventoryTable = new JTable(data, columnNames);
        scrollPane = new JScrollPane(inventoryTable);

        // Add scroll pane to panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventorySupplyWindow::new);
    }
}
