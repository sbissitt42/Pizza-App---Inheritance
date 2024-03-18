public class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;

    public double getPrice() {
        return super.getPrice() + deliveryFee;
    }

    public DeliveryPizza(String[] toppings, String deliveryAddress, int numberOfToppings) {
        super(toppings, numberOfToppings);

        // Set the delivery address
        this.deliveryAddress = deliveryAddress;

        // Calculate the delivery fee based on the total pizza cost
        if (getPrice() > 18) {
            this.deliveryFee = 3;
        } else {
            this.deliveryFee = 5;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nDelivery Address: " + deliveryAddress + "\nDelivery Fee: $" + deliveryFee;
    }

    public static void main(String[] args) {
        // Example usage
        String[] pizzaToppings = {"Pepperoni", "Mushrooms", "Onions"};
        String deliveryAddress = "123 Main St, City";
        DeliveryPizza deliveryPizza = new DeliveryPizza(pizzaToppings, deliveryAddress, pizzaToppings.length);
        System.out.println(deliveryPizza);
    }
}
