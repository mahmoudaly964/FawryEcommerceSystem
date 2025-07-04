public interface ShippingStrategy {
    boolean isNeedShipping();
    Shippable getShippable();
}
