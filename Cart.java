import java.util.*;

public class Cart {
    private List<CartItem> items;
    private double totalPrice;
    public Cart() {
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }
    public void addItem(Product product, int quantity) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if(quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock");
        }
        CartItem item = new CartItem(product, quantity);
        items.add(item);
        totalPrice += product.getPrice() * quantity;
    }
    public List<CartItem> getItems() {
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public double getTotalPrice() {
        return totalPrice;
    }   
    
}
