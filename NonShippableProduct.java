public class NonShippableProduct implements ShippingStrategy {
    @Override
    public boolean isNeedShipping() {
        return false; 
    }
    @Override
    public Shippable getShippable() {
        return null;
    }
}
