import java.util.*;

public class Checkout {
    private static double shippingPrice=30;// assuming a fixed shipping price
    public static void checkout(Customer customer, Cart cart) {
        double subTotal=0.0;
        List<Shippable> shippingItems = new ArrayList<>();
        if(cart.isEmpty()){
            throw new IllegalArgumentException("Cart is empty");
        }
        for(CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if(product.isExpired()) {
                throw new IllegalArgumentException("Product :"+product.getName()+" is expired");
            }
            if(product.getQuantity() < item.quantity) {
                throw new IllegalArgumentException("Not enough stock for product: " + product.getName());
            }
            if(product.isNeedShipping()) {
                if(product.getShippable() != null) {
                    for(int i = 0; i < item.quantity; i++) {
                        shippingItems.add(product.getShippable());
                    }
                } 
                
            }
        }
        subTotal = cart.getTotalPrice();
        double totalPrice = subTotal;
        if(!shippingItems.isEmpty()) {
            totalPrice += shippingPrice;
        }
        if(customer.getBalance() < totalPrice) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        if (!shippingItems.isEmpty())
            ShippingService.ship(shippingItems);
        System.out.println("** Checkout receipt **");
        //for reducing quantity don't make it in the first loop because if some product is not available it will throw an exception and the quantity will be reduced
        // although the checkout process is not completed
        for(CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.quantity;
            product.reduceQuantity(quantity);
            System.out.println(quantity + "x " + product.getName() +"--------"+ "Price: " + product.getPrice()*quantity );
        }
        customer.removeBalance(totalPrice);
        System.out.println("----------------");
        System.out.println("Subtotal: " + subTotal);
        System.out.println("Shipping Price: " + (shippingItems.isEmpty() ? 0 : shippingPrice));
        System.out.println("Amount: " + totalPrice);
        System.out.println("Balance after payment: " + customer.getBalance());
        

    }

    }


