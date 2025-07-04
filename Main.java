import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Test Case 1: all products are non shippable");
        runTest(cart -> {
            cart.addItem(createScratchCard(), 2);
        }, createCustomer("Ali", 200));

        System.out.println("Test Case 2: shippable products with no expiration");
        runTest(cart -> {
            cart.addItem(createTV(), 1);
        }, createCustomer("Mahmoud", 6000));

        System.out.println("Test Case 3: mixed shippable and non shippable =====");
        runTest(cart -> {
            cart.addItem(createCheese(), 2);
            cart.addItem(createBiscuits(), 1);
            cart.addItem(createScratchCard(), 1);
        }, createCustomer("Zakaria", 1000));

        System.out.println("Test Case 4: empty Cart");
        runTest(cart -> {
        }, createCustomer("Samir", 500));

        System.out.println("Test Case 5: expired product");
        runTest(cart -> {
            cart.addItem(createExpiredMilk(), 1);
        }, createCustomer("Farouq", 100));

        System.out.println("Test Case 6: insufficient quantity");
        runTest(cart -> {
            cart.addItem(createCheese(), 100);
        }, createCustomer("Ahmed", 5000));

        System.out.println("Test Case 7: insufficient balance");
        runTest(cart -> {
            cart.addItem(createTV(), 1);
        }, createCustomer("Mohammed", 10));

        System.out.println("Test Case 8: exact balance");
        runTest(cart -> {
            cart.addItem(createCheese(), 2);
            cart.addItem(createBiscuits(), 1);
            cart.addItem(createScratchCard(), 1);
        }, createCustomer("saber", 430));

        System.out.println("Test Case 9: out of stock product");
        runTest(cart -> {
            cart.addItem(createZeroStockItem(), 1);
        }, createCustomer("soliman", 1000));
    }

    static Product createCheese() {
        return new Product("cheese", 5, 100,
                new ExpirableProduct(LocalDate.now().plusDays(2)),
                new ShippableProduct("cheese", 0.2));
    }

    static Product createBiscuits() {
        return new Product("biscuits", 3, 150,
                new ExpirableProduct(LocalDate.now().plusDays(5)),
                new ShippableProduct("biscuits", 0.7));
    }

    static Product createTV() {
        return new Product("TV", 2, 5000,
                new NonExpirableProduct(),
                new ShippableProduct("TV", 10.0));
    }

    static Product createScratchCard() {
        return new Product("scratchCard", 10, 50,
                new NonExpirableProduct(),
                new NonShippableProduct());
    }

    static Product createExpiredMilk() {
        return new Product("milk", 5, 20,
                // Assuming the expiration date is in the past
                // don't validate the expiration date for simplicity when test cases are run
                new ExpirableProduct(LocalDate.now().minusDays(1)),
                new ShippableProduct("Milk", 1.0));
    }

    static Product createZeroStockItem() {
        return new Product("empty", 0, 999,
                new NonExpirableProduct(),
                new NonShippableProduct());
    }

    static Customer createCustomer(String name, double balance) {
        return new Customer(name, "0000000000", balance);
    }
    // i make this interface to separate each test case to avoid the problems
    interface CartAction {
        void add(Cart cart);
    }

    static void runTest(CartAction cartSetup, Customer customer) {
        Cart cart = new Cart();
        try {
            cartSetup.add(cart);
            Checkout.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println();
    }
}
