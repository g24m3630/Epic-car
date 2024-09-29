    public class Account {
    private String accHolder;
    private String accNumber;
    private double balance;

    public Account(String accNumber, String accHolder, double balance) {
        this.accNumber = accNumber;
        this.accHolder = accHolder;
        this.balance = balance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) throws Exception {
        if (balance >= amt) {
            balance -= amt;
            System.out.println("WITHDRAWAL WAS A SUCCESS");
        } else {
            System.err.println("YOU HAVE Insufficient balance");
        }
    }

    public String getAccNumber() {
        return accNumber;
    }

    public String getAccHolder() {
        return accHolder;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "accHolder > " + accHolder + '\'' +", accNumber > " + accNumber + '\'' +", balance > " + balance ;
    }
}