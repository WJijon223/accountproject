public class CreditAccount extends Account {
    // credit limit will be created
    private double limit;
    private double usedLimit;

    public CreditAccount(double limit) {
        super();
        this.limit = limit;
        this.usedLimit = 0;
    }

    // setters and getters for used limit and limit
    public void setUsedLimit(double amount) {
        this.usedLimit = amount;
    }

    public double getUsedLimit() {
        return this.usedLimit;
    }

    public double getLimit() {
        return this.limit;
    }

    // Override the deposit method
    // Add logic where deposits bring credit limit back down
    @Override
    public boolean deposit(double _amount) {
        if (_amount <= 0) {
            System.out.println("Invalid amount. Try again");
            return false;
        } else if (getUsedLimit() - _amount <= 0) {
            this.usedLimit = 0;
        } else {
            setUsedLimit(getUsedLimit() - _amount);
        }
        setBalance(getBalance() + _amount);
        return true;
    }

    // Override withdrawal method
    // Add conditional statement to ensure credit limit does not exceed
    @Override
    public boolean withdraw(double _amount) {
        if (_amount > getBalance() || getUsedLimit() + _amount > getLimit()) {
            System.out.print("Error. Insufficient funds or exceeded credit limit");
            return false;
        } else {
            setUsedLimit(getUsedLimit() + _amount);
            setBalance(getBalance() - _amount);
            return true;
        }
    }
}
