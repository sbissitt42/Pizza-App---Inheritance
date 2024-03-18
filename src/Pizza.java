public class Pizza {
    private String[] toppings;
    private double price;
    public double getPrice() {
        return price;
    }

    public Pizza(String[] toppings, int numberOfToppings) {
        if (numberOfToppings > 10) {
            throw new IllegalArgumentException("Exceeded maximum number of toppings (10)");
        }

        this.toppings = new String[numberOfToppings];
        System.arraycopy(toppings, 0, this.toppings, 0, numberOfToppings);

        // Create a description with comma-separated toppings
        StringBuilder descriptionBuilder = new StringBuilder();
        for (int i = 0; i < numberOfToppings; i++) {
            descriptionBuilder.append(toppings[i]);
            if (i < numberOfToppings - 1) {
                descriptionBuilder.append(", ");
            }
        }

        // Set the price at $14 plus $2 for each topping
        this.price = 14 + 2 * numberOfToppings;
    }

    public String toString() {
        return "Pizza with toppings: " + String.join(", ", toppings) + "\nPrice: $" + price;
    }

    public static void main(String[] args) {
        // Example usage
        String[] pizzaToppings = {"Pepperoni", "Mushrooms", "Onions"};
        Pizza pizza = new Pizza(pizzaToppings, pizzaToppings.length);
        System.out.println(pizza);
    }
}
