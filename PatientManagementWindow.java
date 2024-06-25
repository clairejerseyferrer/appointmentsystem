package Appointmentsystem_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PatientManagementWindow extends JFrame implements ActionListener {

    private ArrayList<Patient> patients;
    private JList<String> patientList;
    private DefaultListModel<String> listModel;
    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> serviceComboBox;
    private JComboBox<String> paymentStatusComboBox;
    private JComboBox<String> appointmentStatusComboBox;
    private JButton addButton;
    private JButton removeButton;

    public PatientManagementWindow() {
        setTitle("Patient Management");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        patients = new ArrayList<>();
        listModel = new DefaultListModel<>();
        patientList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(patientList);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2, 5, 5));

        nameField = new JTextField(20);
        ageField = new JTextField(20);
        serviceComboBox = new JComboBox<>(new String[]{
                "Root Canal Treatment",
                "Cosmetic Dentistry",
                "Dental Crown",
                "Tooth Whitening",
                "Dental Implants",
                "Dental Bridge",
                "Periodontics",
                "Denture"
        });

        paymentStatusComboBox = new JComboBox<>(new String[]{
                "Pending",
                "Paid",
        });

        appointmentStatusComboBox = new JComboBox<>(new String[]{
                "Pending",
                "Done",
        });

        addButton = new JButton("Add Patient");
        removeButton = new JButton("Remove Patient");

        addButton.addActionListener(this);
        removeButton.addActionListener(this);

        inputPanel.add(new JLabel("Patient Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Service Chosen:"));
        inputPanel.add(serviceComboBox);
        inputPanel.add(new JLabel("Payment Status:"));
        inputPanel.add(paymentStatusComboBox);
        inputPanel.add(new JLabel("Appointment Status:"));
        inputPanel.add(appointmentStatusComboBox);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        add(listScrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText().trim();
            String age = ageField.getText().trim();
            String service = (String) serviceComboBox.getSelectedItem();
            String paymentStatus = (String) paymentStatusComboBox.getSelectedItem();
            String appointmentStatus = (String) appointmentStatusComboBox.getSelectedItem();

            if (!name.isEmpty() && !age.isEmpty() && service != null && !paymentStatus.isEmpty() && !appointmentStatus.isEmpty()) {
                Patient patient = new Patient(name, age, service, paymentStatus, appointmentStatus);
                patients.add(patient);
                listModel.addElement(patient.toString());
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == removeButton) {
            int selectedIndex = patientList.getSelectedIndex();
            if (selectedIndex != -1) {
                patients.remove(selectedIndex);
                listModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a patient to remove", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        serviceComboBox.setSelectedIndex(0);
        paymentStatusComboBox.setSelectedIndex(0);
        appointmentStatusComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new PatientManagementWindow();
    }
}

class Patient {
    private String name;
    private String age;
    private String service;
    private String paymentStatus;
    private String appointmentStatus;

    public Patient(String name, String age, String service, String paymentStatus, String appointmentStatus) {
        this.name = name;
        this.age = age;
        this.service = service;
        this.paymentStatus = paymentStatus;
        this.appointmentStatus = appointmentStatus;
    }

    @Override
    public String toString() {
        return name + " - Age: " + age + ", Service: " + service + ", Payment: " + paymentStatus + ", Appointment: " + appointmentStatus;
    }
}