public class Product {
    private  String name;
    private  int quantity;
    private double price;
    private ExpirationStrategy expirationStrategy;
    private ShippingStrategy shippingStrategy;
    public Product(String name, int quantity, double price,ExpirationStrategy expirationStrategy, ShippingStrategy shippingStrategy)
    {
        setName(name);
        setQuantity(quantity);
        setPrice(price);
        setExpirationStrategy(expirationStrategy);
        setShippingStrategy(shippingStrategy);
    }
    public String getName()
    {
        return name;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public double getPrice()
    {
        return price;
    }
    public boolean isExpired()
    {
        return expirationStrategy.isExpired();
    }
    public boolean isNeedShipping()
    {
        return shippingStrategy.isNeedShipping();
    }
    public Shippable getShippable()
    {
        return shippingStrategy.getShippable();
    }
    public double getWeight()
    {
        if(shippingStrategy.getShippable() == null) {
            return 0.0;
        }
        return shippingStrategy.getShippable().getWeight();
    }
    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }
    public void setQuantity(int quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }
    // to change the price if needed
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
    public void setExpirationStrategy(ExpirationStrategy expirationStrategy) {
        if (expirationStrategy == null) {
            throw new IllegalArgumentException("Expiration strategy cannot be null");
        }
        this.expirationStrategy = expirationStrategy;
    }
    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        if (shippingStrategy == null) {
            throw new IllegalArgumentException("Shipping strategy cannot be null");
        }
        this.shippingStrategy = shippingStrategy;
    }
    public void reduceQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (amount > quantity) {
            throw new IllegalArgumentException("Amount exceeds available quantity");
        }
        this.quantity -= amount;
    }

}
