import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class for the Pizza Order application
public class DemoPizza {
    // Constant for quitting
    private static final String QUIT = "QUIT";

    // Main method
    public static void main(String[] args) {
        // SwingUtilities.invokeLater ensures the GUI components are created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create the main JFrame
            JFrame frame = new JFrame("Pizza Order");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null); // Center the frame on the screen

            // Create a panel to hold the components
            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel); // Place components on the panel

            frame.setVisible(true); // Make the frame visible
        });
    }

    // Method to place components on the panel
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null); // Use null layout for manual component positioning

        // Label for entering toppings
        JLabel toppingsLabel = new JLabel("Enter pizza toppings (type QUIT to finish or max 10 toppings):");
        toppingsLabel.setBounds(10, 20, 350, 25); // Set position and size
        panel.add(toppingsLabel); // Add label to the panel

        // Text field for entering toppings
        JTextField toppingsTextField = new JTextField(20);
        toppingsTextField.setBounds(10, 50, 200, 25); // Set position and size
        panel.add(toppingsTextField); // Add text field to the panel

        // Button for adding toppings
        JButton addButton = new JButton("Add Topping");
        addButton.setBounds(220, 50, 150, 25); // Set position and size
        panel.add(addButton); // Add button to the panel

        // Checkbox for selecting delivery
        JCheckBox deliveryCheckBox = new JCheckBox("Delivery");
        deliveryCheckBox.setBounds(10, 80, 150, 25); // Set position and size
        panel.add(deliveryCheckBox); // Add checkbox to the panel

        // Label for entering delivery address
        JLabel addressLabel = new JLabel("Delivery Address:");
        addressLabel.setBounds(10, 110, 150, 25); // Set position and size
        panel.add(addressLabel); // Add label to the panel

        // Text field for entering delivery address
        JTextField addressTextField = new JTextField(20);
        addressTextField.setBounds(130, 110, 200, 25); // Set position and size
        panel.add(addressTextField); // Add text field to the panel

        // Button for submitting order
        JButton submitButton = new JButton("Submit Order");
        submitButton.setBounds(10, 140, 150, 25); // Set position and size
        panel.add(submitButton); // Add button to the panel

        // Text area for displaying order details
        JTextArea resultTextArea = new JTextArea();
        resultTextArea.setBounds(10, 180, 350, 70); // Set position and size
        resultTextArea.setEditable(false); // Make the text area read-only
        panel.add(resultTextArea); // Add text area to the panel

        // ActionListener for the Add Topping button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topping = toppingsTextField.getText().trim();
                if (!topping.isEmpty() && numberOfToppings < 10) {
                    toppings[numberOfToppings++] = topping;
                    toppingsTextField.setText(""); // Clear the text field
                }
            }
        });

        // ActionListener for the Submit Order button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isDelivery = deliveryCheckBox.isSelected(); // Check if delivery is selected
                String deliveryAddress = addressTextField.getText().trim(); // Get delivery address

                if (isDelivery) {
                    // Create a DeliveryPizza object if delivery is selected
                    DeliveryPizza deliveryPizza = new DeliveryPizza(toppings, deliveryAddress, numberOfToppings);
                    resultTextArea.setText(deliveryPizza.toString()); // Display order details
                } else {
                    // Create a Pizza object if delivery is not selected
                    Pizza pizza = new Pizza(toppings, numberOfToppings);
                    resultTextArea.setText(pizza.toString()); // Display order details
                }
            }
        });
    }

    // Array to store toppings
    private static String[] toppings = new String[10];
    // Counter for the number of toppings
    private static int numberOfToppings = 0;
}
