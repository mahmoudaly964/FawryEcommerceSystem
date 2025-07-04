public class ShippableProduct implements Shippable, ShippingStrategy {
    private  String name;
    private  double weight;

    public ShippableProduct(String name, double weight) {
        setName(name);
        setWeight(weight);
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }
    public void setWeight(double weight) {
        if(weight < 0) {
            throw new IllegalArgumentException("Weight must be greater than or equal to zero");
        }
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isNeedShipping() {
        return true; 
    }
    @Override
    public Shippable getShippable() {
        return this; 
    }
}
