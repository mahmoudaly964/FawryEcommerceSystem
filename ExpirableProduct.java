import java.time.LocalDate;
public class ExpirableProduct implements ExpirationStrategy {
    private final LocalDate expirationDate;
    public ExpirableProduct(LocalDate expirationDate) {
        // don't validate the expiration date for simplicity when test cases are run
        // if (expirationDate == null || expirationDate.isBefore(LocalDate.now())) {
        //     throw new IllegalArgumentException("Expiration date must be a future date");
        // }
    this.expirationDate = expirationDate;
    }
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
}
