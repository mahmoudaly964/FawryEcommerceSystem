public class Customer {
    private String name;
    private String phoneNumber;
    private double balance;

    public Customer(String name,String phoneNumber, double balance) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setBalance(balance);
    }

    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public double getBalance() {
        return balance;
    }
    void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }
    void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        this.phoneNumber = phoneNumber;
    }
    void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be greater than or equal to zero");
        }
        this.balance = balance;
    }
    //Assumptions: assume customer can add balance to his account
    public void addBalance(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount added must be greater than or equal to zero");
        }
        this.balance += amount;
    }
    public void removeBalance(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount reduced must be greater than or equal to zero");
        }
        //double check on the balance
        //Assumptions: assume customer can't have a negative balance
        if (this.balance < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
    }
    
}
