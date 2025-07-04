public class NonExpirableProduct implements ExpirationStrategy {
    public boolean isExpired() {
        return false; 
    }
    
}
