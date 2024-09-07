public abstract class Account {
    private double balance;

    // default/no-args constructor
    public Account() {
        this.balance = 0;
    }

    // args constructor
    public Account(double _balance) {
        this.balance = _balance;
    }

    // copy constructor (creates a duplicate object)
    public Account(Account act) {
        this.balance = act.balance;
    }

    // Getter/Accessor
    public double getBalance() {
        return this.balance;
    }

    // Setter/Mutator
    public void setBalance(double _balance) {
        this.balance = _balance;
    }

    // abstract method (must be declared for any child classes
    public abstract boolean deposit(double _amount);

    public abstract boolean withdraw(double _amount);
}
